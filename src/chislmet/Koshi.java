package chislmet;

public class Koshi {
    public double[] solver(int n, double a, double b, double y0) {
        double h = (a - b) / n;
        double[] functions = new double[n + 1];
        functions[0] = y0;
        double x = b;
        for (int i = 1; i < n + 1; i++) {
            double xi = x + i*h + h/2;
            double yi = functions[i-1] + h/2 * f(x + i*h, functions[i-1]);
            functions[i] = functions[i-1] + f(xi, yi) * h;
        }
        return functions;
    }

    private double f(double x, double y) {
        double z = 3.0 * Math.sqrt(x);
        return y / z;
    }
}
