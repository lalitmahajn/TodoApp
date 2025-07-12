@IF "%DEBUG%" == "" @ECHO OFF
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
IF "%OS%"=="Windows_NT" SETLOCAL

SET DIR=%~dp0
@rem Remove trailing backslash from DIR
IF %DIR:~-1%==\ SET DIR=%DIR:~0,-1%

SET APP_BASE_NAME=%~n0
SET APP_HOME=%DIR%

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
SET DEFAULT_JVM_OPTS=

@rem Find java.exe
SET JAVA_EXE=java.exe
IF DEFINED JAVA_HOME (
    SET JAVA_HOME=%JAVA_HOME:"=%
    SET JAVA_EXE=%JAVA_HOME%/bin/java.exe
)

@rem Get command-line arguments, handling special characters
SET CMD_LINE_ARGS=
:loop
IF "%~1"=="" GOTO endloop
SET CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
SHIFT
GOTO loop
:endloop

@rem Execute Gradle wrapper
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% -classpath "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

ENDLOCAL
