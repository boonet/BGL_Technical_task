# Java Tech Test

##Java environment requirements
The Java Runtime Environment version can be jre6-jre8. Install it and the equivalent jdk in the default location.

## Importing and setting up the project into an IDE
The project should be able to be run out-of-the-box. Import it into any IDE which can compile Java and run JUnit.
Right click on the pom.xml file and select Run As>Maven Install
If the option is not there, navigate a terminal into the technical-tests/java location and run:
**./maven/bin/mvn install** if you are on OSX

## Running the tests

1. Unzip the bgl_tech_task.zip package

2. Open terminal , go to 
bgl_tech_test\java> and Run below command - 

mvn integration-test -Pftest

3. This should run all the test case scenarios within the test suite.

4. You can also find a html report of all the tests in - 

.\bgl_tech_test\java\target\site\cucumber-pretty\index.html

