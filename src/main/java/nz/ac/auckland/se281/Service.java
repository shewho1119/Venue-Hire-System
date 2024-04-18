package nz.ac.auckland.se281;

public abstract class Service {

  public String bookingReference;
  public String cateringTypeName;
  public int cost;

  public Service(String bookingReference, String cateringTypeName, int cost) {
    this.bookingReference = bookingReference;
    this.cateringTypeName = cateringTypeName;
    this.cost = cost;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public String getcateringTypeName() {
    return cateringTypeName;
  }

  public int cost() {
    return cost;
  }
}
