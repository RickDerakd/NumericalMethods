package algo.lab5;

import java.util.Scanner;

public class ApproximationSolution {

    double[] xi = {-2, -1, 0, 1, 2};
    double[] yi = {-4.8, 0, 3.2, 4, 2.8};
    double[] xi2 = new double[5];
    double[] xi3 = new double[5];
    double[] xi4 = new double[5];
    double[] xiyi = new double[5];
    double[] xi2yi = new double[5];

    Scanner sc = new Scanner(System.in);
    double a = 1.92;
    double b = 1.04;
    double c = 0;

    public void dataInput(){
        boolean flag = true;
        System.out.println("Set standard data? [y/n]");
        String checkInput = sc.nextLine();

        if (checkInput.equals("n")) {
            System.out.println("Please enter new data, for X: ");
            input(xi);
            System.out.println("Please enter new data, for F(X): ");
            input(yi);
        } else System.out.println(">>> Standard data selected");
        System.out.println("______________________________________________________________________________");
    }

    public void calcApproximation(){

        double sumXi = 0;
        double sumYi = 0;
        double sumXi2 = 0;
        double sumYi2 = 0;
        double sumXi3 = 0;
        double sumXi4 = 0;
        double sumXi2Yi = 0;

        dataInput();

        for (int i = 0; i < xi.length; i++){
            sumXi += xi[i];
            sumYi += yi[i];
            xi2[i] = Math.pow(xi[i], 2);
            xiyi[i] = xi[i] * yi[i];
            xi3[i] = Math.pow(xi[i], 3);
            xi4[i] = Math.pow(xi[i], 4);
            xi2yi[i] = xi2[i] * yi[i];
            sumXi3 += xi3[i];
            sumXi4 += xi4[i];
            sumXi2Yi += xi2yi[i];
        }

        printArr(xi, sumXi,"хi", true);
        printArr(yi, sumYi,"yi", true);
        System.out.print("\n");

        printArr(xi2, sumXi2,"хi2", true);
        printArr(xiyi, sumYi2,"xi yi", true);
        System.out.print("\n");

        System.out.println("______________________________________________________________________________");
        System.out.println("Polynomial of the first degree: Р1(х): y = " + a + "*x + " + b);

        rmsError(false);

        printArr(xi, sumXi,"хi", true);
        printArr(yi, sumYi,"yi", true);
        System.out.print("\n");

        printArr(xi2, sumXi2,"хi2", true);
        printArr(xiyi, sumYi2,"xi yi", true);
        System.out.print("\n");

        printArr(xi3, sumXi3,"хi3", true);
        printArr(xi4, sumXi4,"xi4", true);
        printArr(xi2yi, sumXi2Yi,"xi2 yi", true);
        System.out.print("\n");

        a = -1.02;
        b = 1.92;
        c = 3.09;

        System.out.println("______________________________________________________________________________");
        System.out.println("Р2(х): y = " + a + "x2" + b + "х" + c);

        rmsError(true);
    }

    public void rmsError(boolean cube){
        double[] arr3 = new double[5];
        double[] arr4 = new double[5];
        double sum = 0;

        System.out.println("______________________________________________________________________________");
        System.out.println(" Find the root-mean-square error: ");

        System.out.print("\n");
        printArr(xi, sum,"хi", false);
        System.out.print("\n");
        printArr(yi, sum,"yi", false);
        System.out.print("\n");

        if(!cube) {
            for (int i = 0; i < xi.length; i++) {
                arr3[i] = a * xi[i] + b;
                arr4[i] = Math.pow((arr3[i] - yi[i]), 2);
                sum += arr4[i];
            }
            printArr(arr3, sum,"Р1(х)", false);
            System.out.print("\n");
            printArr(arr4, sum,"(Р1(х) - у)^2", true);
        }else{
            for (int i = 0; i < xi.length; i++) {
                arr3[i] = a * Math.pow(xi[i], 2) + b * xi[i] + c;
                arr4[i] = Math.pow((arr3[i] - yi[i]), 2);
                sum += arr4[i];
            }
            printArr(arr3, sum,"Р2(х)", false);
            System.out.print("\n");
            printArr(arr4, sum,"(Р2(х) - у)^2", true);
        }
    }

    public void printArr(double[] arr, double sum, String about, boolean sumFlag){
        System.out.print(about + ": ");
        System.out.print("{ ");
        for (double v : arr) {
            System.out.format(" %.4f; ", v);
        }
        System.out.print(" } ");
        if (sumFlag) {
            System.out.format("  Sum: %.4f \n", sum);
        }
    }

    public void input(double[] arr){
        double input;
        for(int i = 0; i < xi.length; i++){
            input = sc.nextDouble();
            arr[i] = input;
        }
    }
}
