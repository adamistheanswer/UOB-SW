/**
 * Film is a class for the representation of Film information in the form "Title, Year, Length"
 *
 * @author Adam Robinson
 * @version 2017-10-08
 */

public class Film {
    private String title;
    private int year;
    private int length; //Field Variables

    /**
     * This constructor creates Film information from three parts: Title,
     * year, and length. Which are a String, an int, and an int,
     * respectively.
     *
     * @param title  The title of the film.
     * @param year   The year in which the film was released.
     * @param length The length of the film.
     */

    public Film(String title, int year, int length) {
        this.title = title;
        this.year = year;
        this.length = length;
    }

    /* Accessor methods to get the information of a Film. */

    /**
     * @return The title of the film.
     */

    public String getTitle() {
        return title;
    }

    /**
     * @return The year of the films release.
     */

    public int getYear() {
        return year;
    }

    /**
     * @return The length of the film.
     */

    public int getLength() {
        return length;
    }

     /* Next is the setter method used to set the Film length. */

    /**
     * @param newlength the length is set to newLength
     */

    public void setLength(int newlength) {
        this.length = newlength;
    }

    /**
     * @return The print format of the film information "Film Title: [title], Release Year: [year], Running Length: [length]"
     */

    public String toString() {
        return "Film Title: " + title + ", Release Year: " + year + ", Running Length: " + length;
    }

}
