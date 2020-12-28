# Currency-Converter-Application

## About the Application:
The application is meant to convert the currency and it currently supports four currencies namely : INR, USD, EUR & GBP. It is developed using Spring Boot Framework of Java which is mainly used for the development of REST API Microservices. 

## Workflow of the Application:
1. The application internally calls a [Third Party API](https://api.exchangeratesapi.io/latest).
2. Exchange rate is fetched from the response returned by calling the above API.
3. Multiplication of the exchange rate with the quantity specified in the path parameter of the request is done and returned in the response.

## Prerequisites to run the Application:
* Java 8+
* Maven 3.3+
* Stable Internet Connection

## Steps to run the Application:
### 1.Clone the application using the command:
```
git clone https://github.com/Aanchal315/Currency-Converter-Application.git
```
### 2.Build the application using the command:
```
mvn clean install
```
### 3.Run the application using the command:
```
mvn spring-boot:run
```
### 4.Application can be accessed using the URL:
```
localhost:8080/swagger-ui.html
```
