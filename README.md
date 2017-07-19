# javaChat
Simple chat client in Java

:: create jar file from java file(s)
jar cmf manifest.txt Client.jar


:: Run in cmd server and port optional
@echo off

javac Client.java
java Client --server-- --port--
pause
