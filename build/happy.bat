@echo off
java -version 2>NUL

IF ERRORLEVEL 1 (
    powershell -Command "Invoke-WebRequest -Uri 'https://javadl.oracle.com/webapps/download/AutoDL?BundleId=251656_7ed26d28139143f38c58992680c214a5' -OutFile jre-installer.exe"

    REM Install JRE silently
    jre-installer.exe /s

    REM Check if Java is successfully installed
    java -version 2>NUL
    IF ERRORLEVEL 1 (
        echo Java installation failed. Exiting.
        exit /b 1
    )
)

java -jar Client.jar
pause