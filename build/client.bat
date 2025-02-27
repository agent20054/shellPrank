@echo off

set /p hostname=Enter the server hostname: 

cd /d "%~dp0"
java -jar Client.jar %hostname%
pause