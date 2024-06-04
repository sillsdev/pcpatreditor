#! /usr/bin/bash
# Build Linux installer; see ReadmeLinuxInstaller.txt
java_path=/home/andy/Downloads/Java/zulu17.50.19-ca-fx-jdk17.0.11-linux_x64/bin
echo PrepInput
./PrepInput.sh $java_path
echo CreateLinuxApp
./CreateLinuxApp.sh $java_path
echo LinuxInstaller
./LinuxInstaller.sh $java_path

