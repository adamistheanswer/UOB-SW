/**
 * HotAirBalloon is a subclass of Aircraft. HotAirBalloon extends Aircraft information in the form
 * "maxSpeed, maxWeight, maxPersons" while also defining "gasTemperature"
 *
 * @author Adam Robinson
 * @version 2017-11-08
 */

public class HotAirBalloon extends Aircraft {

  private double gasTemperature;

  /**
   * This constructor creates HotAirBalloon information from four parts: maxSpeed, maxWeight,
   * maxPersons and gasTemperature. Which are a double, an double, an int, and a double
   * respectively.
   *
   * @param maxSpeed The max speed of the hot air balloon.
   * @param maxWeight The max weight of the hot air balloon.
   * @param maxPersons The max persons for the hot air balloon.
   * @param gasTemperature The max range of the hot air balloon.
   */

  public HotAirBalloon(double maxSpeed, double maxWeight, int maxPersons, double gasTemperature) {
    super(maxSpeed, maxWeight, maxPersons);
    this.gasTemperature = gasTemperature;
  }

  /**
   * @param gasTemperature Gas temperature of the hot air balloon
   */

  public void setGasTemperature(double gasTemperature) {
    this.gasTemperature = gasTemperature;
  }

  /**
   * @return Gas temperature of the hot air balloon
   */

  public double getGasTemperature() {
    return gasTemperature;
  }

  /**
   * @return The print format of the hot air balloon information "The aircraft has a maximal speed
   * of [maxSpeed] km/h and a maximal weight of [maxWeight] kg. It has a gas temperature of
   * maximally [gasTemperature] °C.
   */

  @Override
  public String toString() {
    return super.toString() + " It has a gas temperature of maximally " + gasTemperature + "°C.";

  }
}
