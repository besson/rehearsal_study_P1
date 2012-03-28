#!/bin/bash

ROLE="interactiveGuide"
DEPENDENCY="FlightFinder"
PETALS_HOME="/home/rehearsal/study/tools/petals-platform-3.1.3"
SAS_DIR="/home/rehearsal/workspace/rehearsal-study/petals_service-units/sas"

if [ "$1" == "02" ]; then

  rm  "$PETALS_HOME"/installed/sa-SOAP-"$DEPENDENCY"*
  cp  "$SAS_DIR"/sa-SOAP-"$DEPENDENCY"Mock-* "$PETALS_HOME/install"

fi


if [ "$1" == "03" ]; then
  
  rm  "$PETALS_HOME"/installed/sa-SOAP-"$DEPENDENCY"*
  cp  "$SAS_DIR"/sa-SOAP-"$DEPENDENCY"Proxy-* "$PETALS_HOME/install"

fi 

sleep 10

LIB="$HOME/.m2/repository/com/orientechnologies/orient-commons/1.0rc5/orient-commons-1.0rc5.jar:$HOME/.m2/repository/com/orientechnologies/orientdb-core/1.0rc5/orientdb-core-1.0rc5.jar"

rm -rf target/generated-frascati-*

frascati compile "src/main" "target/$ROLE" $LIB
frascati run "resource/$ROLE$1.composite" -libpath "target/$ROLE.jar" $LIB
