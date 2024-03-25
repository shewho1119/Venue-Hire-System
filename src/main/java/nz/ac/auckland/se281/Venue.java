package nz.ac.auckland.se281;
public class Venue {
  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;

  public Venue(String name, String code, String capacity, String hireFee) {
      this.venueName = name;
      this.venueCode = code;
      this.capacity = capacity;
      this.hireFee = hireFee;
  }
}
