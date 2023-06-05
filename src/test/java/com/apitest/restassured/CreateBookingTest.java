package com.apitest.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * This is a Java test class that creates a booking and verifies the response fields using assertions.
 */
public class CreateBookingTest extends BaseTest {
    
    /**
     * This is a test function in Java that creates a booking and verifies the response status code and
     * all the fields of the booking.
     */
    @Test(enabled = false)
    public void createBookingTest() {
        
        Response response = createBooking();
        response.prettyPrint();

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify all fields
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Jim", "First name should be Jim, but it's not");
        
        // Do the test for lastname
        String actualLastName = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName, "Brown", "Last name should be Brown, but it's not");
        
        // Do the test for totalprice
        int actualTotalPrice = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(actualTotalPrice, 111, "Total price should be 111, but it's not");
        
        // Do the test for depositpaid
        boolean actualDepositPaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertTrue(actualDepositPaid, "Deposit paid should be true, but it's not");
        
        // Do the test for checkin
        String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin should be 2018-01-01, but it's not");
        
        // Do the test for checkout
        String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout should be 2019-01-01, but it's not");
        
        // Do the test for additionalneeds
        String actualAdditionalNeeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualAdditionalNeeds, "Breakfast", "Additional needs should be Breakfast, but it's not");
        
        softAssert.assertAll();
    }

    /**
     * This is a test function in Java that creates a booking using a POJO and verifies the response
     * status code and all fields using assertions.
     */
    @Test
    public void createBookingWithPOJOTest() {
        
        // Create body using POJO
        BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
        Booking booking = new Booking("Jim", "Brown", 111, true, bookingDates, "Breakfast");

        // Get response
        Response response = RestAssured.
            given(spec).
            contentType(ContentType.JSON).
            body(booking).
            post("/booking");
        response.prettyPrint();
        
        BookingID bookingid = response.as(BookingID.class);

        // Verify response status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        System.out.println("Request Booking: " + bookingid.toString());
        System.out.println("Response Booking: " + bookingid.getBooking().toString());

        // Verify all fields
        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
    }
}
