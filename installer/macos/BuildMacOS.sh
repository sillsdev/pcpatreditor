#! /bin/bash
# Build macOS installer; see ReadmeMacOSInstaller.txt
java_path=/Library/Java/JavaVirtualMachines/zulu-22.jdk/Contents/Home
echo PrepInput
./PrepInput.sh $java_path
echo CreateMacOSApp
./CreateMacOSApp.sh $java_path
echo MacOsInstaller
./MacOSInstaller.sh $java_path

