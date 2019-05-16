/**
 * Aircraft is a class for the representation of Aircraft information in the form "maxSpeed,
 * maxWeight, maxPersons"
 *
 * @author Adam Robinson
 * @version 2017-11-08
 */

public class Aircraft {

  private double maxSpeed;
  private double maxWeight;
  private int maxPersons;

  /**
   * This constructor creates aircraft information from three parts: maxSpeed, maxWeight, and
   * maxPersons. Which are a double, an double, and an int, respectively.
   *
   * @param maxSpeed The max speed of the aircraft.
   * @param maxWeight The max weight of the aircraft.
   * @param maxPersons The max persons for the aircraft.
   */

  public Aircraft(double maxSpeed, double maxWeight, int maxPersons) {
    this.maxSpeed = maxSpeed;
    this.maxWeight = maxWeight;
    this.maxPersons = maxPersons;
  }

  /**
   * @param maxSpeed max speed of the aircraft
   */

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  /**
   * @param maxWeight max weight of the aircraft
   */

  public void setMaxWeight(double maxWeight) {
    this.maxWeight = maxWeight;
  }

  /**
   * @param maxPersons max persons for the aircraft
   */

  public void setMaxPersons(int maxPersons) {
    this.maxPersons = maxPersons;
  }

  /**
   * @return max speed of the aircraft
   */

  public double getMaxSpeed() {
    return maxSpeed;
  }

  /**
   * @return max weight of the aircraft
   */

  public double getMaxWeight() {
    return maxWeight;
  }

  /**
   * @return max persons for the aircraft
   */

  public int getMaxPersons() {
    return maxPersons;
  }

  /**
   * @return The print format of the aircraft information
   *
   * maxPersons == 1
   *
   * "The aircraft has a
   * maximal speed of [maxSpeed] km/h and a maximal weight of [maxWeight] kg. It can carry
   * [maxPersons] person.
   *
   * else
   *
   * "The aircraft has a maximal speed of [maxSpeed] km/h and a maximal
   * weight of [maxWeight] kg. It can carry [maxPersons] persons.
   */

  @Override
  public String toString() {
    if (maxPersons == 1) {
      return "The aircraft has a maximal speed of " + maxSpeed + " km/h and a maximal weight of "
          + maxWeight + " kg. It can carry " + maxPersons + " person.";
    } else {
      return "The aircraft has a maximal speed of " + maxSpeed + " km/h and a maximal weight of "
          + maxWeight + " kg. It can carry " + maxPersons + " persons.";
    }

  }
}

