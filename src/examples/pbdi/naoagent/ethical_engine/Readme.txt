// ----------------------------------------------------------------------------
// Copyright (C) 2019 Louise A. Dennis, Paul Bremner, Alan F. Winfield and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The PBDI Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the PBDI Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

These are the files used for the verification of an Ethical NAO Robot as discussed 
in Bremner et. al `On Proactive, Transparent and VerifiableEthical Reasoning for Robots', 
IEEE Transactions (to appear)

The paper has two tables of results (Tables II and III) plus the discussion of a failed verification of equation 7.

Table II
--------
The results in Table II were generated using october2017_agentonly.pbdi as the program under consideration, 
2plan_case.ail as the configuration file, EthicalEngineEnv_Unconstrained.java as the environment, and 
2plan_case_firstlaw.jpf to produce the result for property 4, 2plan_case_secondlaw.jpf to produce the result
for property 5, and 2plan_case_thirdlaw.jpf to produce the result for property 6.

Table III
---------
The results in Table II were generated using october2017_agentonly.pbdi as the program under consideration, 
3plan_case.ail as the configuration file, EthicalEngineEnv.java as the environment, and 3plan_case_firstlaw.jpf 
to produce the result for property 4,  3plan_case_secondlaw.jpf to produce the result for property 5, and 
3plan_case_thirdlaw.jpf to produce the result for property 6.

Equation 7
----------
The failed verification of equation 7 used october2017_agentonly.pbdi as the program under consideration, 
3plan_case.ail as the configuration file, EthicalEngineEnv_Unconstrained_3Plans.java as the environment, and
property7inpaper.jpf to run the verification.


october2017.pbdi is the full Python program from which october2017_agentonly.pbdi was extracted.