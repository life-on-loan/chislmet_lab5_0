package chislmet;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        double a = 0;
        double b = 1;
        double y0 = 2;

        ExactSolution exactSolution = new ExactSolution();
        double[] resultExact1 = exactSolution.solver(n1, a, b, y0);

        EulerExplicit eulerExplicit = new EulerExplicit();
        double[] resultEuler1 = eulerExplicit.solver(n1, a, b ,y0);
        double[] resultEuler2 = eulerExplicit.solver(n2, a, b ,y0);
        double[] resultEuler3 = eulerExplicit.solver(n3, a, b ,y0);

        Koshi koshi = new Koshi();
        double[] resultKoshi1 = koshi.solver(n1, a, b ,y0);
        double[] resultKoshi2 = koshi.solver(n2, a, b ,y0);
        double[] resultKoshi3 = koshi.solver(n3, a, b ,y0);

        Razgon razgon = new Razgon();
        double y1n1 = razgon.culcY1(n1, a, b, y0);
        double y1n2 = razgon.culcY1(n2, a, b, y0);
        double y1n3 = razgon.culcY1(n3, a, b, y0);
        AdamsNumberThree adamsNumberThree = new AdamsNumberThree();
        double[] resultAdams1 = adamsNumberThree.solver(n1, a, b, y0, y1n1);
        double[] resultAdams2 = adamsNumberThree.solver(n2, a, b, y0, y1n2);
        double[] resultAdams3 = adamsNumberThree.solver(n3, a, b, y0, y1n3);

        double h1 = (b-a)/n1;
        double h2 = (b-a)/n2;
        double h3 = (b-a)/n3;

        System.out.println("_________________Явный метод Эйлера_________________");
        System.out.println("Количество точек разбиения: 10");
        for (int i = n1; i > -1 ; i--) {
            System.out.println((b - i*h1) + ";" + resultEuler1[i]);
        }
        System.out.println("Количество точек разбиения: 20");
        for (int i = n2; i > -1 ; i--) {
            System.out.println((b - i*h2) + ";" + resultEuler2[i]);
        }
        System.out.println("Количество точек разбиения: 30");
        for (int i = n3; i > -1 ; i--) {
            System.out.println((b - i*h3) + ";" + resultEuler3[i]);
        }

        System.out.println("_________________Метод Коши_________________");
        System.out.println("Количество точек разбиения: 10");
        for (int i = n1; i > -1 ; i--) {
            System.out.println((b - i*h1) + ";" + resultKoshi1[i]);
        }
        System.out.println("Количество точек разбиения: 20");
        for (int i = n2; i > -1 ; i--) {
            System.out.println((b - i*h2) + ";" + resultKoshi2[i]);
        }
        System.out.println("Количество точек разбиения: 30");
        for (int i = n3; i > -1 ; i--) {
            System.out.println((b - i*h3) + ";" + resultKoshi3[i]);
        }

        NumberFormat formatter = new DecimalFormat("0.00000000000");

        System.out.println("_________________Метод Адамса-Мултона_________________");
        System.out.println("Количество точек разбиения: 10");
        for (int i = n1; i > -1 ; i--) {
            System.out.println((b - i*h1) + ";" + formatter.format(resultAdams1[i]));
        }
        System.out.println("Количество точек разбиения: 20");
        for (int i = n2; i > -1 ; i--) {
            System.out.println((b - i*h2) + ";" + formatter.format(resultAdams2[i]));
        }
        System.out.println("Количество точек разбиения: 30");
        for (int i = n3; i > -1 ; i--) {
            System.out.println((b - i*h3) + ";" + formatter.format(resultAdams3[i]));
        }
    }
}
