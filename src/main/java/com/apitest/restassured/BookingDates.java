package com.apitest.restassured;

/**
 * The BookingDates class represents a booking with check-in and check-out dates.
 */
public class BookingDates {
    
    private String checkin;
    private String checkout;
    
    // This is a constructor method for the `BookingDates` class that takes two parameters, `checkin`
    // and `checkout`, both of type `String`. When an object of the `BookingDates` class is created
    // using this constructor, the `checkin` and `checkout` instance variables of the object are set to
    // the values passed in as parameters. The `this` keyword is used to refer to the instance
    // variables of the object being created.
    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // This is a default constructor for the `BookingDates` class that takes no parameters. It does not
    // do anything, but it is useful to have a default constructor in case an object of the
    // `BookingDates` class needs to be created without specifying any initial values for the `checkin`
    // and `checkout` instance variables.
    public BookingDates() {
    }

   /**
    * This is a Java function that overrides the default toString() method to return a string
    * representation of BookingDates object with checkin and checkout dates.
    * 
    * @return A string representation of the BookingDates object, which includes the check-in and
    * check-out dates.
    */
    @Override
    public String toString() {
        return "BookingDates [checkin=" + checkin + ", checkout=" + checkout + "]";
    }

    /**
     * This Java function returns the value of the checkin variable as a string.
     * 
     * @return The method `getCheckin()` is returning a `String` value, which is the value of the
     * variable `checkin`.
     */
    public String getCheckin() {
        return checkin;
    }

    /**
     * This function sets the check-in date for a reservation.
     * 
     * @param checkin The parameter "checkin" is a String variable that represents the check-in date of
     * a hotel reservation. The method "setCheckin" sets the value of the check-in date for the current
     * instance of the hotel reservation object.
     */
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    /**
     * The function returns a string value for the checkout.
     * 
     * @return The method `getCheckout()` is returning a `String` variable named `checkout`.
     */
    public String getCheckout() {
        return checkout;
    }

    /**
     * This Java function sets the value of a variable called "checkout".
     * 
     * @param checkout The parameter "checkout" is a String variable that is being set to a value
     * passed as an argument to the method. The method is likely part of a class that has a checkout
     * property, and this method is used to set the value of that property.
     */
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
