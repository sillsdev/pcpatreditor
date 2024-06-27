#! /bin/bash
echo "	Libraries"
if [ ! -d input/libs ]; then
 mkdir -p input/libs
else
 rm -r input/libs/* > /dev/null
fi
cp ../../ANTLR/* input/libs > /dev/null
cp ../../ControlsFX/* input/libs > /dev/null
cp ../../LibJavaDev/* input/libs > /dev/null
cp ../../Richtextfx/* input/libs > /dev/null
cp ../../JAXB/* input/libs > /dev/null

echo "	Documentation"
if [ ! -d input/doc ]; then
 mkdir -p input/doc
else
 rm -r input/doc/* > /dev/null
fi
cp ../../doc/*.pdf input/doc > /dev/null
cp ../../doc/*.htm input/doc > /dev/null

echo "	Resources"
if [ ! -d input/resources ]; then
 mkdir -p input/resources
else
 rm -r input/resources/* > /dev/null
fi
# xcopy ../../src/org/sil/pcpatreditor/resources input/resources /E > /dev/null
cp -r ../../resources input
cp ../../resources/images/PcPatrEditor256x256.icns input/PcPatrEditor.icns > /dev/null

echo "	Jar file"
./CreateJar.sh $1

