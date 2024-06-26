#! /bin/bash
if [ -d output ]; then
 echo "	Cleaning output"
 rm -rf output > /dev/null
fi
echo "	invoking jpackage, part 1"
# to see more details, add the --verbose option
#	--verbose \
$1/bin/jpackage --type app-image \
	--input input \
	--dest output \
	--name PcPatrEditor \
	--main-jar pcpatreditor.jar \
	--main-class org.sil.pcpatreditor.MainApp \
	--icon input/PcPatrEditor.icns \
	--module-path %1/jmods \
	--vendor "SIL International"
echo "	MoveResources"
./MoveResources.sh

