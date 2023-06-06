<p align="center">
  <img alt="Selenium" src="https://qaautomationexpert.files.wordpress.com/2021/05/image-103.png?w=615">
</p>


[![Java Version](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://www.java.com)
[![Maven](https://img.shields.io/badge/Maven-3.8.7-blue.svg)](https://maven.apache.org/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.3.0-green.svg)](https://rest-assured.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


# What is restassured-project ?

This is a sample project that uses the RestAssured library to perform API testing in Java. RestAssured is a high-level Java API testing library that simplifies and speeds up the process of integration and functionality testing of APIs.

## 📋 Prerequisites

Before running this project, make sure you have the following installed in your development environment:

* Java JDK 8 or above.
* Maven for dependency management.

## ⚙️ Project Setup 

Follow these steps to set up and run the project on your local machine:

1. Clone this repository to your local machine using the following command:
```sh
git clone https://github.com/aramirez5/restassured-project.git
```
2. Navigate to the project's root directory:
```sh
cd restassured-project
```
3. Make sure you have all the project dependencies downloaded and updated by running the following command:
```sh
mvn clean install
```
4. Once all the dependencies have been downloaded and the project has been successfully built, you can execute the API tests using the following command:
```sh
mvn test
```
5. Otherwise, you can execute a single test as the following:
```sh
mvn test -Dtest=CreateBookingTest.java
```
This will run all the defined test cases in the project and display the results in the console.

## 📁 Project Structure 

The project follows the following directory structure:
```sh
├── src
│   ├── main
│   │   └── java
│   │       └── com.example.restassured
│   │           └── ...
│   └── test
│       └── java
│           └── com.example.restassured
│               └── ...
├── pom.xml
└── README.md
```
* The src/main/java directory contains the main classes and source code of the project.
* The src/test/java directory contains the API tests written using RestAssured.
* The pom.xml file is the Maven configuration file that defines the project dependencies and build tasks.

## 👥 Contribution 
If you would like to contribute to this project, feel free to open an issue or submit a pull request. Suggestions and improvements for the project are also appreciated.

## 📄 License 
This project is distributed under the MIT License. You can find more details in the LICENSE file.