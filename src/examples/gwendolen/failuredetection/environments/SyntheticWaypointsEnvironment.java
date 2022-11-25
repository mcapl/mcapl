package gwendolen.failuredetection.environments;import ail.syntax.*;
import javafx.util.Pair;

import java.util.Hashtable;public class SyntheticWaypointsEnvironment extends ReconfigurationWaypointsEnvironment {Hashtable<Pair, Pair> failingactions = new Hashtable<>();Pair<String, String> actionTerms;static String logname = "gwendolen.failuredetection.SyntheticWaypointsEnvironment";public SyntheticWaypointsEnvironment() {super();

        capLibrary.add(moveW0W1);
        capLibrary.add(moveW0W3);
        capLibrary.add(moveW0W4);
        capLibrary.add(moveW1W0);
        capLibrary.add(moveW1W2);
        capLibrary.add(moveW1W3);
        capLibrary.add(moveW1W4);
        capLibrary.add(moveW1W5);
        capLibrary.add(moveW2W1);
        capLibrary.add(moveW2W4);
        capLibrary.add(moveW2W5);
        capLibrary.add(moveW3W0);
        capLibrary.add(moveW3W1);
        capLibrary.add(moveW3W4);
        capLibrary.add(moveW3W6);
        capLibrary.add(moveW3W7);
        capLibrary.add(moveW4W0);
        capLibrary.add(moveW4W1);
        capLibrary.add(moveW4W2);
        capLibrary.add(moveW4W3);
        capLibrary.add(moveW4W5);
        capLibrary.add(moveW4W6);
        capLibrary.add(moveW4W7);
        capLibrary.add(moveW4W8);
        capLibrary.add(moveW5W1);
        capLibrary.add(moveW5W2);
        capLibrary.add(moveW5W4);
        capLibrary.add(moveW5W7);
        capLibrary.add(moveW5W8);
        capLibrary.add(moveW6W3);
        capLibrary.add(moveW6W4);
        capLibrary.add(moveW6W7);
        capLibrary.add(moveW7W3);
        capLibrary.add(moveW7W4);
        capLibrary.add(moveW7W5);
        capLibrary.add(moveW7W6);
        capLibrary.add(moveW7W8);
        capLibrary.add(moveW8W4);
        capLibrary.add(moveW8W5);
        capLibrary.add(moveW8W7);
        Pair<Term, Term> a = new Pair<>(atW0, atW0);Pair<Term, Term> b = new Pair<>(atW0, atW0);failingactions.put(a,b);}

    public boolean checkAction(Action act) {Pair<Term, Term> actionTerms = new Pair<>(act.getTerm(0),act.getTerm(1));return (failingactions.containsKey(actionTerms));}@Override public void processMovement(String agName, Capability capability) {Action act = capability.getAction();Term origin = act.getTerm(0);Term destination = act.getTerm(1);Predicate new_position = new Predicate("at");Predicate old_position = new Predicate("at");if (checkAction(act)) {Pair newTerms = failingactions.get(actionTerms);new_position.addTerm((Term) newTerms.getValue());old_position.addTerm(origin);removePercept(old_position);addPercept(new_position);} else {new_position.addTerm(destination);old_position.addTerm(origin);removePercept(old_position);addPercept(new_position);}}}