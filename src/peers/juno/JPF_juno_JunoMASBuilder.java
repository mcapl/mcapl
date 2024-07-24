package juno;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import juno.semantics.JunoAgent;

public class JPF_juno_JunoMASBuilder extends NativePeer {
    @MJI
    public static void parsefile__Ljava_lang_String_2__(MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            JunoAgent juno = new JunoAgent(masstring);
            int ref = juno.newJPFObject(env);
            env.setReferenceField(objref, "juno", ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
