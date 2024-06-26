#! /usr/bin/bash
if [ -d debtemp ]; then
 echo "	removing debtemp"
 rm -rf debtemp
fi
echo "	fixing desktop shortcut in deb file"
mkdir debtemp
DEB_FILE=`ls pcpatreditor_$1-1_amd64.deb`
dpkg-deb -R $DEB_FILE debtemp
sed '/^Exec=*/a Path=/opt/sil/pcpatreditor/bin/' debtemp/opt/sil/pcpatreditor/lib/pcpatreditor-PcPatrEditor.desktop >debtemp/opt/sil/pcpatreditor/lib/pcpatreditor-PcPatrEditor2.desktop
rm debtemp/opt/sil/pcpatreditor/lib/pcpatreditor-PcPatrEditor.desktop
mv debtemp/opt/sil/pcpatreditor/lib/pcpatreditor-PcPatrEditor2.desktop debtemp/opt/sil/pcpatreditor/lib/pcpatreditor-PcPatrEditor.desktop
dpkg-deb -b debtemp $DEB_FILE.deb
echo "	renaming fixed up deb file"
rm $DEB_FILE
mv $DEB_FILE.deb $DEB_FILE

