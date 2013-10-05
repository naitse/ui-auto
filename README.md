SETUP
=====

Gradle
------
Install Gradle and put it in your path
> **TIP:** you can copy & paste the following shell snippet):

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



Cloudhub UI Automation
===================


This project contains the automation for Cloudhub Web Console. 
The technology used to automate these tests are Selenium + Geb + TestNG using groovy as language.
We use TestNG as runner to group test cases in suites as regression or sanity check.

The way to execute this project is using Gradle:

parameters muVersion33 and muleVersion34 are used to specify the worker mule version, for instace 3.4.0-R30-xx (use the same as it apears at the UI)

#### Regression

```sh
gradle -Dgeb.build.baseUrl=https://qa.cloudhub.io/ -Dgeb.env=remote-chrome -DmuleVersion34="3.4.0" -DmuleVersion33="3.3.2" -i -PtestSuite=regression groovydoc test
```

#### Sanity

```sh
gradle -Dgeb.build.baseUrl=https://qa.cloudhub.io/ -Dgeb.env=remote-chrome -DmuleVersion34="3.4.0" -DmuleVersion33="3.3.2" -i -PtestSuite=sanity groovydoc test
```
