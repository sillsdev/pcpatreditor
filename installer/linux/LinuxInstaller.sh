#! /usr/bin/bash
if [ -d installtemp ]; then
 echo "	removing installtemp"
 rm -rf installtemp
fi
echo "	invoking jpackage, part 2"
# 	--verbose \
$1/bin/jpackage --type deb \
	--copyright "2021-2023 SIL International" \
	--description "Editor for PcPatr" \
	--name PcPatrEditor \
	--install-dir /opt/sil \
	--resource-dir output/PcPatrEditor/lib/app/resources \
	--app-image output/PcPatrEditor \
	--linux-menu-group "Education" \
	--linux-shortcut \
	--license-file License.txt \
	--temp installtemp \
	--app-version 0.13.1 \
	--icon input/PcPatrEditor.png \
	--vendor "SIL International"

