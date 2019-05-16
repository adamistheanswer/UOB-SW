import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Robinson
 */
public class AircraftTest {

  private Aircraft aircraft;
  private Aeroplane aeroplane;
  private HotAirBalloon hotAirBalloon;

  @Before
  public void setUp() {
    aircraft = new Aircraft(100, 101, 102);
    aeroplane = new Aeroplane(103, 104, 105, 106);
    hotAirBalloon = new HotAirBalloon(107, 108, 109, 110);

  }

  // Set max value to all objects maxPersons field and test toString
  // Range and GasTemperature Max in respective objects
  @Test
  public void test1() {

    aircraft.setMaxPersons(Integer.MAX_VALUE);
    aeroplane.setMaxPersons(Integer.MAX_VALUE);
    hotAirBalloon.setMaxPersons(Integer.MAX_VALUE);
    aeroplane.setRange(Integer.MAX_VALUE);
    hotAirBalloon.setGasTemperature(Integer.MAX_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of 100.0 km/h and a maximal weight of 101.0 kg."
            + " It can carry 2147483647 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of 103.0 km/h and a maximal weight of 104.0 kg."
            + " It can carry 2147483647 persons. It has a range of 2.147483647E9 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of 107.0 km/h and a maximal weight of 108.0 kg. It can carry 2147483647 persons."
            + " It has a gas temperature of maximally 2.147483647E9\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }

  // Set min value to all objects maxpersons field and test toString
  // Range and GasTemperature MIN in respective objects
  @Test
  public void test2() {

    aircraft.setMaxPersons(Integer.MIN_VALUE);
    aeroplane.setMaxPersons(Integer.MIN_VALUE);
    hotAirBalloon.setMaxPersons(Integer.MIN_VALUE);
    aeroplane.setRange(Integer.MIN_VALUE);
    hotAirBalloon.setGasTemperature(Integer.MIN_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of 100.0 km/h and a maximal weight of 101.0 kg."
            + " It can carry -2147483648 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of 103.0 km/h and a maximal weight of 104.0 kg."
            + " It can carry -2147483648 persons. It has a range of -2.147483648E9 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of 107.0 km/h and a maximal weight of 108.0 kg. It can carry -2147483648 persons."
            + " It has a gas temperature of maximally -2.147483648E9\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }


  // Set max value to all objects maxpersons field and test toString
  @Test
  public void test3() {

    aircraft.setMaxWeight(Integer.MAX_VALUE);
    aeroplane.setMaxWeight(Integer.MAX_VALUE);
    hotAirBalloon.setMaxWeight(Integer.MAX_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of 100.0 km/h and a maximal weight of 2.147483647E9 kg."
            + " It can carry 102 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of 103.0 km/h and a maximal weight of 2.147483647E9 kg."
            + " It can carry 105 persons. It has a range of 106.0 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of 107.0 km/h and a maximal weight of 2.147483647E9 kg. It can carry 109 persons."
            + " It has a gas temperature of maximally 110.0\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }

  // Set min value to all objects maxpersons field and test toString
  @Test
  public void test4() {

    aircraft.setMaxWeight(Integer.MIN_VALUE);
    aeroplane.setMaxWeight(Integer.MIN_VALUE);
    hotAirBalloon.setMaxWeight(Integer.MIN_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of 100.0 km/h and a maximal weight of -2.147483648E9 kg."
            + " It can carry 102 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of 103.0 km/h and a maximal weight of -2.147483648E9 kg."
            + " It can carry 105 persons. It has a range of 106.0 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of 107.0 km/h and a maximal weight of -2.147483648E9 kg. It can carry 109 persons."
            + " It has a gas temperature of maximally 110.0\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }

  // Set min value to all objects maxSpeed field and test toString
  @Test
  public void test5() {

    aircraft.setMaxSpeed(Integer.MIN_VALUE);
    aeroplane.setMaxSpeed(Integer.MIN_VALUE);
    hotAirBalloon.setMaxSpeed(Integer.MIN_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of -2.147483648E9 km/h and a maximal weight of 101.0 kg."
            + " It can carry 102 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of -2.147483648E9 km/h and a maximal weight of 104.0 kg."
            + " It can carry 105 persons. It has a range of 106.0 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of -2.147483648E9 km/h and a maximal weight of 108.0 kg. It can carry 109 persons."
            + " It has a gas temperature of maximally 110.0\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }

  // Set max value to all objects maxpersons field and test toString
  @Test
  public void test6() {

    aircraft.setMaxSpeed(Integer.MAX_VALUE);
    aeroplane.setMaxSpeed(Integer.MAX_VALUE);
    hotAirBalloon.setMaxSpeed(Integer.MAX_VALUE);

    String expected1 =
        "The aircraft has a maximal speed of 2.147483647E9 km/h and a maximal weight of 101.0 kg."
            + " It can carry 102 persons.";
    String actual1 = aircraft.toString();

    assertEquals(expected1, actual1);

    String expected2 =
        "The aircraft has a maximal speed of 2.147483647E9 km/h and a maximal weight of 104.0 kg."
            + " It can carry 105 persons. It has a range of 106.0 km.";
    String actual2 = aeroplane.toString();

    assertEquals(expected2, actual2);

    String expected3 =
        "The aircraft has a maximal speed of 2.147483647E9 km/h and a maximal weight of 108.0 kg. It can carry 109 persons."
            + " It has a gas temperature of maximally 110.0\u00B0C.";
    String actual3 = hotAirBalloon.toString();

    assertEquals(expected3, actual3);

  }

}
