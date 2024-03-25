package nz.ac.auckland.se281;

import java.lang.reflect.Array;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

import java.util.ArrayList;

public class VenueHireSystem {

  ArrayList<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    
        // Add the venue informations to the venueList
        Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
        venueList.add(venue);
        // Print the successful message
        MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
        
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
