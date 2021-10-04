@echo off
if exist installtemp rmdir installtemp /S /q
jpackage --type exe --copyright "2021 SIL International" --description "Editor for PCPatr" --icon input/PcPatrEditor.ico --name PCPatrEditor --install-dir "SIL\PcPatrEditor" --resource-dir input/resources --app-image output/PcPatrEditor --win-menu --win-shortcut --license-file License.txt --temp installtemp --app-version 0.1.1 --vendor "SIL International"

