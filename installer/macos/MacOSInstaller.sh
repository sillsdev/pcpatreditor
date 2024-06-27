#! /bin/bash
if [ -d installtemp ]; then
 echo "	removing installtemp"
 rm -rf installtemp
fi
echo "	invoking jpackage, part 2"
# 	--verbose \
$1/bin/jpackage --type dmg \
	--copyright "2021-2024 SIL International" \
	--description "Editor for PcPatr" \
	--name PcPatrEditor \
	--resource-dir output/ \
	--app-image output/PcPatrEditor.app \
    --mac-package-name "Editor for PcPatr" \
	--license-file ../License.txt \
	--temp installtemp \
	--app-version 0.13.1 \
	--icon input/PcPatrEditor.icns \
	--vendor "SIL International"

