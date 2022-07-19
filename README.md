# URL-Shortener
Demo Application

Requirements
For building and running the application you need:

JDK 1.8
Maven 3
Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentriccom.apple.URLShortnerApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

RUN this APP from comand prompt:
mvn spring-boot:run

Page to input URL
http://localhost:8080/http://localhost:8080/url-shortener.html

HTML page to validate all urls
http://localhost:8080/all-shortened-urls.html


Note:
Spring Boot app with inbuilt H2 database.
Used JPA to do data manipulations.

info on code-

Entity/Model : ShortenerURLs.java

Controller: URLController.java

Data Repository: URLRepository.java

Service: URLManipulate.java

JSP: url-shortener.html, shortened-url-result.html, all-shortened-urls.html

styles: url-shortener.css
