package com.apitest.restassured;

/**
 * The Booking class represents a booking with information such as the guest's name, total price,
 * deposit status, booking dates, and additional needs.
 */
public class Booking {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    // This is a constructor for the Booking class that takes in several parameters (firstname,
    // lastname, totalprice, depositpaid, bookingdates, and additionalneeds) and initializes the
    // corresponding instance variables of the Booking object with those values.
    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates,
            String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    // This is a default constructor for the `Booking` class that takes no parameters and does not
    // perform any actions. It is used to create a new instance of the `Booking` class with default
    // values for its instance variables.
    public Booking() {
    }
    
    /**
     * This is a Java function that overrides the default toString() method to return a string
     * representation of a Booking object.
     * 
     * @return A string representation of a Booking object, which includes the values of its instance
     * variables (firstname, lastname, totalprice, depositpaid, bookingdates, and additionalneeds).
     */
    @Override
    public String toString() {
        return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
                + ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
                + additionalneeds + "]";
    }

    // This is a getter method for the `firstname` instance variable of the `Booking` class. It returns
    // the value of the `firstname` variable when called.
    public String getFirstname() {
        return firstname;
    }

    /**
     * This function sets the value of the "firstname" variable in a Java class.
     * 
     * @param firstname The parameter "firstname" is a String type variable that represents the first
     * name of a person. The "setFirstname" method is used to set the value of this variable.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * The function returns the value of the "lastname" variable as a string.
     * 
     * @return The `getLastname()` method is returning a `String` value, which is the `lastname`
     * variable.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * This function sets the value of the "lastname" variable for an object.
     * 
     * @param lastname The parameter "lastname" is a String type variable that represents the last name
     * of a person. The "setLastname" method is used to set the value of this variable.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * The function returns the total price.
     * 
     * @return The method `getTotalprice()` is returning an integer value, which is the value of the
     * variable `totalprice`.
     */
    public int getTotalprice() {
        return totalprice;
    }

    /**
     * This function sets the value of the "totalprice" variable.
     * 
     * @param totalprice The parameter "totalprice" is an integer variable that represents the total
     * price of a product or service. The method "setTotalprice" sets the value of this variable.
     */
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * The function returns a boolean value indicating whether a deposit has been paid or not.
     * 
     * @return The method is returning a boolean value, which indicates whether a deposit has been paid
     * or not.
     */
    public boolean isDepositpaid() {
        return depositpaid;
    }

    /**
     * This function sets the value of the "depositpaid" boolean variable.
     * 
     * @param depositpaid a boolean variable that represents whether a deposit has been paid or not.
     * The method setDepositpaid() sets the value of this variable.
     */
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    /**
     * The function returns the booking dates for a booking.
     * 
     * @return The method is returning an object of type `BookingDates`.
     */
    public BookingDates getBookingdates() {
        return bookingdates;
    }

    /**
     * This function sets the booking dates for a booking object.
     * 
     * @param bookingdates It is a parameter of type BookingDates that is being set to the instance
     * variable bookingdates of the current object. This method is likely part of a class that has a
     * bookingdates instance variable and is used to set its value.
     */
    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    /**
     * This function returns the additional needs of a certain object.
     * 
     * @return The method is returning a String value which represents the additional needs.
     */
    public String getAdditionalneeds() {
        return additionalneeds;
    }

    /**
     * This Java function sets the value of the "additionalneeds" variable.
     * 
     * @param additionalneeds This is a parameter of type String that represents any additional needs
     * or requirements that a user may have. This method sets the value of the additionalneeds instance
     * variable to the value passed as a parameter.
     */
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
