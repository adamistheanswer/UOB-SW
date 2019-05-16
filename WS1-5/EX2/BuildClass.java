import java.util.ArrayList;

/**
 * BuildClass is a class for outputting a complete class file in the console. A class in generated
 * from from the inputs "Class name and objects of type Var"
 *
 * @author Adam Robinson
 * @version 2017-11-22
 */

public class BuildClass {

  private String className;
  private ArrayList<Var> fields;

  /**
   * This constructor creates BuildClass information from two parts: className and Fields. Which are
   * a String, and an ArrayList containing objects of type Var respectively.
   *
   * @param className Name of the class to be generated
   * @param fields ArrayList Containing objects of type Var (Variable)
   */

  public BuildClass(String className, ArrayList<Var> fields) {
    this.className = className;
    this.fields = fields;
  }

  /**
   * Getter to return name for Class
   *
   * @return Class Name
   */

  public String getClassName() {
    return className;
  }


  /**
   * Method for outputting Field Variables as a string
   *
   * @return Field Variables as a string
   */

  public String makeFields() {
    StringBuilder fieldsText = new StringBuilder();
    for (Var el : fields) {
      fieldsText.append("private ").append(el).append(";\n");
    }
    return fieldsText.toString();
  }

  /**
   * Method for outputting Constructor as a string
   *
   * @return Constructor as a string
   */

  public String makeConstructor() {
    String fieldsConstL1 = "";
    String constTextStart = ("public " + getClassName() + "(");
    for (Var el : fields) {
      fieldsConstL1 += (" " + el + ",");
    }
    String line1 =
        constTextStart + fieldsConstL1.substring(1, fieldsConstL1.length() - 1) + ") {\n";

    StringBuilder thisText = new StringBuilder();
    for (Var el2 : fields) {
      thisText.append("   this." + el2.getNameOfVar() + " = " + el2.getNameOfVar() + ";\n");
    }

    return line1 + thisText + "}";
  }

  /**
   * Method for outputting Getters as a string
   *
   * @return Getters as a string
   */

  public String makeGetters() {

    StringBuilder getterText = new StringBuilder();
    for (Var el : fields) {
      getterText.append(
          "public " + el.getTypeOfVar() + " get" + (el.getNameOfVar().substring(0, 1).toUpperCase()
              + el.getNameOfVar().substring(1)) + "() { \n" + "  return " + el.getNameOfVar() + ";"
              + "\n}\n\n");
    }
    return String.valueOf(getterText);
  }

  /**
   * Method for outputting Setters as a String
   *
   * @return Setters as a string
   */

  public String makeSetters() {

    StringBuilder setterText = new StringBuilder();
    for (Var el : fields) {
      setterText.append(
          "public void" + " set" + (el.getNameOfVar().substring(0, 1).toUpperCase()
              + el.getNameOfVar().substring(1)) + "(" + el.getTypeOfVar() + " " + el.getNameOfVar()
              + ") { \n" + "  this." + el.getNameOfVar() + " = " + el.getNameOfVar() + ";"
              + "\n}\n\n");
    }
    return String.valueOf(setterText);
  }

  /**
   * Method for combining outputs from makeFields, makeConstructor, makeGetters and makeSetters as a
   * unified class file of type String
   *
   * @return String representing all of the component pieces of a class file
   */

  public String buildClass() {

    return "public class " + getClassName() + "{\n\n" + makeFields() + "\n" + makeConstructor()
        + "\n" + "\n" + makeGetters() + makeSetters() + "}";
  }

}


