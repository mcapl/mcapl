package ajpf.psl.ast;

import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.Next;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_Next implements Abstract_Property {

    private Abstract_Property next_fmla;

    public Abstract_Next(Abstract_Property p) {
        next_fmla = p;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(" X ").append(next_fmla.toString());
        return s.toString();
    }

    @Override
    public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
        return new Next(next_fmla.toMCAPL(mas, c));
    }

    @Override
    public MCAPLProperty toMCAPLNative() {
        return new Next(next_fmla.toMCAPLNative());
    }

    @Override
    public int newJPFObject(MJIEnv env) {
        int ref = env.newObject("ajpf.psl.ast.Abstract_Next");
        env.setReferenceField(ref, "next_fmla", next_fmla.newJPFObject(env));
        return ref;
    }

    @Override
    public Abstract_Property toNormalForm() {
        return new Abstract_Next(next_fmla.toNormalForm());
    }

    @Override
    public Abstract_Property negate() {
        return new Abstract_Next(next_fmla.negate());
    }
}
