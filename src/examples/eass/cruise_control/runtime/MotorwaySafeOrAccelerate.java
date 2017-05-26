package eass.cruise_control.runtime;

import java.util.Set;
import java.util.TreeSet;
import eass.mas.verification.EASSVerificationEnvironment;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.ast.GroundPredSets;
import ail.syntax.NumberTermImpl;
import ail.syntax.Message;

public class MotorwaySafeOrAccelerate extends EASSVerificationEnvironment {
public String logname = "eass.cruise_control.runtime.MotorwaySafeOrAccelerate";




public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }


public Set<Predicate> add_random_beliefs(String agName, Action act) {

boolean safe_b = false;
boolean at_speed_limit_b = false;
boolean driver_accelerates_b = false;
boolean driver_brakes_b = false;

boolean assert_belief;
int assert_random_int;
Set<Predicate> predicates = new TreeSet<Predicate>();

Predicate safe;
Predicate at_speed_limit;
Predicate driver_accelerates;
Predicate driver_brakes;

assert_belief = random_bool_generator.nextBoolean();
if(assert_belief){
safe = new Predicate("safe");
addPercept(safe);
AJPFLogger.info(logname, "Asserting safe");
safe_b = true;
predicates.add(safe);
}

assert_belief = random_bool_generator.nextBoolean();
if(assert_belief){
at_speed_limit = new Predicate("at_speed_limit");
addPercept(at_speed_limit);
AJPFLogger.info(logname, "Asserting at_speed_limit");
at_speed_limit_b = true;
predicates.add(at_speed_limit);
}

assert_belief = random_bool_generator.nextBoolean();
if(assert_belief){
assert_belief = random_bool_generator.nextBoolean();
if(assert_belief){
driver_accelerates = new Predicate("driver_accelerates");
if(safe_b){
addPercept(driver_accelerates);
AJPFLogger.info(logname, "Asserting driver_accelerates");
driver_accelerates_b = true;
predicates.add(driver_accelerates);
}} else{
driver_brakes = new Predicate("driver_brakes");
addPercept(driver_brakes);
AJPFLogger.info(logname, "Asserting driver_brakes");
driver_brakes_b = true;
predicates.add(driver_brakes);
}
}

return predicates;
}


public Set<Message> generate_messages() { return new TreeSet<Message>(); }

public Set<Message> add_random_messages(String agName, Action act) {
Set<Message> messages = new TreeSet<Message>();
boolean assert_belief;
int assert_random_int;



return messages;
}
}
