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

import ail.semantics.AILAgent;
import ail.syntax.annotation.SourceAnnotation;
import ail.syntax.ast.GroundPredSets;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
import gov.nasa.jpf.annotation.FilterField;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ActionLog {

    ArrayList<ActionLogEntry> al = new ArrayList<>();

    /**
     * Number of entries.
     */
    @FilterField
    private int size = 0;

    /**
     * Getter for the number of entries.
     * @return number of entries.
     */
    public int size() {
        return size;
    }

    public void add(ActionLogEntry e) {
        al.add(e);
    }

    public void add(DurativeAction a, BeliefBase preb, BeliefBase postb, Byte s) {
        ActionLogEntry e = new ActionLogEntry(a, preb, postb, s);
        al.add(e);
    }

    /**
     * Completely clear out this self model.
     */
    public void clear() {
    	al = new ArrayList<>();
    }

 
    /**
     * Check whether the self model contains something with a particular
     * predicate indicator.
     * @param e Action Log Entry
     * @return true if the entry is found in the action log, false if not.
     */
    public boolean contains(ActionLogEntry e) {
    	if (al == null) {
    		return false;
    	} else if (al.contains(e)){
    		return true;
    	} else {
    	    return false;
        }
    }

    /**
     * Convert the self model into a string for printing.
     *
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ActionLogEntry a: al) {
            s.append(a.toString());
        }
    	return s.toString();
     }

    public int checkLogFor(byte o) {
        int n = 0;
        for (ActionLogEntry a: al) {
            if (a.getActionOutcome() == o) {n++;}
        }
        return n;
    }

    }


