#!/bin/bash
buildNumber=$(($(cat build_number.txt)+1))
echo $buildNumber > build_number.txt