#! /usr/bin/bash
if [ -d output ]; then
 echo "	Cleaning output"
 rm -rf output > /dev/null
fi
echo "	invoking jpackage, part 1"
# to see more details, add the --verbose option
#	--verbose \
$1/jpackage --type app-image \
	--input input \
	--dest output \
	--name PcPatrEditor \
	--main-jar pcpatreditor.jar \
	--main-class org.sil.pcpatreditor.MainApp \
	--icon input/PcPatrEditor.png \
	--module-path "/home/andy/Downloads/Java/zulu17.50.19-ca-fx-jdk17.0.11-linux_x64/jmods" \
	--vendor "SIL International"
echo "	MoveResources"
./MoveResources.sh

