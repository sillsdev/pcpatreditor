@echo off
if exist output rmdir output /S /q
REM if exist apptemp rmdir apptemp /S /q
echo 	invoking jpackage, pass 1
REM use --verbose to see more
%1\bin\jpackage --type app-image ^
	--input input ^
	--dest output ^
	--name PcPatrEditor ^
	--main-jar pcpatreditor.jar ^
	--main-class org.sil.pcpatreditor.MainApp ^
	--icon input/PcPatrEditor.ico ^
	--module-path %1\jmods ^
	--vendor "SIL International"
echo 	MoveResources
call MoveResources.bat
