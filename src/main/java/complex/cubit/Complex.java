package complex.cubit;

public final class Complex {

    private final double r;
    private final double i;

    public Complex(double real, double imag) {
        this.r = real;
        this.i = imag;
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", r, i);
    }

    /**
     * OPERACIONES COMPLEJAS
     */

    public Complex add(Complex other) {
        return new Complex(this.r + other.r, this.i + other.i);
    }
    public Complex subtract(Complex other) {
        return new Complex(this.r - other.r, this.i - other.i);
    }

    public Complex multiply(Complex other) {
        final double realPart = (this.r * other.r) - (this.i * other.i);
        final double imagPart = (this.r * other.i) + (this.i * other.r);
        return new Complex(realPart, imagPart);
    }

    public Complex scale(double scalar) {
        return new Complex(this.r * scalar, this.i * scalar);
    }

    public double magnitudeSquared() {
        return (this.r * this.r) + (this.i * this.i);
    }

}
