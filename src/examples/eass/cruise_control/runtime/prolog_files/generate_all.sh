#----------------------------------------------------------------------------
# Copyright (C) 2018 Louise A. Dennis, Angelo FerrandoDavide Ancona, Michael Fisher and Viviana Mascardi
#
# This file is part of Runtime Verification for MCAPL (RVMCAPL) Library.
#
# The RVMCAPL Library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 3 of the License, or (at your option) any later version.
#
# Gwendolen is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public
# License along with Gwendolen; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
#
# To contact the authors:
# http://www.csc.liv.ac.uk/~lad
#
#----------------------------------------------------------------------------

swipl -l generate_env.pl -g generate_env\(as_jpf\,\'TraceAsUnstructuredEnv\'\,\'as_jpf.pl\'\). -g halt
swipl -l generate_env.pl -g generate_env\(two_constraints\,\'TwoConstraints\'\,\'two_constraints.pl\'\). -g halt
swipl -l generate_env.pl -g generate_env\(safe_or_accelerate\,\'SafeOrAccelerate\'\,\'safe_or_accelerate.pl\'\). -g halt
swipl -l generate_env.pl -g generate_env\(brake_or_accelerate,\'BrakeOrAccelerate\'\,\'brake_or_accelerate.pl\'\). -g halt

mv -v TraceAsUnstructuredEnv.java ../.
mv -v TwoConstraints.java ../.
mv -v SafeOrAccelerate.java ../.
mv -v BrakeOrAccelerate.java ../BrakeOrAccelerate.java

