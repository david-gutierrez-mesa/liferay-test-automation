# LiferayFormTest
## Description
This git project is a selenium example for automation

## How to run automation?

### Run with default browser (Chrome)
We just need to run "cucumber" task with Gradle in the root project folder:

```
gradle :cleanTest :test
```

Or execute test runner java file RunTests.java from your ID.

### Run with other browsers

To run in another browser, we need to have it installed in out OS and use -Dbrowser=browserName flag.

For example, to run with FireFox, just use:

```
gradle :cleanTest :test -Dbrowser=firefox
```

## Test results
After test execution, a basic HTLM report is automatically generated in ./target/ folder.

## Contact
If you have any further question, just send me an email to david.gutierrez@liferay.com