/**
 * Employee is a class for the calculation of an employees wage
 * based on hours worked multiplied by hourly salary. This class can also
 * be used to calculate monthly wage and wage percentage increase.
 *
 * @author Adam Robinson
 * @version 2017-10-12
 */

public class Employee {

    private String name;
    private double hourlySalary;
    private int numberOfHours;

    /**
     * This constructor defines employee information from name,
     * hourly salary [hourlySalary] and number of hours worked
     * [numberOfHours]. Which are a String, a double, and an int,
     * respectively.
     *
     * @param name Name of employee
     * @param hourlySalary Employee hourly Salary
     * @param numberOfHours Hours worked by employee
     */

    public Employee(String name, double hourlySalary, int numberOfHours) {
        this.name = name;
        this.hourlySalary = hourlySalary;
        this.numberOfHours = numberOfHours;
    }

    /* Accessor methods to get the information for an employee. */

    /**
     * @return The name of the employee.
     */

    public String getName() {
        return name;
    }

    /**
     * @return The hourly Salary of the employee.
     */

    public double getHourlySalary() {
        return hourlySalary;
    }

    /**
     * @return The number of hours worked by the employee.
     */

    public int getNumberOfHours() {
        return numberOfHours;
    }

    /* Setter methods to get the information for an employee. */

    /**
     * @param name sets name of the employee.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param hourlySalary sets hourly salary of the employee.
     */

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    /**
     * @param numberOfHours sets number of hours worked by the employee.
     */

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    /**
     * @return The print format of the employee information.
     * [name] has an hourly salary of [hourlySalary] £ and has worked last month for [numberOfHours] hours.
     */

    @Override
    public String toString() {
        return
                name + " has an hourly salary of " + hourlySalary +
                " \u00a3 and has worked last month for " + numberOfHours +
                " hours.";
    }

    /**
     * This method returns employee monthly salary.
     * Monthly salary calculated by:
     * (Hourly wage * Number of hours worked) - Tax on monthly salary
     * @param taxRate Tax rate to be applied to employee wage calculation.
     * @return Employee monthly salary
     */

    public double monthlySalary(double taxRate) {
        return (hourlySalary * numberOfHours) - ((hourlySalary * numberOfHours) * (taxRate / 100)) ;
    }

    /**
     * This method returns increase in employee salary.
     * Increase in salary calculated by:
     * Hourly salary + Hourly wage extra (calculated from percentage increase on hourly wage)
     * @param percentage Percentage increase for employee wage.
     */

    public void increaseSalary(double percentage) {
        setHourlySalary(hourlySalary + ((hourlySalary * (percentage / 100))));
    }
}

