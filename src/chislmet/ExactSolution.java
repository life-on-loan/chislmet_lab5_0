package chislmet;

public class ExactSolution {
    public double[] solver(int n, double a, double b, double y0) {
        double h = (b - a) / n;
        double[] results = new double[n + 1];
        double x = b;
        for (int i = 0; i < n + 1; i++) {
            results[i] = 2.0 * Math.pow(Math.E, ((2.0/3.0) * Math.sqrt(x - i * h) - 2.0/3.0));
        }
        return results;
    }
}
