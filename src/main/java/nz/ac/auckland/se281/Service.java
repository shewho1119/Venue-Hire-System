package nz.ac.auckland.se281;

public abstract class Service {

  public String bookingReference;
  public String serviceTypeName;
  public int cost;

  public Service(String bookingReference, String serviceTypeName, int cost) {
    this.bookingReference = bookingReference;
    this.serviceTypeName = serviceTypeName;
    this.cost = cost;
  }

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
