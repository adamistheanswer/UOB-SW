import java.util.ArrayList;

public class BuildClassMain {

  public static void main(String[] args) {

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

    System.out.println(build1.buildClass());
  }
}
