SETUP
=====

Gradle
------
Install Gradle and put it in your path
> **TIP: Unix only** you can copy & paste the following shell snippet):

```sh
curl http://downloads.gradle.org/distributions/gradle-1.4-bin.zip > $HOME/gradle.zip
mkdir -p Groovy/gradle
cd Groovy/gradle
unzip $HOME/gradle.zip
mv gradle-1.4 1.4
rm $HOME/gradle.zip
export GRADLE_HOME=$HOME/Groovy/gradle/1.4
export PATH=$PATH:$GRADLE_HOME/bin
echo 'export GRADLE_HOME=$HOME/Groovy/gradle/1.4' >> $HOME/.profile
echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> $HOME/.profile
cd $HOME
```
> **Windows Users:**

Download the zip
unpack
environment variables
add GRADLE_HOME to gradle unziped files
add %GRADLE_HOME%\bin to PATH variable




UI Automation
===================


This project contains the automation for Web Pages. 
The technology used to automate these tests are Selenium + Geb + TestNG using groovy as language.
We use TestNG as runner to group test cases in suites as regression or sanity check.

The way to execute this project is using Gradle:

** Note: user and pass parameter are optionals, they have defaults at Properties class


#### smoke

```sh

gradle -PtestSuite=smoke test

```

this bottom lines are refence to see that parameter can be passed through command line but all the need for this expample are at build.gradle already

```sh
gradle -Dgeb.build.baseUrl=https://example.com/  -Duser="usuario@ejemplo.com" -Dpass="el pass"   -i -PtestSuite=smoke test
```