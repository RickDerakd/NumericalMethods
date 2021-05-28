import algo.lab1.GaussSolution;
import algo.lab2.IterationSolution;
import algo.lab3.DichotomySolution;
import algo.lab4.InterpolationSolution;
import algo.lab5.ApproximationSolution;
import algo.lab6.FuncData;

import java.util.*;

public class Main {

    public static void main(String [] args){

        boolean flag = true;
        FuncData calcFunc = new FuncData();
        GaussSolution gauss = new GaussSolution();
        IterationSolution iter = new IterationSolution();
        DichotomySolution dicho = new DichotomySolution();
        InterpolationSolution inter = new InterpolationSolution();
        ApproximationSolution approx = new ApproximationSolution();

        Scanner sc = new Scanner(System.in);

        System.out.println("\tYasin");

        while(flag) {
            System.out.println("____________________________________________________________________");
            System.out.println("    Select operating mode: \n");
            System.out.println("[1] Gauss Calculation (3x4 matrix). ");
            System.out.println("[2] Iteration method. ");
            System.out.println("[3] Dichotomy method. ");
            System.out.println("[4] Interpolation method. ");
            System.out.println("[5] Approximation method. ");
            System.out.println("[6] Rectangle method. ");
            System.out.println("[7] Trapezoid method. ");
            System.out.println("[8] Simpson method. ");
            System.out.println("[0] Exit. ");

            String switch_on = sc.next();

            switch (switch_on) {
                case "0":{
                    System.out.println("____________________________________________________________________");
                    flag = false;
                    break;
                }
                case "1":{
                    System.out.println("____________________________________________________________________");
                    System.out.println("    Select operating mode:  \n");
                    System.out.println("[1] Variant 26 Calculation . ");
                    System.out.println("[2] Calculation with variable values. ");
                    System.out.println("[0] Previous menu. ");
                    String flag1 = sc.next();
                    switch (flag1) {
                        case "0":{
                            break;
                        }
                        case "1":{
                            gauss.calcGauss(true);
                            break;
                        }
                        case "2":{
                            gauss.calcGauss(false);
                            break;
                        }
                        default:{
                            System.out.println("ERROR CODE!");
                            break;
                        }
                    }
                    break;
                }
                case "2":{
                    System.out.println("____________________________________________________________________");
                    System.out.println("    Select operating mode: \n");
                    System.out.println("[1] Default Calculation. ");
                    System.out.println("[2] Calculation with variable values. ");
                    System.out.println("[0] Previous menu. ");
                    String flag1 = sc.next();
                    switch (flag1) {
                        case "0": {
                            break;
                        }
                        case "1": {
                            iter.calcIteration(true);
                            break;
                        }
                        case "2": {
                            iter.calcIteration(false);
                            break;
                        }
                        default: {
                            System.out.println("ERROR CODE!");
                            break;
                        }
                    }
                    break;
                }
                case "3":{
                    System.out.println("____________________________________________________________________");
                    dicho.calcDichotomy();
                    break;
                }
                case "4":{
                    System.out.println("____________________________________________________________________");
                    inter.calcInterpolation();
                    break;
                }
                case "5":{
                    System.out.println("____________________________________________________________________");
                    approx.calcApproximation();
                    break;
                }
                case "6":{
                    System.out.println("____________________________________________________________________");
                    System.out.println(" Rectangle calculation. ");
                    calcFunc.init( 1);
                    break;
                }
                case "7":{
                    System.out.println("____________________________________________________________________");
                    System.out.println(" Trapezoid calculation. ");
                    calcFunc.init( 2);
                    break;
                }
                case "8":{
                    System.out.println("____________________________________________________________________");
                    System.out.println(" Simpson calculation. ");
                    calcFunc.init( 3);
                    break;
                }
                default:{
                    System.out.println("ERROR CODE: Wrong number.");
                    break;
                }
            }
        }
    }
}
