package com.apitest.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This Java class tests the functionality of deleting a booking using RestAssured.
 */
public class DeleteBookingTest extends BaseTest {
    
    /**
     * This function tests the deletion of a booking by creating a new booking, getting its ID,
     * deleting it, and verifying the response status code.
     */
    @Test
    public void deleteBookingTest() {
        
        // Create booking
        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        // Get booking id of new booking
        int bookingId = responseCreate.jsonPath().getInt("bookingid");

        // Delete booking
        Response responseUpdate = RestAssured.
            given(spec).
            auth().
            preemptive().
            basic("admin", "password123").
            delete("/booking/" + bookingId);
        responseUpdate.prettyPrint();

        // Verify response status code 201
        Assert.assertEquals(responseUpdate.getStatusCode(), 201, "Status code should be 201, but it's not");
    
        // Get response with bookings IDs
        Response responseGet = RestAssured.get("http://restful-booker.herokuapp.com/booking/" + bookingId);
        responseGet.prettyPrint();

        // Verify body response message is Not Found
        Assert.assertEquals(responseGet.getBody().asString(), "Not Found", "Body should be 'Noy Found', but it's not");
    }
}
