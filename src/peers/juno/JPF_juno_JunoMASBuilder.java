package juno;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import juno.semantics.Abstract_JunoAgent;
import juno.semantics.JunoAgent;

public class JPF_juno_JunoMASBuilder extends NativePeer {
    @MJI
    public static void parsefile__Ljava_lang_String_2__(MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            JunoAgent juno = new JunoAgent(masstring);
            Abstract_JunoAgent abs_juno = juno.toAbstract();
            int ref = abs_juno.newJPFObject(env);
            env.setReferenceField(objref, "abs_juno", ref);
            env.setBooleanField(objref, "has_abstract", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("finished parsing");
    }
}
