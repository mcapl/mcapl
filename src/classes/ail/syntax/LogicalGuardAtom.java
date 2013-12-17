package ail.syntax;

import java.util.List;

public interface LogicalGuardAtom extends GuardAtom, LogicalFormula {
    public Predicate getLogicalContent();
    
    public LogicalGuardAtom clone();

}
