#!/bin/bash

ROLE="interactiveGuide"
LIB="$HOME/.m2/repository/com/orientechnologies/orient-commons/1.0rc5/orient-commons-1.0rc5.jar:$HOME/.m2/repository/com/orientechnologies/orientdb-core/1.0rc5/orientdb-core-1.0rc5.jar"

rm -rf target/generated-frascati-*

frascati compile "src/main" "target/$ROLE" $LIB
frascati run "resource/$ROLE.composite" -libpath "target/$ROLE.jar" $LIB
