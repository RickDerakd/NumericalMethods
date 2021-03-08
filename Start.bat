0</* :
@echo off
title Yasin
color 0A
  setlocal
    cscript /nologo /e:jscript "%~f0"
	echo System: Checking Java functionality...
	timeout /t 1 /nobreak > NUL
	where java >nul 2>nul
	if %errorlevel%==1 (
    		echo Error: Java not found...
    		echo System: The program cannot be activated...
    		timeout /t 1 /nobreak > NUL
    		echo System: Redirecting to download link...
    		explorer https://www.java.com/ru/download/
    		echo System: it is recommended to restart the batch-file.
    		pause
    		exit
	)
	echo System: Running...
	timeout /t 1 /nobreak > NUL
	cls
	echo Activation...
	timeout /t 1 /nobreak > NUL
	java -jar NumericalMethods.jar
	if %errorlevel%==1 (
	    echo System: Java was fucked...
	)
	pause
	exit
  endlocal
exit /b*/ 0;
(function(){
  for (var i = 0; i <= 100; i++) {
    WScript.StdOut.Write('Loading ' + i + '%');
    WScript.Sleep(10);
    WScript.StdOut.Write('\r\r');
  }
}());