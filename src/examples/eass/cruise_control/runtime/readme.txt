Program in Example 1 of Paper: car_singlelane_2017.eass

Property file: motorway.psl (one level up)

Property P1 in paper: motorway.psl property 5

Running example in simulation: safe_or_accelerate.ail

Verify in Handcoded env: standard_safe.jpf
Handcoded env: MotorWayVerificationEnv.java

Verify in Unstructured env: trace_as_unstructured.jpf
Automatically Generated Unstructured Env: TraceAsUnstructuredEnv.java

Running unsafe example in simluation with monitor: two_constraints_unsafe.ail, safe_or_accelerate.ail

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

Prolog Files
============

prolog_files - aec_ld.pl (copied from Dropbox (most recent I think))
             - trace_expression.pl (copied from Dropbox (most recent I think))
             - trace_expression_paper.pl (is not the same as trace_expression.pl which is a worry)