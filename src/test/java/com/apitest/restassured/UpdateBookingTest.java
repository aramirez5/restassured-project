package com.apitest.restassured;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * This is a Java class that tests the functionality of updating a booking on a hotel booking website
 * using RestAssured.
 */
public class UpdateBookingTest extends BaseTest {
    
    /**
     * This is a test function that updates a booking and verifies that all fields have been updated
     * correctly.
     */
    @Test
    public void updateBookingTest() {
        
        // Create booking
        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        // Get booking id of new booking
        int bookingId = responseCreate.jsonPath().getInt("bookingid");

        // Create JSON body
        JSONObject body = new JSONObject();
        body.put("firstname", "Olga");
        body.put("lastname", "Brown");
        body.put("totalprice", 125);
        body.put("depositpaid", false);

        JSONObject dates = new JSONObject();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        body.put("bookingdates", dates);
        body.put("additionalneeds", "Breakfast");

        // Update booking
        Response responseUpdate = RestAssured.
            given(spec).
            auth().
            preemptive().
            basic("admin", "password123").
            contentType(ContentType.JSON).
            body(body.toString()).
            put("/booking/" + bookingId);
        responseUpdate.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify all fields
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = responseUpdate.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Olga", "First name should be Olga, but it's not");
        
        // Do the test for lastname
        String actualLastName = responseUpdate.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Brown", "Last name should be Brown, but it's not");
        
        // Do the test for totalprice
        int actualTotalPrice = responseUpdate.jsonPath().getInt("totalprice");
        softAssert.assertEquals(actualTotalPrice, 125, "Total price should be 125, but it's not");
        
        // Do the test for depositpaid
        boolean actualDepositPaid = responseUpdate.jsonPath().getBoolean("depositpaid");
        softAssert.assertFalse(actualDepositPaid, "Deposit paid should be false, but it's not");
        
        // Do the test for checkin
        String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin should be 2018-01-01, but it's not");
        
        // Do the test for checkout
        String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout should be 2019-01-01, but it's not");
        
        // Do the test for additionalneeds
        String actualAdditionalNeeds = responseUpdate.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualAdditionalNeeds, "Breakfast", "Additional needs should be Breakfast, but it's not");
        
        softAssert.assertAll();
    }
}
