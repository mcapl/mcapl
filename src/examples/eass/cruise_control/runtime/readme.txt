// ----------------------------------------------------------------------------
// Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
//
// This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
// 
// The RVMCAPL Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// ----------------------------------------------------------------------------


These are example files and results for the experiments reported in Recognising Assumption Violations in Autonomous Systems Verification by Ferrando et al, AAMAS 2018 (short paper).

This deposit consists of a tar.gz file containing the contents of eass.cruise_control.runtime package distributed as part of the mcapl framework (mcapl.sourceforge.net).  The version of the system used to generate these results can be found in the git distribution on sourceforge in the branch tagged runtime_verification.

Agent Files
============

The experiments investigate two different implementations of a rational agent cruise control.

car_singlelane_2017.eass - is a rational agent implementation of a cruise control that reacts to the perceptions at_speed_limit, safe, driver_brakes and driver_accelerates
car_singlelane_unsafe_2017.eass - is an identical implementation but with the constraint that the car only accelerates if it safe to do so (irrespective of what the driver is doing) removed.

Prolog Files
============

Four trace expressions have been used to generate Java environments for verifying these programs.  The trace expressions can be found in the directory prolog_files.

as_jpf.pl (represents an unstructured environment - see the paper for an explanation)
brake_or_acclerate.pl (represents an environment where the driver never brakes and accelerates at the same time)
safe_or_acclerate.pl (represents an environment were the driver only accelerates when it is safe to do so)
two_constraints.pl (represents an environment embodying both these constraints).

generate_all.sh is a script that will generate Java environments from these trace expressions.  The environments generated are

Java Files
==========

TraceAsUnstructuredEnv.java (from as_jpf.pl)
BrakeOrAccelerate.java (from brake_or_accelerate.pl)
SafeOrAcclerate.java (from safe_or_accelerate.pl)
TwoConstraints.java (from two_constraints.pl)

MotorWayVerificationEnv.java  is a hand-constructed unstructured environment for static verification.

RemoteMotorwayEnvironment.java is an enviroment that will connect to a motorway simulation for runtime verification.  The simulation in question is MotorwayComplexMain in the motorwaysim package of the MCAPL distribution.

AIL Files
=========

brake_or_accelerate_verification.ail - runs the safe agent in the BrakeOrAccelerate static verification environment
safe_or_accelerate_verification.ail - runs the safe agent in the SafeOrAcccelerate static verification environment
safe_or_accelerate_verification_unsafe.ail - runs the unsafe agent in the SafeOrAcccelerate static verification environment
standard_safe.ail - runs the safe agent in the RemoteMotorwayEnvironment with a monitor supplied by as_jpf.pl
standard_verification_safe.ail - runs the safe agent in the MotorWayVerificationEnv static verification environment
standard_verification_unsafe.ail - runs the unsafe agent in the MotorWayVerificationEnv static verification environment
trace_as_unstructured.ail - runs the safe agent in the TraceAsUnstructuredEnv static verification environment
two_constraints_unsafe.ail - runs the unsafe agent in the RemoteMotorwayEnvironment with a monitor supplied by two_constraints.pl
two_constraints_verifiction_safe.ail - runs the safe agent in the TwoConstraints static verification environment
two_constraints_verification_unsafe.ail - runs the unsafe agent in the TwoConstraints static verification environment
two_constraints.ail - runs the safe agent in the RemoteMotorwayEnvironment with a monitor supplied by two_constraints.pl

JPF Files
=========

brake_or_acclerate.jpf verifies brake_or_accelerate_verification.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
safe_or_accelerate.jpf verifies safe_or_accelerate_verification.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
safe_or_accelerate_unsafe.jpf verifies safe_or_accelerate_verification_unsafe.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
standard_safe.jpf verifies standard_verification_safe.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
standard_unsafe.jpf verifies standard_verification_unsafe.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
trace_as_unstructured.jpf verifies trace_as_unstructured.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
two_constraints_safe.jpf verifies two_constraints_verification_safe.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))
two_constraints_unsafe.jpf verifies two_constraints_verification_unsafe.ail against the property [] (B(car0,safe) -> [] (<> (B(car0, safe) || B(car0, braking))))

Results
========
The results directory contains

static_verification_results.txt - output from all verification runs of the JPF files.
as_jpf_monitor_log.txt - output of the runtime monitor on standard_safe.ail
two_constraints_monitor_log.txt - output of the runtime monitor on two_constraints_unsafe.ail


Other Files
===========

remote_motorway_config.txt - configuration file for RemoteMotorwayEnvironment.java
motorway.psl - property specification file for the experiements.
prolog_files/generate_env.pl contains a predicate for generate_env/3 where the first argument is the name of the trace_expression (as used in the trace expression file), FileName is the name of the java environment to be created an TraceExpressionFile is the name of the trace expression prolog file to be used.  This will then create example environments to be used withh cruise_control.runtime


BRIEF INSTRUCTIONS

Prolog Installation
===================
To use the prolog parts of Runtime Verification you will need to install swi-prolog - a version which includes the JPL library for linking with Java.  jpl.jar is included in the lib/3rdparty directory of the MCAPL distribution but when running this needs to be passed the location of the native library (probably /swipl/packages/jpl ) as an argument.  This can be configured in Eclipse (if being used) by editing the library include in Java Build path.


Generate Environments
=====================

You generate environments using abstract_environment_compiler (monitor/prolog_files) and a trace expression.  See generate_env.pl for example

Runtime Monitoring
==================

Use MotorwayComplexMain with remote_motorway_config.txt as (configuration) - There is an Eclipse Runtime Configuration for this in the mcapl distribution

Run your example using RemoteMotorwayEnvironment as the environment and configured with

trace_expression_file = path-from-mcapl to trace_expression file
monitor_log_file = path-from-mcapl to where you want the logfile
protocol = two_constraints (name of the trace expression).

See two_constraints.ail as an example.