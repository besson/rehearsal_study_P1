#!/bin/bash

ROLE="flightFinder"
DEPENDENCY="CarParkReservation"
PETALS_HOME="/home/rehearsal/study/tools/petals-platform-3.1.3"
SAS_DIR="/home/rehearsal/workspace/rehearsal-study/petals_service-units/sas"

echo "Trying to clean petals files..."

sleep 05

rm  "$PETALS_HOME"/installed/sa-SOAP-"$DEPENDENCY"* > /dev/null

if [ "$1" == "02" ] || [ "$1" == "03" ]; then

  cp  "$SAS_DIR"/sa-SOAP-"$DEPENDENCY"Proxy-* "$PETALS_HOME/install"

fi

if [ "$1" == "04" ]; then

  cp "$SAS_DIR"/sa-SOAP-"$DEPENDENCY"Real-* "$PETALS_HOME/install"

fi

sleep 10

echo

rm -rf target/generated-frascati-*

frascati compile "src/main" "target/$ROLE"
frascati run "resource/$ROLE$1.composite" -libpath "target/$ROLE.jar"
