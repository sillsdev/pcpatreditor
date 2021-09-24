@echo off
cd ..\mods
jar cf pcpatreditor.jar .
copy pcpatreditor.jar ..\installer\input > nul
del pcpatreditor.jar > nul
cd ..\installer
