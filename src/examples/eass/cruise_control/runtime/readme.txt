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

Prolog Installation
===================
To use the prolog parts of Runtime Verification you will need to install swi-prolog - a version which includes the JPL library for linking with Java.  jpl.jar is included in the lib/3rdparty directory of the MCAPL distribution but when running this needs to be passed the location of the native library (probably /swipl/packages/jpl ) as an argument.  This can be configured in Eclipse (if being used) by editing the library include in Java Build path.


Files
=====

Program in Example 1 of Paper: car_singlelane_2017.eass

Property file: motorway.psl (one level up)

Property P1 in paper: motorway.psl property 5

Running example in simulation: standard_safe.ail
Connect  to Remote Motorway (Run Configuration in Eclipse) or motorwaysim.MotorwayComplexMain with remote_motorway_config.txt as configuration file.

Verify in Handcoded env: standard_safe.jpf
Handcoded env: MotorWayVerificationEnv.java

Verify in Unstructured env: trace_as_unstructured.jpf
Automatically Generated Unstructured Env: TraceAsUnstructuredEnv.java

Running unsafe example in simulation with monitor: two_constraints_unsafe.ail, safe_or_accelerate_unsafe.ail

Verify in Env from Figure 5: two_constraints_verification_safe.ail
Env: TwoConstraints.java

Modified Program where system can not override driver: car_single_lane_unsafe_2017.eass

(Fail to) Verify in Handcoded Env: standard_unsafe.jpf

Verify in Env from Figure 5: two_constrains_unsafe.jpf

Other files
===========

safe_or_accelerate* Files for environments where the driver only accelerates when it is safe
brake_or_accelerate* Files for environments where driver never brakes and accelerates

(sub-problems of one in paper).

Prolog Files Directory
=====================

prolog_files directory

as_jpf.pl, brake_or_accelerate.pl, safe_or_accelerate.pl, two_constraints.pl contain the trace expressions used in each case.

generate_env.pl contains a predicate for generate_env/3 where the first argument is the name of the trace_expression (as used in the trace expression file), FileName is the name of the java environment to be created an TraceExpressionFile is the name of the trace expression prolog file to be used.  This will then create example environments to be used withh cruise_control.runtime

generate_all.sh will generate the four example environments and copy them to the right  place.

Generate Environments
=====================

You generate environments using abstract_environment_compiler (monitor/prolof_files) and a trace expression.  See generate_env.pl for example

Runtime Monitoring
==================

Use MotorwayComplexMain with remote_motorway_config.txt as (configuration) - There is an Eclipse Runtime Configuration for this.

Run your example using RemoteMotorwayEnvironment as the environment and configured with

trace_expression_file = path-from-mcapl to trace_expression file
monitor_log_file = path-from-mcapl to where you want the logfile
protocol = two_constraints (name of the trace expression).

See two_constraints.ail as an example.