/**
 * Var is a class for representing Variable information in the form "typeofVar and nameOfVar"
 *
 * @author Adam Robinson
 * @version 2017-11-22
 */

public class Var {

  private String typeOfVar;
  private String nameOfVar;

  /**
   * This constructor creates Variable information from two parts: typeofVar
   * and nameOfVar. Which are Strings respectively.
   *
   * @param typeOfVar The Type of the variable
   * @param nameOfVar The Name of the variable
   */

  public Var(String typeOfVar, String nameOfVar) {
    this.typeOfVar = typeOfVar;
    this.nameOfVar = nameOfVar;
  }

  /**
   *  Getter for the type of a Variable
   *  @return The type of the Variable
   */

  public String getTypeOfVar() {
    return typeOfVar;
  }

  /**
   *  Getter for the Name of a Variable
   *  @return The Name of the Variable
   */

  public String getNameOfVar() {
    return nameOfVar;
  }

  /**
   * @return The print format of Variable information "[typeOfVar] [nameOFVar]"
   */

  @Override
  public String toString() {
    return typeOfVar+ " " + nameOfVar;
  }
}
