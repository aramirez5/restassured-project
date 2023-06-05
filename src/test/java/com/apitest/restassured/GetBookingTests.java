package com.apitest.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

/**
 * The GetBookingTests class contains a test method that verifies the response of a GET request to
 * retrieve booking information from a RESTful API.
 */
public class GetBookingTests extends BaseTest {

    /**
     * This is a test function that verifies the correctness of the response received from a REST API
     * endpoint for a specific booking ID.
     */
    @Test(enabled = false)
    public void getBookingTest() {

        // Create booking
        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        // Get booking id of new booking
        int bookingId = responseCreate.jsonPath().getInt("bookingid");

        //Set path parameter
        spec.pathParams("bookingId", bookingId);

        // Get response with bookings IDs
        Response response = RestAssured.given(spec).get("/booking/{bookingId}");
        response.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify all fields
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Jim", "First name should be Jim, but it's not");
        
        // Do the test for lastname
        String actualLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Brown", "Last name should be Brown, but it's not");
        
        // Do the test for totalprice
        int actualTotalPrice = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(actualTotalPrice, 111, "Total price should be 111, but it's not");
        
        // Do the test for depositpaid
        boolean actualDepositPaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertTrue(actualDepositPaid, "Deposit paid should be true, but it's not");
        
        // Do the test for checkin
        String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin should be 2018-01-01, but it's not");
        
        // Do the test for checkout
        String actualCheckout = response.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout should be 2019-01-01, but it's not");
        
        // Do the test for additionalneeds
        String actualAdditionalNeeds = response.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualAdditionalNeeds, "Breakfast", "Additional needs should be Breakfast, but it's not");
        
        softAssert.assertAll();
    }

    // The `getBookingXMLTest()` method is a test function that verifies the correctness of the
    // response received from a REST API endpoint for a specific booking ID, but this time the response
    // is expected to be in XML format. It creates a booking, sets the path parameter, and sends a GET
    // request to retrieve the booking information in XML format. It then verifies the response status
    // code and all the fields in the response using a SoftAssert.
    @Test
    public void getBookingXMLTest() {

        // Create booking
        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        //Set path parameter
        spec.pathParams("bookingId", responseCreate.jsonPath().getInt("bookingid"));

        // Get response with bookings IDs
        Header xml = new Header("Accept", "application/xml");
        spec.header(xml);
        Response response = RestAssured.given(spec).get("/booking/{bookingId}");
        response.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify all fields
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = response.xmlPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Jim", "First name should be Jim, but it's not");
        
        // Do the test for lastname
        String actualLastName = response.xmlPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName, "Brown", "Last name should be Brown, but it's not");
        
        // Do the test for totalprice
        int actualTotalPrice = response.xmlPath().getInt("booking.totalprice");
        softAssert.assertEquals(actualTotalPrice, 111, "Total price should be 111, but it's not");
        
        // Do the test for depositpaid
        boolean actualDepositPaid = response.xmlPath().getBoolean("booking.depositpaid");
        softAssert.assertTrue(actualDepositPaid, "Deposit paid should be true, but it's not");
        
        // Do the test for checkin
        String actualCheckin = response.xmlPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin should be 2018-01-01, but it's not");
        
        // Do the test for checkout
        String actualCheckout = response.xmlPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout should be 2019-01-01, but it's not");
        
        // Do the test for additionalneeds
        String actualAdditionalNeeds = response.xmlPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualAdditionalNeeds, "Breakfast", "Additional needs should be Breakfast, but it's not");
        
        softAssert.assertAll();
    }
}
