#!/bin/bash

rm -rf target/generated-frascati-*

LIB="/home/rehearsal/.m2/repository/com/orientechnologies/orient-commons/1.0rc5/orient-commons-1.0rc5.jar:/home/rehearsal/.m2/repository/com/orientechnologies/orientdb-core/1.0rc5/orientdb-core-1.0rc5.jar"

frascati compile "src/main" "target/interactiveGuide" $LIB
frascati run "resource/interactiveGuide.composite" -libpath "target/interactiveGuide.jar" $LIB
