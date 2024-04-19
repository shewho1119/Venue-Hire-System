package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class FloralSystem extends Service {

  public FloralType floralType;

  public FloralSystem(String bookingReference, FloralType floralType) {
    super(bookingReference, floralType.getName());
    this.floralType = floralType;
  }

  public int getCost() {
    return floralType.getCost();
  }
}
