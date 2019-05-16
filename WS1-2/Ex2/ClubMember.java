/**
 * ClubMember is a class for the representation of club member
 * information in the form "Name, DoB, ID Number, Membership type"
 *
 * @author Adam Robinson
 * @version 2017-10-08
 */

public class ClubMember {

    private String name;
    private String dateOfBirth;
    private String registrationNumber;
    private String membershipType;  //Field Variables

    /**
     * This constructor creates membership information from four parts: name,
     * dateOfBirth, registrationNumber, membershipType. All of which are strings.
     *
     * @param name               The members name.
     * @param dateOfBirth        The members date of birth.
     * @param registrationNumber The members registration number.
     * @param membershipType     The membership type.
     */

    public ClubMember(String name, String dateOfBirth, String registrationNumber, String membershipType) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.registrationNumber = registrationNumber;
        this.membershipType = membershipType;
    }

     /* Accessor methods to get the information of a Membership. */

    /**
     * @return The members name.
     */

    public String getName() {
        return name;
    }

    /**
     * @return The members date of birth.
     */

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return The members registration number.
     */

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @return The members registration type.
     */

    public String getMembershipType() {
        return membershipType;
    }

    /**
     * @return The print format of the membership information "[[name], [dateOfBirth], ID: [registrationNumber], [membershipType]]"
     */

    @Override
    public String toString() {
        return "[" + name + ", " + dateOfBirth + ", ID: " + registrationNumber + ", " + membershipType + "]";
    }

}