/**
 * Aeroplane is a subclass of Aircraft. Aeroplane extends Aircraft information in the form
 * "maxSpeed, maxWeight, maxPersons" while also defining "range"
 *
 * @author Adam Robinson
 * @version 2017-11-08
 */

public class Aeroplane extends Aircraft {

  private double range;

  /**
   * This constructor creates aeroplane information from four parts: maxSpeed, maxWeight, maxPersons
   * and range. Which are a double, an double, an int, and a double respectively.
   *
   * @param maxSpeed The max speed of the aeroplane.
   * @param maxWeight The max weight of the aeroplane.
   * @param maxPersons The max persons for the aeroplane.
   * @param range The max range of the aeroplane.
   */

  public Aeroplane(double maxSpeed, double maxWeight, int maxPersons, double range) {
    super(maxSpeed, maxWeight, maxPersons);
    this.range = range;
  }

  /**
   * @param range range of the aeroplane
   */

  public void setRange(double range) {
    this.range = range;
  }

  /**
   * @return range of the aeroplane
   */

  public double getRange() {
    return range;
  }

  /**
   * @return The print format of the aeroplane information "The aircraft has a maximal speed of
   * [maxSpeed] km/h and a maximal weight of [maxWeight] kg. It has a range of [range] km.
   */

  @Override
  public String toString() {
    return super.toString() + " It has a range of " + range + " km.";

  }
}


