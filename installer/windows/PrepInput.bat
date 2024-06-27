@echo off

REM Libraries
REM echo java_path=%1
echo 	Libraries
if not exist input\libs mkdir input\libs
del /q input\libs\*
copy ..\..\ANTLR\* input\libs > nul
copy ..\..\ControlsFX\* input\libs > nul
copy ..\..\LibJavaDev input\libs > nul
copy ..\..\Richtextfx input\libs > nul
copy ..\..\JAXB input\libs > nul

REM Documentation
echo 	Documentation
if not exist input\doc mkdir input\doc
del /q input\doc\*
copy ..\..\doc\*.pdf input\doc > nul
copy ..\..\doc\*.htm input\doc > nul

REM Resources
echo 	Resources
if not exist input\resources mkdir input\resources
del /s /q input\resources\* > nul
xcopy ..\..\resources input\resources /E > nul
copy PcPatrEditor.ico input > nul

REM Jar file
echo 	Create Jar file
call CreateJar.bat %1
