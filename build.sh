#!/bin/bash
mkdir -p jar
javac --release 21 -d jar $(find src -name "*.java")
cp -r resources/* jar
jar cfe cookie.jar se.voxelmanip.cookie.Cookie -C jar .
