/**
 * Car is a class for the representation of car information in the form "maxSpeed, carNumber, make"
 *
 * @author Adam Robinson
 * @version 2017-11-10
 */

public class Car implements Sortable {

  private double maxSpeed;
  private String carNumber;
  private String make;

  /**
   * This constructor creates car information from three parts: maxSpeed, carNumber, and make. Which
   * are a double, string, and string, respectively.
   *
   * @param maxSpeed The max speed of the car
   * @param carNumber The registration number of the car
   * @param make The manufacturer of the car
   */

  public Car(double maxSpeed, String carNumber, String make) {
    this.maxSpeed = maxSpeed;
    this.carNumber = carNumber;
    this.make = make;
  }

  /**
   * @return The max speed of the car
   */

  public double compareValue() {
    return maxSpeed;
  }

  /**
   * @return The print format of the car information "car max speed: [maxSpeed] car number:
   * [carNumber] car make: [make]"
   */

  @Override
  public String toString() {
    return "car max speed: " + maxSpeed + " car number: " + carNumber + " car make: " + make;
  }
}
