## Automation Project

A Java-based Test Automation Framework built using
- Java 21
- Selenium WebDriver
- Cucumber (BDD)
- Maven
- Allure Reports

## Features
- Page Object Model (POM) design pattern
- Cucumber BDD for readable test scenarios
- Separate runners for UI and API tests
- Allure & HTML reporting
- Maven-based build and execution
- CI/CD ready with Azure DevOps

##  Running Tests
Run via Maven:

`mvn clean test`

Generate Allure report 

`mvn allure:report`

<img width="1906" height="768" alt="image" src="https://github.com/user-attachments/assets/a1a4690b-819b-4fc4-b4d4-7d4c4769de0e" />


## CI/CD

Run local azure agent

Locate local agent file:

`cd C:\agent`

Start agent and run in azure pipeline

`.\run.cmd`

<img width="1381" height="709" alt="image" src="https://github.com/user-attachments/assets/ad25407b-077d-4d11-880d-83246d6ff7ed" />
