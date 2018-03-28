#!/bin/bash

path_swipl=/opt/local/lib/swipl-7.2.3/lib/x86_64-darwin15.0.0/

export CLASSPATH=/Users/angeloferrando/git/mcapl/bin:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf-classes.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf-annotations.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpl.jar

javac CarOnMotorwayEnvironment.java -d /Users/angeloferrando/git/mcapl/bin/


export CLASSPATH=/Users/angeloferrando/git/mcapl/bin:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf-classes.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf-annotations.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpf.jar:/Users/angeloferrando/git/mcapl/lib/3rdparty/jpl.jar

java -Djava.library.path=/opt/local/lib/swipl-7.2.3/lib/x86_64-darwin15.0.0/ ail.mas.AIL car.ail


# In motorwaysim directory:
# java eass.tutorials.motorwaysim.MotorwayMain
# it is the motorway simulator which communicates using sockets.
# After that in tutorial1 directory:
# sh compile_and_run.sh
