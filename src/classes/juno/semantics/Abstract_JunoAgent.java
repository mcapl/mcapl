package juno.semantics;
/**
 * Generic Description of Abstract Classes in AIL and AJPF
 * -------------------------------------------------------
 *
 * We use "Abstract" versions of syntax items for all bits of state that we sometimes wish to store in the native
 * java VM as well in the JavaPathfinder VM.  In particular files are parsed into the native VM and then the relevant
 * initial state of the multi-agent system is reconstructed in the model-checking VM.  This is done to improve
 * efficiency of parsing (the native VM is faster).  We also represent properties for model checking in the native VM
 * and, indeed the property automata is stored only in the native VM.  We used Abstract classes partly because less
 * computational content is needed for these objects in the native VM and so a smaller representation can be used
 * but also because specific support is needed for transferring information between the two virtual machines both
 * in terms of methods and in terms of the data types chosen for the various fields.  It was felt preferable to
 * separate these things out from the classes used for the objects that determine the run time behaviour of a MAS.
 *
 * Abstract classes all have a method (toMCAPL) for creating a class for the equivalent concrete object used
 * when executing the MAS.  They also have a method (newJPFObject) that will create an equivalent object in the
 * model-checking virtual machine from one that is held in the native VM.  At the start of execution the agent
 * program is parsed into abstract classes in the native VM.  An equivalent structure is then created in the JVM
 * using calls to newJPFObject and this structure is then converted into the structures used for executing the MAS
 * by calls to toMCAPL.
 *
 */

/*
Specific notes for this abstract class.  Note this is slightly different from most since it isn't using the AIL formula
tools.  It is primarily needed because the JPF version for Java 11 can't handle some parsing functions in the JPF JVM
and I wasn't clear how to handle ArrayLists and Map classes through the MJI interface.  Hence I have an abstract class
which uses array and arrays of tuples for the arraylists and maps.  In the Native  JVM We parse the input file into a
Juno Agent - transform the Juno Agent to an Abstract Juno Agent, reconstruct the abstract agent in the JPF JVM and then
create a Juno Agent from that Abstract Agent.  This is a tortuous process and ideally we wouldn't have the abstract agent
at all - just reconstruct the Juno Agent directly - but we are where we are.
 */
import gov.nasa.jpf.vm.MJIEnv;

import ail.util.Tuple;
import hera.language.Formula;
import hera.language.FormulaString;

public class Abstract_JunoAgent {
    public String[] action_array;

    public Tuple<String, Double>[] utility_map;
    public Tuple<String, Double>[] default_utility_map;
    public Tuple<Formula, Tuple<String, Double>[]>[] abstract_context_utilities;

    public String[] goalbase_array;
    String[] default_goals_array;
    public Tuple<Formula, String[]>[] abstract_context_goals;

    String[] abstract_patients;

    public Tuple<String, Tuple<String, String>[]>[] abstract_affects;
    public Tuple<String, Tuple<String, String>[]>[] default_abstract_affects;
    public Tuple<Formula, Tuple<String, Tuple<String, String>[]>[]>[] abstract_context_affects;

    String[] abstract_consequences;

    Tuple<String, Formula>[] abstract_mechanisms;

    String[] abstract_background;

    Tuple<Formula, FormulaString>[] abstract_context_background;

    public int newJPFObject(MJIEnv env) {
        int objref = env.newObject("juno.semantics.Abstract_JunoAgent");

        arraylist_string(action_array, "action_array", objref, env);

        int uRef = env.newObjectArray("ail.util.Tuple", utility_map.length);
        string_double_tuple_array(utility_map, uRef, env);
        env.setReferenceField(objref, "utility_map", uRef);

        int duRef = env.newObjectArray("ail.util.Tuple", default_utility_map.length);
        string_double_tuple_array(default_utility_map, duRef, env);
        env.setReferenceField(objref, "default_utility_map", duRef);

        int cuRef = env.newObjectArray("ail.util.Tuple", abstract_context_utilities.length);
        for (int i = 0; i < abstract_context_utilities.length; i++) {
            Tuple<Formula, Tuple<String, Double>[]> tuple = abstract_context_utilities[i];
            int fRef = tuple.getLeft().newJPFObject(env);
            int tRef = env.newObjectArray("ail.util.Tuple", tuple.getRight().length);
            string_double_tuple_array(tuple.getRight(), tRef, env);
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", fRef);
            env.setReferenceField(finalRef, "right", tRef);
            env.setReferenceArrayElement(cuRef, i, finalRef);
        }
        env.setReferenceField(objref, "abstract_context_utilities", cuRef);

        arraylist_string(goalbase_array, "goalbase_array", objref, env);

        arraylist_string(default_goals_array, "default_goals_array", objref, env);

        int cgRef = env.newObjectArray("ail.util.Tuple", abstract_context_goals.length);
        for (int i = 0; i < abstract_context_goals.length; i++) {
            Tuple<Formula, String[]> tuple = abstract_context_goals[i];
            int fRef = tuple.getLeft().newJPFObject(env);
            int tRef = env.newObjectArray("java.lang.String", tuple.getRight().length);
            for (int j = 0; j < tuple.getRight().length; j++) {
                env.setReferenceArrayElement(tRef, j, env.newString(tuple.getRight()[j]));
            }
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", fRef);
            env.setReferenceField(finalRef, "right", tRef);
            env.setReferenceArrayElement(cgRef, i, finalRef);
        }
        env.setReferenceField(objref, "abstract_context_goals", cgRef);

        arraylist_string(abstract_patients, "abstract_patients", objref, env);

        int aRef = map_string_tuple_string(abstract_affects, objref, env);
        env.setReferenceField(objref, "abstract_affects", aRef);

        int daRef = map_string_tuple_string(default_abstract_affects, objref, env);
        env.setReferenceField(objref, "default_abstract_affects", daRef);

        int caRef = env.newObjectArray("ail.util.tuple", abstract_context_affects.length);
        for (int i = 0; i < abstract_context_affects.length; i++) {
            Tuple<Formula, Tuple<String, Tuple<String, String>[]>[]> tuple = abstract_context_affects[i];
            int fRef = tuple.getLeft().newJPFObject(env);
            int tRef = map_string_tuple_string(tuple.getRight(), objref, env);
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", fRef);
            env.setReferenceField(finalRef, "right", tRef);
            env.setReferenceArrayElement(caRef, i, finalRef);
        }
        env.setReferenceField(objref, "abstract_context_affects", caRef);

        arraylist_string(abstract_consequences, "abstract_consequences", objref, env);

        int mRef = env.newObjectArray("ail.util.Tuple", abstract_mechanisms.length);
        for (int i = 0; i < abstract_mechanisms.length; i++) {
            int sRef = env.newString(abstract_mechanisms[i].getLeft());
            int fRef = abstract_mechanisms[i].getRight().newJPFObject(env);
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", sRef);
            env.setReferenceField(finalRef, "right", fRef);
            env.setReferenceArrayElement(mRef, i, finalRef);
        }
        env.setReferenceField(objref, "abstract_mechanisms", mRef);

        arraylist_string(abstract_background, "abstract_background", objref, env);

        int cbRef = env.newObjectArray("ail.util.Tuple", abstract_context_background.length);
        for (int i = 0; i < abstract_context_background.length; i++) {
            int fRef = abstract_context_background[i].getLeft().newJPFObject(env);
            int fsRef = abstract_context_background[i].getRight().newJPFObject(env);
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", fRef);
            env.setReferenceField(finalRef, "right", fsRef);
            env.setReferenceArrayElement(cbRef, i, finalRef);
        }
        env.setReferenceField(objref, "abstract_context_background", cbRef);

        return objref;
    }

    void string_double_tuple_array(Tuple[] array, int objref, MJIEnv env) {
        for (int i = 0; i<array.length; i++) {
            Tuple<String, Double> tuple = array[i];
            int tRef = tuple.newJPFStringDouble(env);
            env.setReferenceArrayElement(objref, i, tRef);
        }
    }

    void string_string_tuple_array(Tuple[] array, int objref, MJIEnv env) {
        for (int i = 0; i<array.length; i++) {
            Tuple<String, String> tuple = array[i];
            int tRef = tuple.newJPFStringString(env);
            env.setReferenceArrayElement(objref, i, tRef);
        }
    }

    void arraylist_string(String[] array, String array_name, int objref, MJIEnv env) {
        int ref = env.newObjectArray("java.lang.String", array.length);
        for (int i = 0; i< array.length; i++) {
            env.setReferenceArrayElement(ref, i, env.newString(array[i]));
        }
        env.setReferenceField(objref, array_name, ref);
    }

    int map_string_tuple_string(Tuple<String, Tuple<String, String>[]>[] map, int objref, MJIEnv env) {
        int mRef = env.newObjectArray("ail.util.Tuple",map.length);
        for (int i = 0; i < map.length; i++) {
            Tuple<String, Tuple<String, String>[]> tuple = map[i];
            int lRef = env.newString(tuple.getLeft());
            int rRef = env.newObjectArray("ail.util.Tuple", tuple.getRight().length);
            string_string_tuple_array(tuple.getRight(), rRef, env);
            int finalRef = env.newObject("ail.util.Tuple");
            env.setReferenceField(finalRef, "left", lRef);
            env.setReferenceField(finalRef, "right", rRef);
            env.setReferenceArrayElement(mRef, i, finalRef);
        }
        return mRef;
    }

}
