#!/bin/bash

ROLE="carParkReservation"

rm -rf target/generated-frascati-*

frascati compile "src/main" "target/$ROLE"
frascati run "../composites/$ROLE$1.composite" -libpath "target/$ROLE.jar"
