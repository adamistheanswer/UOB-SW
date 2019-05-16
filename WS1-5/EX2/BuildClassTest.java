import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;

/**
 * @author Adam Robinson
 */

public class BuildClassTest {

  // Make Fields Method Test
  @Test
  public void test1() {

    Var var1 = new Var("double", "varName1");
    Var var2 = new Var("int", "varName2");
    Var var3 = new Var("String", "varName3");
    Var var4 = new Var("ArrayList<Double>", "varName4");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);
    variables.add(var2);
    variables.add(var3);
    variables.add(var4);

    BuildClass build1 = new BuildClass("ClassName", variables);

    String expected1 =
        "private double varName1;\n"
            + "private int varName2;\n"
            + "private String varName3;\n"
            + "private ArrayList<Double> varName4;\n";

    String actual1 = build1.makeFields();

    assertEquals(expected1, actual1);

  }

  // Make Constructor Method Test
  @Test
  public void test2() {

    Var var1 = new Var("double", "varName1");
    Var var2 = new Var("int", "varName2");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);
    variables.add(var2);

    BuildClass build2 = new BuildClass("ClassName", variables);

    String expected1 =
        "public ClassName(double varName1, int varName2) {\n"
            + "   this.varName1 = varName1;\n"
            + "   this.varName2 = varName2;\n"
            + "}";

    String actual1 = build2.makeConstructor();

    assertEquals(expected1, actual1);

  }

  // Make Setters Method Test
  @Test
  public void test3() {

    Var var1 = new Var("double", "varName1");
    Var var2 = new Var("int", "varName2");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);
    variables.add(var2);

    BuildClass build3 = new BuildClass("ClassName", variables);

    String expected1 =
        "public void setVarName1(double varName1) { \n"
            + "  this.varName1 = varName1;\n"
            + "}\n"
            + "\n"
            + "public void setVarName2(int varName2) { \n"
            + "  this.varName2 = varName2;\n"
            + "}\n"
            + "\n";

    String actual1 = build3.makeSetters();

    assertEquals(expected1, actual1);

  }

  // Make Getters Method Test
  @Test
  public void test4() {
    Var var1 = new Var("double", "varName1");
    Var var2 = new Var("int", "varName2");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);
    variables.add(var2);

    BuildClass build4 = new BuildClass("ClassName", variables);

    String expected1 =
        "public double getVarName1() { \n"
            + "  return varName1;\n"
            + "}\n"
            + "\n"
            + "public int getVarName2() { \n"
            + "  return varName2;\n"
            + "}\n"
            + "\n";

    String actual1 = build4.makeGetters();

    assertEquals(expected1, actual1);

  }

  // Build Class Method Test
  @Test
  public void test5() {
    Var var1 = new Var("double", "varName1");
    Var var2 = new Var("int", "varName2");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);
    variables.add(var2);

    BuildClass build5 = new BuildClass("ClassName", variables);

    String expected1 =
        "public class ClassName{\n"
            + "\n"
            + "private double varName1;\n"
            + "private int varName2;\n"
            + "\n"
            + "public ClassName(double varName1, int varName2) {\n"
            + "   this.varName1 = varName1;\n"
            + "   this.varName2 = varName2;\n"
            + "}\n"
            + "\n"
            + "public double getVarName1() { \n"
            + "  return varName1;\n"
            + "}\n"
            + "\n"
            + "public int getVarName2() { \n"
            + "  return varName2;\n"
            + "}\n"
            + "\n"
            + "public void setVarName1(double varName1) { \n"
            + "  this.varName1 = varName1;\n"
            + "}\n"
            + "\n"
            + "public void setVarName2(int varName2) { \n"
            + "  this.varName2 = varName2;\n"
            + "}\n"
            + "\n"
            + "}";

    String actual1 = build5.buildClass();

    assertEquals(expected1, actual1);
  }

  // Class Name Getter Test
  @Test
  public void test6() {

    Var var1 = new Var("double", "varName1");

    ArrayList<Var> variables = new ArrayList<>();
    variables.add(var1);

    BuildClass build6 = new BuildClass("ClassNameTest", variables);

    String expected1 =
        "ClassNameTest";

    String actual1 = build6.getClassName();

    assertEquals(expected1, actual1);

  }
}
