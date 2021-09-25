#!/bin/bash

if [ $1 = $2 ]
then
echo "Both are equal"
elif [ $1 -gt $2 ]
then
echo "$1 is greater than $2"
else
echo "$1 is less than $2"
fi

