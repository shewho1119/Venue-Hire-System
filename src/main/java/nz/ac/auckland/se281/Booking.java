package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String venueCodeInput;
  private String requestedDate;
  private String email;
  private String attendees;

  public Booking(String referenceCode, String code, String date, String email, String attendees) {
    this.bookingReference = referenceCode;
    this.venueCodeInput = code;
    this.requestedDate = date;
    this.email = email;
    this.attendees = attendees;

  }

}
