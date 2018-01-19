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

public class TraceAsUnstructuredEnv extends EASSVerificationEnvironment {
   public String logname = "eass.cruise_control.runtime.TraceAsUnstructuredEnv";




   Predicate driver_brakes = new Predicate("driver_brakes");

   
   Predicate driver_accelerates = new Predicate("driver_accelerates");

   
   Predicate at_speed_limit = new Predicate("at_speed_limit");

   
   Predicate safe = new Predicate("safe");

   

   public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }


   public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {

      Set<Predicate> predicates = new TreeSet<Predicate>();

            int assert_random_int = random_int_generator.nextInt(16);
      if (assert_random_int ==0) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==1) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==2) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==3) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
      }
      if (assert_random_int ==4) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==5) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==6) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==7) {
         //addPercept(safe);
         AJPFLogger.info(logname, "Asserting safe");
         predicates.add(safe);
      }
      if (assert_random_int ==8) {
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==9) {
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==10) {
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==11) {
         //addPercept(at_speed_limit);
         AJPFLogger.info(logname, "Asserting at_speed_limit");
         predicates.add(at_speed_limit);
      }
      if (assert_random_int ==12) {
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==13) {
         //addPercept(driver_accelerates);
         AJPFLogger.info(logname, "Asserting driver_accelerates");
         predicates.add(driver_accelerates);
      }
      if (assert_random_int ==14) {
         //addPercept(driver_brakes);
         AJPFLogger.info(logname, "Asserting driver_brakes");
         predicates.add(driver_brakes);
      }
      if (assert_random_int ==15) {
      }

      return predicates;
      }


   public Set<Message> generate_messages(String agName, Action act) { return new TreeSet<Message>(); }

   public Set<Message> add_random_messages(String agName, Action act) {
      Set<Message> messages = new TreeSet<Message>();
      return messages;
   }

}
