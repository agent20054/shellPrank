@echo off

set /p hostname=Enter the server hostname: 

java -jar Client.jar %hostname%
pause