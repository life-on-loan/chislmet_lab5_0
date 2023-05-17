package chislmet;

public class Razgon {
    public double culcY1(int n, double a, double b, double y0) {
        double h = (a - b) / n;
        double x0 = b;
        double k1 = f(x0, y0);
        double k2 = f(x0 + h/2.0, y0 + h*k1/2.0);
        double k3 = f(x0 + h/2.0, y0 + h*k2/2.0);
        double k4 = f(x0 + h, y0 + h*k3);
        return y0 + h*(k1 +2.0*k2 +2.0*k3 +k4)/6.0;
    }

    private double f(double x, double y) {
        double z = 3.0 * Math.sqrt(x);
        return y / z;
    }
}
