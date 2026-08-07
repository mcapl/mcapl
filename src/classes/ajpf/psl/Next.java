package ajpf.psl;

import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.TreeSet;

public class Next implements MCAPLProperty {
    private MCAPLProperty next;

    private boolean keepinold = false;

    private int hashcode;

    public Next(MCAPLProperty p) {
        next = p;
    }
    @Override
    /**
     * Whether this is a true or not an atomic proposition.  This is a temporal
     * property so returns true.
     */
    public boolean check() {
        return true;
    }

    @Override
    public boolean check(Set<Proposition> props) {
        return true;
    }

    @Override
    public boolean isUntil() {
        return false;
    }

    @Override
    public boolean isRelease() {
        return false;
    }

    @Override
    public boolean isContradiction(Set<MCAPLProperty> props) {
        return false;
    }

    @Override
    public boolean splitsAutomataState() {
        return false;
    }

    @Override
    public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoOld() {
        TreeSet<MCAPLProperty> old = new TreeSet<MCAPLProperty>();
        old.add(this);
        return old;
    }

    @Override
    public Set<MCAPLProperty> addtoOld1() {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoOld2() {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoNext() {
        TreeSet<MCAPLProperty> new_next = new TreeSet<MCAPLProperty>();
        new_next.add(next);
        return new_next;
    }

    @Override
    public Set<MCAPLProperty> addtoNext1() {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public Set<MCAPLProperty> addtoNext2() {
        return (new TreeSet<MCAPLProperty>());
    }

    @Override
    public MCAPLProperty negate() {
        return new Next(next.negate());
    }

    @Override
    public Set<Proposition> getProps() {
        TreeSet<Proposition> props = new TreeSet<Proposition>();
        props.addAll(next.getProps());
        return props;
    }

    @Override
    public Set<Until> getUntils() {
        TreeSet<Until> props = new TreeSet<Until>();
        props.addAll(next.getUntils());
        return props;
    }

    @Override
    public boolean keepInOld() {
        return keepinold;
    }

    @Override
    public void noteKeep() {
        keepinold = true;
        next.noteKeep();
    }

    @Override
    public int quickCompareVal() {
        return 19;
    }

    public MCAPLProperty getNext() {
        return next;
    }

    @Override
    public int compareTo(@NotNull MCAPLProperty o) {
        if (o instanceof Next) {
            return next.compareTo(((Next) o).getNext());
        } else {
            int myq = quickCompareVal();
            int pq = o.quickCompareVal();

            if (myq < pq) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String toString() {
        String s = "X " + next.toString();
        return s;
    }

    public boolean equals(Object phi) {
        if (phi instanceof Next) {
            return (((Next) phi).getNext().equals(next));
        }

        return false;
    }
    public int hashCode() {
        return hashcode;
    }

}
