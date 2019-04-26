@echo off
set tomcat=D:\my\exe\apache-tomcat-9.0.19
set filename=rs

call mvn clean install

echo.
echo tomcat closed
echo. 
call %tomcat%\bin\shutdown.bat

IF EXIST "%tomcat%\webapps\%filename%" (
rmdir /s /q %tomcat%\webapps\%filename%
echo.
echo %tomcat%\webapps\%filename% removed 
)

IF EXIST "%tomcat%\webapps\%filename%.war" (
del %tomcat%\webapps\%filename%.war
echo.
echo %tomcat%\webapps\%filename%.war removed 
echo.
)

copy %cd%\target\%filename%.war %tomcat%\webapps\%filename%.war
echo %filename%.war copied from %cd%\target to tomcat%\webapps 
echo.



call %tomcat%\bin\startup.bat
echo.
echo tomcat started