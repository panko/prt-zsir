#!/usr/bin/env bash
python -mwebbrowser http://download.oracle.com/otn/utilities_drivers/jdbc/11204/ojdbc6.jar
read -p "Press any key if you ready..."

if [ -d "$HOME/Downloads" ]; then
  mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -Dfile="$HOME/Downloads/ojdbc6.jar" -DgeneratePom=true
  echo "Installed from ~/Downloads/ojdbc6.jar"
fi
if [ -d "$HOME/Letöltések" ]; then
  mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -Dfile="$HOME/Letöltések/ojdbc6.jar" -DgeneratePom=true
  echo "Installed from ~/Letöltések/ojdbc6.jar"
fi

