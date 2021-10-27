@echo off
if exist output rmdir output /S /q
REM if exist apptemp rmdir apptemp /S /q
jpackage --verbose --type app-image --input input --dest output --name PcPatrEditor --main-jar pcpatreditor.jar --main-class org.sil.pcpatreditor.MainApp --icon input/PcPatrEditor.ico --module-path "C:\Users\Andy Black\Favorites\Downloads\Java\AzulZulu\zulu14.29.23-ca-fx-jdk14.0.2-win_x64\jmods" --vendor "SIL International" --app-version 0.2.0
call MoveResources.bat
