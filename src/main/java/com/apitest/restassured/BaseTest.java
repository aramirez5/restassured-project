package com.apitest.restassured;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected RequestSpecification spec;

    /**
     * This is a setup method in Java using TestNG framework that creates a RequestSpecBuilder object
     * with a base URI for a RESTful API.
     */
    @BeforeMethod
    protected void setUp() {
        spec = new RequestSpecBuilder().
            setBaseUri("http://restful-booker.herokuapp.com").
            build();
    }

    /**
     * The function creates a booking by sending a POST request with a JSON body to
     * a specified URL and
     * returns the response.
     * 
     * @return The method is returning a Response object.
     */
    protected Response createBooking() {

        // Create JSON body
        JSONObject body = new JSONObject();
        body.put("firstname", "Jim");
        body.put("lastname", "Brown");
        body.put("totalprice", 111);
        body.put("depositpaid", true);

        JSONObject dates = new JSONObject();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        body.put("bookingdates", dates);
        body.put("additionalneeds", "Breakfast");

        // Get response
        Response response = RestAssured.
            given(spec).
            contentType(ContentType.JSON).
            body(body.toString()).
            post("/booking");

        return response;
    }
}
