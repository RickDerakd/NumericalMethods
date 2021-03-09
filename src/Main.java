import algo.lab1.GaussSolution;

import java.util.*;

public class Main {

    public static void main(String [] args){

        boolean flag = true;
        String pointerG;
        GaussSolution gauss = new GaussSolution();
        Scanner sc = new Scanner(System.in);

        System.out.println("\tYasinGauss");

        while(flag) {
            System.out.println("____________________________________________________________________");
            System.out.println("    Select operating mode: ");
            System.out.println("[1] Gauss Calculation (3x4 matrix). ");
            System.out.println("[2] Iteration method. ");
            System.out.println("[3] [no actions yet] ");
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
                    System.out.println("    Select operating mode: ");
                    System.out.println("[1] Variant 26 Calculation . ");
                    System.out.println("[2] Calculation with variable values. ");
                    System.out.println("[0] Previous menu. ");
                    pointerG = sc.next();
                    switch (pointerG){
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
                            System.out.println("Error code!");
                            break;
                        }
                    }
                    break;
                }
                case "2":{

                }
                case "3":{

                }
                case "4":{

                }
                default:{
                    System.out.println("Error: Wrong number.");
                    break;
                }
            }
        }
    }
}
