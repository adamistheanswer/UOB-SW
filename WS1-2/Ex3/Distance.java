/**
 * Distance is a class for the conversion of KM into metres, miles and yards.
 *
 * @author Adam Robinson
 * @version 2017-10-08
 */

public class Distance {

    private double km; // Field Variables

    /**
     * This constructor defines distance information from KM of the type double.
     *
     * @param km Distance in Kilometres
     */

    public Distance(double km) {
        this.km = km;
    }

    /* Accessor methods to get the information of Distance. */

    /**
     * @return Distance in Miles.
     * Distance in miles calculated from KM conversion / 1.60934
     */

    public double getMiles() {
        return km / 1.60934;
    }

    /**
     * @return Distance in Kilometres.
     */

    public double getKilometres() {
        return km;
    }

    /**
     * @return Distance in Metres.
     * Distance in metres calculated from KM conversion * 1000
     */

    public double getMetres() {
        return km * 1000;
    }

    /**
     * @return Distance in Yards.
     * Distance in yards calculated from KM conversion * (1760[yards] / 1.60934[miles])
     */

    public double getYards() {
        return km * (1760 / 1.60934);
    }

}

