package com.apitest.restassured;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This is a Java test class that verifies the response of a GET request to retrieve booking IDs from a
 * RESTful API.
 */
public class GetBookingsIDsTest extends BaseTest {

    /**
     * This is a test function in Java that verifies the response of a GET request to retrieve booking
     * IDs without any filters.
     */
    @Test
    public void GetBookingsIDsWithoutFilterTest() {

        // Get response with bookings IDs
        Response response = RestAssured.given(spec).get("/booking");
        response.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify at least 1 booking ID in response
        List<Integer> bookingIDs = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIDs.isEmpty(), "List of bookingIDs is empty, but it's shouldn't be");
    }

   /**
    * This function tests the ability to retrieve booking IDs with a filter based on first and last
    * name.
    */
    @Test
    public void GetBookingsIDsWithFilterTest() {

        // Add query parameter to spec
        spec.queryParam("firstname", "Jim");
        spec.queryParam("lastname", "Brown");

        // Get response with bookings IDs by firstname
        Response response = RestAssured.given(spec).get("/booking");
        response.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
        
        // Verify at least 1 booking ID in response
        List<Integer> bookingIDs = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIDs.isEmpty(), "List of bookingIDs is empty, but it's shouldn't be");
    }
}
