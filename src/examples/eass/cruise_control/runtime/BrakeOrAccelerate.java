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

public class BrakeOrAccelerate extends EASSVerificationEnvironment {
   public String logname = "eass.cruise_control.runtime.BrakeOrAccelerate";




   public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }


   public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {

      boolean assert_belief;
      int assert_random_int;
      Set<Predicate> predicates = new TreeSet<Predicate>();

      Predicate driver_brakes = new Predicate("driver_brakes");

      
      Predicate driver_accelerates = new Predicate("driver_accelerates");

      
      Predicate at_speed_limit = new Predicate("at_speed_limit");

      
      Predicate safe = new Predicate("safe");

      

            assert_random_int = random_int_generator.nextInt(12);
      if (assert_random_int ==0) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         driver_accelerates = new Predicate("driver_accelerates");
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==1) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         driver_brakes = new Predicate("driver_brakes");
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==2) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
      }
      if (assert_random_int ==3) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         driver_accelerates = new Predicate("driver_accelerates");
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==4) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         driver_brakes = new Predicate("driver_brakes");
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==5) {
         safe = new Predicate("safe");
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
      }
      if (assert_random_int ==6) {
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         driver_accelerates = new Predicate("driver_accelerates");
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==7) {
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         driver_brakes = new Predicate("driver_brakes");
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==8) {
         at_speed_limit = new Predicate("at_speed_limit");
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
      }
      if (assert_random_int ==9) {
         driver_accelerates = new Predicate("driver_accelerates");
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==10) {
         driver_brakes = new Predicate("driver_brakes");
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==11) {
      }

      return predicates;
      }


   public Set<Message> generate_messages(String agName, Action act) { return new TreeSet<Message>(); }

   public Set<Message> add_random_messages(String agName, Action act) {
      Set<Message> messages = new TreeSet<Message>();
      boolean assert_belief;
      int assert_random_int;

      return messages;
   }

}
