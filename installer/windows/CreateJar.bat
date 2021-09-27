@echo off
cd ..\..\mods
jar cf pcpatreditor.jar .
copy pcpatreditor.jar ..\installer\windows\input > nul
del pcpatreditor.jar > nul
cd ..\installer\windows
