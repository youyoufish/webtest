#!/bin/sh

#To remote debug the application with port 24001
export JAVA_OPTS="-Xnoagent -Djava.compiler=NONE -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=24001"

gradle appRun