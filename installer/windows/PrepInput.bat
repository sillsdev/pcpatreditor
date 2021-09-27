@echo off

REM Libraries
if not exist input\libs mkdir input\libs
del /q input\libs\*
copy ..\..\ANTLR\* input\libs > nul
copy ..\..\ControlsFX\* input\libs > nul
copy ..\..\LibJavaDev input\libs > nul
copy ..\..\Richtextfx input\libs > nul

REM Documentation
if not exist input\doc mkdir input\doc
del /q input\doc\*
copy ..\..\doc\*.pdf input\doc > nul

REM Resources
if not exist input\resources mkdir input\resources
del /s /q input\resources\* > nul
xcopy ..\..\src\org\sil\pcpatreditor\resources input\resources /E > nul
copy PcPatrEditor.ico input > nul

REM Jar file
call CreateJar.bat
