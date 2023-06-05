package com.apitest.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

/**
 * This is a JUnit test class that checks the health of a RESTful API endpoint.
 */
public class HealthCheckTest extends BaseTest {
    
    /**
     * This is a JUnit test that sends a GET request to a specific URL and checks that the response
     * status code is 201.
     */
    @Test
    public void healthCheckTest() {
          
        given().
            spec(spec).
        when().
            get("/ping").
        then().
            assertThat().
            statusCode(201);    
    }

    /**
     * This function tests the usage of headers and cookies in a REST API request using RestAssured
     * library in Java.
     */
    @Test
    public void headersAndCookiesTest() {
        
        Header someHeader = new Header("Some header name", "Some header value");
        spec.header(someHeader);

        Cookie someCookie = new Cookie.Builder("Test cookie name", "Test the cookie value").build();
        spec.cookie(someCookie);

        Response response = RestAssured.given(spec).
            cookie("Test cookie name", "Test the cookie value").
            header("Test header name", "Test header value").
            log().all().
            get("/ping");  
   
        // Get headers
        Headers headers = response.getHeaders();
        System.out.println("Headers: " + headers);

        Header serverHeader1 = headers.get("Server");
        System.out.println(serverHeader1.getName() + ": " + serverHeader1.getValue());

        String serverHeader2 = response.getHeader("Server");
        System.out.println("Server: " + serverHeader2);

        // Get cookies
        Cookies cookies = response.getDetailedCookies();
        System.out.println("Cookies: " + cookies);
    }
}