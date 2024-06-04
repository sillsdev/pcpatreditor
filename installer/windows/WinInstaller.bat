@echo off
if exist installtemp rmdir installtemp /S /q
echo 	invoking jpackage, pass 2
%1\bin\jpackage --type exe ^
	--copyright "2021-2024 SIL International" ^
	--description "Editor for PcPatr" ^
	--name PcPatrEditor ^
	--install-dir "SIL\PcPatrEditor" ^
	--resource-dir input/resources ^
	--app-image output/PcPatrEditor ^
	--win-menu ^
	--win-shortcut ^
	--license-file License.txt ^
	--temp installtemp ^
	--vendor "SIL International" ^
	--app-version 0.13.1
