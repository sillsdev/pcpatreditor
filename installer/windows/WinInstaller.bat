@echo off
if exist installtemp rmdir installtemp /S /q
echo 	invoking jpackage, pass 2
jpackage --type exe ^
	--copyright "2021-2026 SIL International" ^
	--description "Editor for PcPatr" ^
	--name PcPatrEditor ^
	--install-dir "SIL\PcPatrEditor" ^
	--resource-dir input/resources ^
	--app-image output/PcPatrEditor ^
	--win-menu ^
	--win-shortcut ^
	--license-file ..\License.txt ^
	--icon input/PcPatrEditor.ico ^
	--win-upgrade-uuid C966E03D-ADC0-4DB0-A86F-A165F3B8C807 ^
	--temp installtemp ^
	--app-version %1 ^
	--file-associations pcpatreditor.properties ^
	--vendor "SIL International"

