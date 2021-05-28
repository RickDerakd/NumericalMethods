package algo.lab6;

import java.util.Scanner;

public class FuncData {

    double low = 0;
    double height = 1.2;
    int segment = 10;

    public void init(int methodSelect){
        dataInput();
        switch (methodSelect){
            case 1:{
                RectangleSolution.calcRectangle(low, height, segment);
                break;
            }
            case 2:{
                TrapezoidSolution.calcTrapezoid(low, height, segment);
                break;
            }
            case 3:{
                SimpsonSolution.calcSimpson(low, height, segment);
                break;
            }
        }
    }

    public void dataInput(){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("____________________________________________________________________");
        System.out.println("Set a standard number of segments (10) [y/n]");
        String checkInput = sc.nextLine();

        if (checkInput.equals("n")) {
            System.out.println(" Enter the standard number of segments: ");
            checkInput = sc.nextLine();
            segment = Integer.parseInt(checkInput);
        } else System.out.println(">>> Segments = 10");


        System.out.println("Standard range selected (0; 1,2)? [y/n]");
        checkInput = sc.nextLine();
        if (checkInput.equals("n")) {
            while (flag) {
                System.out.println("Please enter left bord: ");
                String checkLeftInput = sc.nextLine();
                low = Double.parseDouble(checkLeftInput);
                System.out.println("Please enter right border: ");
                String checkRightInput = sc.nextLine();
                height = Double.parseDouble(checkRightInput);
                System.out.println("____________________________________________________________________");
                if (low == height){
                    System.out.println("ERROR CODE!");
                }else if (low > height){
                    System.out.println("ERROR CODE!");
                }else flag = false;
            }
        }else System.out.println(">>> Standard range selected [0;10]");
        System.out.println("____________________________________________________________________");
    }

    public static double equation(double x){
        //26 variant
        return (((x * x) - 1.3) / (1.2 * x * x * x) + 1);
    }
}
