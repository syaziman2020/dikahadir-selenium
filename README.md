# Selenium Dikahadir Test Automation

This project provides automated UI tests for the Dikahadir application using **Selenium WebDriver**, **TestNG**, and **Extent Reports**. The test suite is organized into two main modules: **Shifting** and **Calendar**.

## Table of Contents

  * [Prerequisites](https://www.google.com/search?q=%23prerequisites)
  * [Project Structure](https://www.google.com/search?q=%23project-structure)
  * [Configuration](https://www.google.com/search?q=%23configuration)
  * [Running Tests](https://www.google.com/search?q=%23running-tests)
  * [Reporting](https://www.google.com/search?q=%23reporting)
  * [Contributing](https://www.google.com/search?q=%23contributing)

## Prerequisites

Before you can run these tests, ensure you have the following installed:

  * **Java Development Kit (JDK) 21 or higher**: [Download from Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
  * **Maven**: [Download from Apache Maven](https://maven.apache.org/download.cgi)
  * **Web Browser (e.g., Chrome, Firefox)**: Ensure you have the corresponding WebDriver executable (e.g., `chromedriver.exe`, `geckodriver.exe`) compatible with your browser version in your system's PATH, or within the project's WebDriver directory (if applicable).

## Project Structure

The project follows a standard Maven directory structure with clearly defined packages for page objects, test base, test cases, and utilities:

```
dikahadir-selenium/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       ├── java/
│       │   ├── com/
│       │   │   └── dikahadir_selenium/
│       │   │       ├── pageObjects/
│       │   │       │   ├── BasePage.java
│       │   │       │   ├── CalendarDetailPage.java
│       │   │       │   ├── CalendarPage.java
│       │   │       │   ├── DashboardPage.java
│       │   │       │   ├── LoginPage.java
│       │   │       │   └── ShiftingPage.java
│       │   │       ├── testBase/
│       │   │       │   └── BaseClass.java
│       │   │       ├── testCases/
│       │   │       │   ├── calendar/
│       │   │       │   ├── common/
│       │   │       │   │   ├── GoToShiftingTest.java
│       │   │       │   │   ├── GoToCalendar.java
│       │   │       │   │   └── LoginTest.java
│       │   │       │   └── shifting/
│       │   │       └── utilities/
│       │   │           ├── ExtentReportManager.java
│       │   │           ├── SimpleSortValidationUtil.java
│       │   │           └── StringExtractorUtil.java
│       └── resources/
│           ├── config.properties
│           └── testng.xml
├── reports/
│   ├── screenshots/
│   └── Test-Report-YYYY.MM.DD.HH.MM.SS.html (Extent Reports)
├── target/
├── pom.xml
└── README.md
```

  * **`src/test/java/com/dikahadir_selenium/pageObjects/`**: Contains classes representing different pages of the application, encapsulating UI elements and actions (Page Object Model).
  * **`src/test/java/com/dikahadir_selenium/testBase/BaseClass.java`**: Provides a base class for all test cases, handling common setup (e.g., WebDriver initialization) and teardown operations.
  * **`src/test/java/com/dikahadir_selenium/testCases/calendar/CalenderTest.java`**: Contains TestNG test cases related to the Calendar module.
  * **`src/test/java/com/dikahadir_selenium/testCases/shifting/ShiftingTestTest.java`**: Contains TestNG test cases related to the Shifting module.
  * **`src/test/java/com/dikahadir_selenium/testCases/common/`**: Contains common test cases or utilities used across different modules, like `LoginTest.java`.
  * **`src/test/java/com/dikahadir_selenium/utilities/`**: Contains utility classes for various helper functions, including `ExtentReportManager.java` for reporting.
  * **`src/test/resources/config.properties`**: The configuration file holding application URL and login credentials.
  * **`src/test/resources/testng.xml`**: The TestNG XML configuration file that defines which tests to run and their execution order.
  * **`reports/`**: Directory where Extent Reports and screenshots are generated after test execution.
  * **`pom.xml`**: Maven Project Object Model file, defining project dependencies and build configurations.

## Configuration

The `config.properties` file, located at `src/test/resources/config.properties`, stores essential configuration details. Before running the tests, **you must update this file with your application's details**:

```properties
appURL=YOUR_APPLICATION_URL
email=YOUR_LOGIN_EMAIL
password=YOUR_LOGIN_PASSWORD
```

Replace `YOUR_APPLICATION_URL`, `YOUR_LOGIN_EMAIL`, and `YOUR_LOGIN_PASSWORD` with the actual values for your Dikahadir application instance.

## Running Tests

Tests are executed using the `testng.xml` configuration file.

1.  **Navigate to the project root:**

    ```bash
    cd dikahadir-selenium
    ```

2.  **Run tests using Maven:**

    ```bash
    mvn clean test
    ```

This command will execute all tests defined in `src/test/resources/testng.xml`.

## Reporting

This project integrates **Extent Reports** for comprehensive test execution reports. After a test run, an HTML report will be generated in the `reports/` directory. You will find files named like `Test-Report-YYYY.MM.DD.HH.MM.SS.html` and a `screenshots` folder within `reports/`.

Open the generated HTML file (e.g., `reports/Test-Report-2025.06.29.12.28.23.html`) in your web browser to view detailed test results, including pass/fail status, test step details, and embedded screenshots for failures.

## Contributing

We welcome contributions to this project\! If you'd like to contribute, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and ensure tests pass.
4.  Commit your changes with a clear and concise message.
5.  Push your branch to your fork.
6.  Create a pull request to the main repository.

-----