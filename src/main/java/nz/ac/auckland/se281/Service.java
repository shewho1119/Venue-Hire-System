package nz.ac.auckland.se281;

public abstract class Service {

  private String bookingReference;
  private String serviceTypeName;
  private int cost;

  public Service(String bookingReference, String serviceTypeName, int cost) {
    this.bookingReference = bookingReference;
    this.serviceTypeName = serviceTypeName;
    this.cost = cost;
  }

  // getter methods for Service entities
  public String getBookingReference() {
    return bookingReference;
  }

  public String getserviceTypeName() {
    return serviceTypeName;
  }

  public int getCost() {
    return cost;
  }
}
