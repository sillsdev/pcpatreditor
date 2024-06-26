#! /usr/bin/bash
if [ -d installtemp ]; then
 echo "	removing installtemp"
 rm -rf installtemp
fi
echo "	invoking jpackage, part 2"
VERSION=0.13.1
# 	--verbose \
#	--linux-shortcut \
$1/bin/jpackage --type deb \
	--copyright "2021-2024 SIL International" \
	--description "Editor for PcPatr" \
	--name PcPatrEditor \
	--install-dir /opt/sil \
	--resource-dir jpackageResources \
	--app-image output/PcPatrEditor \
	--linux-menu-group "Education" \
	--license-file License.txt \
	--temp installtemp \
	--app-version $VERSION \
	--icon input/PcPatrEditor.png \
	--vendor "SIL International"
./FixDesktopShortcutInDebFile.sh $VERSION
