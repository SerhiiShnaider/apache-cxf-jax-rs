#!/bin/bash
filename=rs
tomcatLocation=/opt/apache/apache-tomcat-9.0.19

mvn clean install

sudo $tomcatLocation/bin/shutdown.sh
echo tomcat closed

if [ "$tomcatLocation/webapps/$filename.war" ]; then
rm $tomcatLocation/webapps/$filename.war

echo $tomcatLocation/webapps/$filename.war removed 

fi

cp $(pwd)/target/$filename.war $tomcatLocation/webapps/$filename.war
echo $filename.war copied from $(pwd)/target to $tomcatLocation/webapps  

echo "Run tomcat? Y/N: "
read input

if [[ $input == "Y" || $input == "y" ]]; then
    sudo $tomcatLocation/bin/startup.sh
fi

sleep 2m
