package algo.lab4;

import java.util.Scanner;

public class InterpolationSolution {

    boolean flag = true;
    double left = -2;
    double right = 5;
    InterpolationData data = new InterpolationData();

    public void dataInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Set standard data? [y/n]");
        String checkInput = sc.nextLine();

        if (checkInput.equals("n")) {
            System.out.println("Please enter new data, for X: ");
            data.setAllX();
            System.out.println("Please enter new data, for F(X): ");
            data.setAllFX();
        } else System.out.println(">>> Standard data selected");

        System.out.println("Set standard interval (-2;5)? [y/n]");
        checkInput = sc.nextLine();
        if (checkInput.equals("n")) {
            while (flag) {
                System.out.println("Please enter left border: ");
                String checkLeftInput = sc.nextLine();
                left = Double.parseDouble(checkLeftInput);
                System.out.println("Please enter right border: ");
                String checkRightInput = sc.nextLine();
                right = Double.parseDouble(checkRightInput);
                System.out.println("____________________________________________________________________");
                if (left == right){
                    System.out.println("ERROR CODE!");
                }else if (left > right){
                    System.out.println("ERROR CODE!");
                }else flag = false;
            }
        }else System.out.println(">>> Standard interval selected [-2;5]");
        System.out.println("____________________________________________________________________");
    }

    public void calcInterpolation(){
        dataInput();

        double temp, sum = 0;

        //algorithm
        while (right >= left) {
            temp = 1;
            for (int i = 0; i < right; i++) {
                for (int j = 0; j < right; j++) {
                    if (j != i) {
                        temp *= (left - data.getDataX().get(j)) / (data.getDataX().get(i) - data.getDataX().get(j));
                    }
                }
                sum = temp * data.getDataFX().get(i);
                temp = 1;
            }
            System.out.println(" The value at point [" + left + "] is : " + sum);
            left += 0.5;
        }
    }
}
