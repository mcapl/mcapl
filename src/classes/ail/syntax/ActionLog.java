// ----------------------------------------------------------------------------
// Copyright (C) 2008-2015 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of the Agent Infrastructure Layer (AIL)
//
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import ca.odell.glazedlists.impl.adt.CircularArrayList;
import gov.nasa.jpf.annotation.FilterField;
import org.apache.commons.collections15.buffer.CircularFifoBuffer;

import java.lang.reflect.Array;
import java.util.*;

public class ActionLog {
   // ArrayList<ActionLogEntry> al = new ArrayList<>();

 ArrayList<ActionLogEntry> al = new ArrayList<ActionLogEntry>();

    /**
     * Number of entries.
     */
    @FilterField
    private int sizelimit = 15;

    /**
     * Setter for size limit of the action log
     *
     * Action Log size limit can be changed during execution, requiring a while loop for 'popping' logs to ensure the limit is corrected if changed.
     */
    public void setSizeLimit(int i){
        sizelimit = i;
    }

    /**
     * Pops the log with index 0 in a loop until the size limit is met.
     *
     * Action Log size limit can be changed during execution, requiring a while loop for 'popping' logs to ensure the limit is corrected if changed.
     */
    public void pop() {
        while (al.size() >= sizelimit) {
            al.remove(0);
        }
    }

    public void add(ActionLogEntry e) {
        pop();
        al.add(e);
    }

    public void add(DurativeAction a, BeliefBase preb, BeliefBase postb, Byte s) {
        ActionLogEntry e = new ActionLogEntry(a, preb, postb, s);
        pop();
        al.add(e);
    }

    /**
     * Completely clear out this self model.
     */
    public void clear() {
        al = new ArrayList<>();
        sizelimit = 25;
    }


    /**
     * Check whether the self model contains something with a particular
     * predicate indicator.
     *
     * @param e Action Log Entry
     * @return true if the entry is found in the action log, false if not.
     */
    public boolean contains(ActionLogEntry e) {
        if (al == null) {
            return false;
        } else if (al.contains(e)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Convert the self model into a string for printing.
     * @return a string of action log entries.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ActionLogEntry a : al) {
            s.append(a.toString());
        }
        return s.toString();
    }

    public int checkLogFor(byte o) {
        int n = 0;
        for (ActionLogEntry a : al) {
            if (a.getActionOutcome() == o) {
                n++;
            }
        }
        return n;
    }

    public ActionLogEntry getLatestEntry() {
        ActionLogEntry entry = null;
        for (ActionLogEntry e : al) {
            entry = e;
        }
        return entry;
    }

    public ActionLog getLogsForAction(ActionLogEntry actionLogEntry) {
        ActionLog singleActionLog = new ActionLog();
        for (ActionLogEntry entry : al) {
            if (entry.action == actionLogEntry.action) {
                singleActionLog.add(entry);
                if (entry.getActionOutcome() == ActionLogEntry.actionSucceeded) {
                    singleActionLog.removeEntry(entry);
                }
            }
        }
        return singleActionLog;
    }


    public ActionLog getLogsFor(ActionLogEntry actionLogEntry) {
        ActionLog singleActionLog = new ActionLog();
        for (ActionLogEntry entry : al) {
            if (entry == actionLogEntry) {
                singleActionLog.add(entry);
            }
        }
        return singleActionLog;
    }

    /** get the logs for matching entries
     *
     * @param outcome
     * @param actionLog
     * @return action log containing only matching entries
     */
    public ActionLog getLogsFor(byte outcome, ActionLog actionLog){
        ActionLog filteredLog = new ActionLog();
        for (ActionLogEntry entry : actionLog.getArrayList()){
            if (entry.getActionOutcome() == outcome){
                filteredLog.add(entry);
            }
        }
        return filteredLog;
    }

    /** get the action log as an array list
     *
     * @return al the action log as an arraylist
     */
    public ArrayList<ActionLogEntry> getArrayList(){
        ArrayList arrayList = new ArrayList();
        for (ActionLogEntry actionLogEntry: al){
            arrayList.add(actionLogEntry);
        }
        return arrayList;
    }
    
    public void removeEntry(ActionLogEntry e){
       if (al.contains(e)){
           al.remove(e);
       }
    }

}


