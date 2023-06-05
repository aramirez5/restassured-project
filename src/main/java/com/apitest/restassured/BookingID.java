package com.apitest.restassured;

/**
 * The BookingID class represents a booking ID and its associated booking information.
 */
public class BookingID {
    
    private int bookingid;
    private Booking booking;
    
    // This is a constructor method for the `BookingID` class that takes in two parameters: `bookingid`
    // of type `int` and `booking` of type `Booking`. It sets the values of the `bookingid` and
    // `booking` instance variables of the `BookingID` object being created to the values passed in as
    // parameters.
    public BookingID(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    // This is a default constructor for the `BookingID` class that takes no parameters and does not
    // perform any actions. It is provided to allow for the creation of `BookingID` objects without
    // passing in any initial values for the `bookingid` and `booking` instance variables.
    public BookingID() {
    }

    /**
     * This function returns a string representation of a booking ID and its associated booking.
     * 
     * @return A string representation of a BookingID object, which includes the values of its
     * bookingid and booking attributes.
     */
    @Override
    public String toString() {
        return "BookingID [bookingid=" + bookingid + ", booking=" + booking + "]";
    }

    /**
     * This function returns the booking ID.
     * 
     * @return The method is returning the value of the variable `bookingid`.
     */
    public int getBookingid() {
        return bookingid;
    }

    /**
     * This function sets the booking ID for a booking object in Java.
     * 
     * @param bookingid The parameter `bookingid` is an integer value that represents the unique
     * identifier of a booking. The `setBookingid` method is used to set the value of this parameter
     * for a particular booking object.
     */
    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    /**
     * The function returns a booking object.
     * 
     * @return The method is returning a Booking object.
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * This function sets the booking object for a particular instance of a class.
     * 
     * @param booking The parameter "booking" is an object of the class "Booking". The method
     * "setBooking" sets the value of the instance variable "booking" to the value of the parameter
     * "booking".
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
