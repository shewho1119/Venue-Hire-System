package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    // No venues in the system
    if (venueList.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
      return;
    }

    // one venue in the system
    if (venueList.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      Venue venueOne = venueList.get(0);
      MessageCli.VENUE_ENTRY.printMessage(
          venueOne.getVenueName(),
          venueOne.getVenueCode(),
          venueOne.getCapacity(),
          venueOne.getHireFee(),
          "TODO");
      return;
    }

    // string array to store the number of venues
    String[] numberOfVenues = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // more than 1 venue and less than 10 venues in the system
    if (venueList.size() > 1 && venueList.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", numberOfVenues[venueList.size() - 2], "s");
      for (int i = 0; i < venueList.size(); i++) {
        Venue venue = venueList.get(i);
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getCapacity(),
            venue.getHireFee(),
            "TODO");
      }
      return;
    }

    // 10 or more venues in the system
    if (venueList.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueList.size()), "s");
      for (int i = 0; i < venueList.size(); i++) {
        Venue venue = venueList.get(i);
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getCapacity(),
            venue.getHireFee(),
            "TODO");
      }
      return;
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // if venue name empty, print error message
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // invalid input for capacity
    try {
      // Convert the capacity to integer
      int capacity = Integer.parseInt(capacityInput);

      // When the capacity is negative or not over 0, print the error message
      if (capacity <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }
      // When capacity is not a number, print the error message
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    // invalid input for hirefee
    try {
      // Convert the hirefee to integer
      int hireFee = Integer.parseInt(hireFeeInput);

      // When the hirefee is negative or not over 0, print the error message
      if (hireFee <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
      // When hirefee is not a number, print the error message
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    // venue code already exists
    for (int i = 0; i < venueList.size(); i++) {
      if (venueList.get(i).getVenueCode().equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
            venueCode, venueList.get(i).getVenueName());
        return;
      }
    }

    // Add the venue informations to the venueList
    Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venueList.add(venue);
    // Print the successful message
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  private String systemDate;

  public void setSystemDate(String dateInput) {
    this.systemDate = dateInput;
  }

  public void printSystemDate() {
    // If the system date is not set, print the message
    if (systemDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
      return;
    }
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
