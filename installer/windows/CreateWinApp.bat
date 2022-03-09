@echo off
if exist output rmdir output /S /q
REM if exist apptemp rmdir apptemp /S /q
jpackage --verbose --type app-image --input input --dest output --name PcPatrEditor --main-jar pcpatreditor.jar --main-class org.sil.pcpatreditor.MainApp --icon input/PcPatrEditor.ico --module-path "C:\Users\Andy Black\Favorites\Downloads\Java\AzulZulu\zulu17.30.15-ca-fx-jdk17.0.1-win_x64\jmods" --vendor "SIL International" --app-version 0.10.0
call MoveResources.bat
