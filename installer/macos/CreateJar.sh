#! /bin/bash

cd ../../mods
# jar cmf META-INF/MANIFEST.MF pcpatreditor.jar .
$1/bin/jar cf pcpatreditor.jar .
cp pcpatreditor.jar ../installer/macos/input > nul
rm pcpatreditor.jar > nul
cd ../installer/macos
