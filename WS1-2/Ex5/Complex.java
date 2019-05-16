/**
 * Complex is a class for the addition and multiplication of complex numbers
 * from pairs of real numbers, given in a so-called real part and a so called
 * imaginary part.
 *
 * @author Adam Robinson
 * @version 2017-10-13
 */

public class Complex {

    //Field Variables
    private double real;       // a
    private double imaginary;  // b

    /**
     * This constructor defines a complex number from two parts
     * a real part and an imaginary part. Both of type double.
     *
     * @param real Real half of complex number.
     * @param imaginary Imaginary half of complex number.
     */

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /* Accessor methods to get the real and imaginary parts of complex numbers */

    /**
     * @return Real half of complex number.
     */

    public double getRealPart() {
        return real;
    }

    /**
     * @return Imaginary half of complex number.
     */

    public double getImaginaryPart() {
        return imaginary;
    }

    /**
     * This method calculates the addition of two complex numbers from pairs of of real and imaginary parts.
     * @param summand Object of type Complex
     * @return answerAdd stores answerAdd.real and answerAdd.imaginary back within answerAdd object, which in turn
     * sets the field variables real and imaginary.
     */

    public Complex add(Complex summand) {

        // new object to store complex number addition real and imaginary parts
        Complex answerAdd = new Complex(real, imaginary);

        // Real number addition = (a1 + a2)
        answerAdd.real = real + summand.real;

        // Imaginary number addition = (b1 + b2)
        answerAdd.imaginary = imaginary + summand.imaginary;

        return answerAdd;
    }

    /**
     * This method calculates the multiplication of two complex numbers from pairs of of real and imaginary parts.
     * @param factor Object of type Complex
     * @return answerMultiply stores answerMultiply.real and answerMultiply.imaginary back within answerMultiply object, which in turn
     * sets the field variables real and imaginary.
     */

    public Complex multiply(Complex factor) {

        // new object to store complex number multiplication real and imaginary parts
        Complex answerMultiply = new Complex(real, imaginary);

        // Real number multiplication = (a1 * a2 - b1 * b2)
        answerMultiply.real = (real * factor.real - imaginary * factor.imaginary);

        // Imaginary number multiplication = (a1 * b2 + a2 * b1)
        answerMultiply.imaginary = (real * factor.imaginary + factor.real * imaginary);

        return answerMultiply;
    }

    /**
     * @return The print format of the the sum of two complex numbers
     * in the real half and the imaginary half.
     *
     * [real] + [imaginary]i
     */

    public String toString() {
        return real + " + " + imaginary + "i";
    }
}