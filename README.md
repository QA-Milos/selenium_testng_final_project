# selenium_testng_final_project
```diff
This README provides a thorough description of an automated testing project using Selenium and TestNG.
Selenium is a popular open-source framework for automating web applications, and TestNG is a testing framework 
designed to simplify test management and parallel test execution. 
This project aims to demonstrate creatation and execution of automated UI tests for web applications using POM.
```

# Here's a description of the project structure:

Make sure following dependencies are installed and put into pom.xml:<br>
<br>
Java Development Kit (JDK)<br>
Maven<br>
TestNG<br>
WebDriver compatible with your preferred browser (Chrome, Firefox, etc.)<br>

### Pages: This directory contains page object classes for different web pages. <br>
Each page object class represents a specific web page or component and encapsulates the interactions and locators related to that page.<br>

-CitiesPage.java<br>
-NavPage.java<br>
-LoginPage.java<br>
-SignupPage.java<br>
-MessagePopUpPage.java<br>


### Tests: This directory contains all test classes, organized by page's features. Each test class contains test methods related to a specific feature or functionality.<br>

AdminCitiesTests.java: Test class for testing admin-related functionalities related to cities.<br>
AuthRoutesTests.java: Test class for testing authentication routes.<br>
LocaleTests.java: Test class for testing localization and locale-related functionality.<br>
LoginTests.java: Test class for login-related test cases.<br>
SignupTests.java: Test class for sign-up-related test cases.<br>



### Helpers: This project also incorporates "help" logic in the form of specific classes and methods.
RetryAnalyzer.java: Class  which will automatically retry the failed test.<br>







 
