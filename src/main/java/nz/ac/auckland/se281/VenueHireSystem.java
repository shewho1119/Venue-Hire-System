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
    MessageCli.DATE_SET.printMessage(systemDate);
  }

  public void printSystemDate() {
    // If the system date is not set, print the message
    if (systemDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
      return;
    } else {
      // print the system date
      MessageCli.CURRENT_DATE.printMessage(systemDate);
    }
  }

  private ArrayList<Booking> bookingList = new ArrayList<Booking>();

  public void makeBooking(String[] options) {

    // If there is no venue created in the system
    if (venueList.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    // If the system date has not been set yet
    if (systemDate == null) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }

    String referenceCode = BookingReferenceGenerator.generateBookingReference();
    String code = options[0];
    String date = options[1];
    String email = options[2];
    String attendees = options[3];

    // if the Booking Date is past the System Date
    if (isBookingDatePast(date)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(date, systemDate);
      return;
    }

    // Create a new booking object
    Booking booking = new Booking(referenceCode, code, date, email, attendees);
    bookingList.add(booking);

    boolean venueCodeExist = false;

    // Get the name of the venue by using the venue code
    for (int i = 0; i < venueList.size(); i++) {
      Venue venue = venueList.get(i);
      if (venue.getVenueCode().equals(code)) {
        venueCodeExist = true;
        String bookingNameVenue = venue.getVenueName();
        MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
            referenceCode, bookingNameVenue, date, attendees);
        return;
      }
    }

    // If the corresponding venue code not found in the system
    if (!venueCodeExist) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(code);
      return;
    }
  }

  private boolean isBookingDatePast(String bookingDate) {
    // Booking Date split
    String[] bookingDateParts = bookingDate.split("/");
    int bookingDay = Integer.parseInt(bookingDateParts[0]); // "26"
    int bookingMonth = Integer.parseInt(bookingDateParts[1]); // "02"
    int bookingYear = Integer.parseInt(bookingDateParts[2]); // "2024"

    // System Date split
    String[] systemDateParts = systemDate.split("/");
    int systemDay = Integer.parseInt(systemDateParts[0]); // "26"
    int systemMonth = Integer.parseInt(systemDateParts[1]); // "02"
    int systemYear = Integer.parseInt(systemDateParts[2]); // "2024"

    if (bookingYear < systemYear) {
      return true;
    } else if (bookingYear == systemYear && bookingMonth < systemMonth) {
      return true;
    } else if (bookingYear == systemYear && bookingMonth == systemMonth && bookingDay < systemDay) {
      return true;
    }

    return false;
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
