# Liferay Test Automation
## Description
This git project is a selenium example for test automation of Liferay instances.

## How to run automation?

### Run with default browser (Chrome) against localhost:8080
We just need to run "cucumber" task with Gradle in the root project folder:

```
gradle :cleanTest :test
```

Or execute test runner java file RunTests.java from your ID.

### Run against not local instances
By default, tests are executed against localhost with http protocol and using port 8080.

If you want to run against another instance you have access to can use the flag -Durl=protocol://url:port/. You must specify the three of them: protocol + url + port.

For example, to run against 192.168.40.58 with protocol http and port 7300, just use:

```
gradle :cleanTest :test -Durl=http://192.168.40.58:7300/
```

### Run with other browsers
Default browser is Chrome. To run in another browser, we need to have it installed in our OS and use -Dbrowser=browserName flag.

For example, to run with FireFox, just use:

```
gradle :cleanTest :test -Dbrowser=firefox
```

## Test results
After test execution, a basic HTLM report is automatically generated in ./target/ folder.

## Contact
If you have any further question, just send me an email to david.gutierrez@liferay.com