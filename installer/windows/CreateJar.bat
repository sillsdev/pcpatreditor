@echo off
cd ..\..\mods
REM jar cmf META-INF\MANIFEST.MF pcpatreditor.jar .
REM echo java_path=%1
%1\bin\jar cf pcpatreditor.jar .
copy pcpatreditor.jar ..\installer\windows\input > nul
del pcpatreditor.jar > nul
cd ..\installer\windows
