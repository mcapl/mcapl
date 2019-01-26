/* ----------------------------------------------------------------------------
* Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
*
* This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
* 
* The RVMCAPL Library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
* 
* The EASS Library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with the EASS Library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
* 
* To contact the authors:
* http://www.csc.liv.ac.uk/~lad
*
* ----------------------------------------------------------------------------*/

trace_expression(two_constraints, Protocol, NotAction, SingleStepProtocol, Constraints) :-
        Safe = ((bel(safe):epsilon) \/ (not_bel(safe):epsilon) \/ epsilon),
        AtSpeedLimit =((bel(at_speed_limit):epsilon) \/ (not_bel(at_speed_limit):epsilon) \/ epsilon),
        Accelerates = ((bel(driver_accelerates):epsilon) \/ (not_bel(driver_accelerates):epsilon) \/epsilon),
        Brakes = ((bel(driver_brakes):epsilon) \/ (not_bel(driver_brakes):epsilon) \/epsilon),
        ProtocolBel = (Safe|AtSpeedLimit|Accelerates|Brakes),
        ProtocolMsg = epsilon,

        NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action

        SingleStepProtocol = (action(any_action):((ProtocolBel) | ProtocolMsg) * NotAction),
        NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,

        Protocol = NotAction * (NewActionStepProtocol/\Constraints),

        Constraints = (brake_or_accelerate>>BrakeOrAccelerate) /\ (accelerates_or_safe>>CantAccel),
        CantAccel = (bel(safe):CanAccelOrBeUnsafe) \/ (((not_bel(safe):epsilon) \/ (not_bel(driver_accelerates):epsilon)) * CantAccel),
        CanAccelOrBeUnsafe = (bel(driver_accelerates):CanAccel) \/ (((not_bel(driver_acclerates):epsilon) \/ (bel(safe):epsilon)) * CanAccelOrBeUnsafe) \/ (not_bel(safe):CantAccel),
        CanAccel = (not_bel(driver_accelerates):CanAccelOrBeUnsafe) \/ (((bel(safe):epsilon) \/ (bel(driver_accelerates):epsilon)) * CanAccel),
				BrakeOrAccelerate = (bel(driver_accelerates):AccelOnly) \/ (((not_bel(driver_accelerates):epsilon) \/ (not_bel(driver_brakes):epsilon)) * BrakeOrAccelerate) \/ (bel(driver_brakes):BrakeOnly),
				AccelOnly = (not_bel(driver_accelerates):BrakeOrAccelerate) \/ (((bel(driver_accelerates):epsilon) \/ (not_bel(driver_brakes):epsilon)) * AccelOnly),
				BrakeOnly = (not_bel(driver_brakes):BrakeOrAccelerate) \/ (((bel(driver_brakes):epsilon) \/ (not_bel(driver_accelerates):epsilon)) * BrakeOnly).

