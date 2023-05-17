package chislmet;

public class AdamsNumberThree {
    public double[] solver(int n, double a, double b, double y0, double y1) {
        double h = (a - b) / n;
        double[] functions = new double[n + 1];
        functions[0] = y0;
        functions[1] = y1;
        double x = b;
        for (int i = 2; i < n + 1; i++) {
            functions[i] = (functions[i-1] + 8.0 * h * f(x + h, functions[i-1])/ 12.0 - h * f(x, functions[i-2])/12.0)/
                    (1.0-(5.0 * h)/(36.0 * Math.sqrt(x + 2 * h)));
            x += h;
        }
        return functions;
    }

    private double f(double x, double y) {
        double z = 3.0 * Math.sqrt(x);
        return y / z;
    }
}
