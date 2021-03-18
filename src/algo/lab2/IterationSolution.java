package algo.lab2;

import algo.lab1.Gauss;

import java.util.Scanner;

public class IterationSolution {

    double[][] arrayDefault = {
            {5, 1, -1, 1},
            {1, -4, 1, -1},
            {-1, 1, 4, 1},
            {1, 2, 1, -5}};

    double[] approach;
    double[] bufer;
    double[] iterRes = new double[4];
    double[] iterCheck = new double[4];


    public void calcIteration(boolean mode) {

        Scanner sc = new Scanner(System.in);
        boolean flagCheck = true;
        double sum = 0;


        System.out.println("\tYasinIter");
        System.out.println("____________________________________________________________________");

        if (!mode) arrayDefault = Gauss.initMatrix();

        Gauss.printMatrix(arrayDefault);

        double detCheck = Determinant.determinant(arrayDefault, 4);

        if(detCheck <= 0){
            System.out.println("Error code: Determinant check failed");
            return;
        }

        System.out.print("Determinant: ");
        System.out.format("%.4f", detCheck);
        System.out.print("\n");

        System.out.println("____________________________________________________________________");
        System.out.print("Choose your variant: ");
        double var = sc.nextDouble();

        bufer = new double[]{3 * var,
                             var - 6,
                             15 - var,
                             var + 2};

        approach = new double[]{0.7 * var,
                                1,
                                2,
                                0.5};


        //Condition of the prevalence of the method
        System.out.println("____________________________________________________________________\n");
        for (int i = 0, k = 0; i < arrayDefault.length; k++, i++) {
            for (int j = 0; j < arrayDefault[i].length; j++) {
                if (i != j) {
                    sum += Math.abs(arrayDefault[i][j]);
                }
            }
            if (sum > Math.abs(arrayDefault[i][k])) {
                flagCheck = false;
                System.out.format("Sum absolute of not diagonal elements \n >> row [%d]: ", i);
                System.out.print(sum + "> then " + Math.abs(arrayDefault[i][k]) + "\n");
                System.out.println(">> Prevalence status: FALSE");
            } else {
                System.out.format("Sum absolute of not diagonal elements \n >> row [%d]: ", i);
                System.out.print(sum + " > " + Math.abs(arrayDefault[i][k]) + "\n");
                System.out.println(" >> Prevalence status: TRUE");
            }
            sum = 0;
        }

        double max;

        if (flagCheck) {
            for (int p = 1; p <= 9; p++) {
                for (int i = 0, k = 0; i < arrayDefault.length; k++, i++) {
                    for (int j = 0; j < arrayDefault[i].length; j++) {
                        if (i != j) {
                            sum += approach[j] * arrayDefault[i][j];
                        }
                    }
                    iterRes[i] = (bufer[i] - sum) / arrayDefault[i][k];
                    sum = 0;
                }

                System.arraycopy(iterRes, 0, approach, 0, approach.length);

                System.out.println("____________________________________________________________________");
                System.out.println("____________________________________________________________________\n");
                for (int i = 0; i < iterRes.length; i++) {
                    System.out.printf(" Output of step[%d], iteration [%d]: %.4f \n", i + 1, p, iterRes[i]);
                }

                //Check the accuracy of the calculations based on the absolute difference between the last two results.
                if (p >= 2) {
                    System.out.println("____________________________________________________________________");
                    System.out.println("\tCheck the accuracy of the calculations \n" +
                            "\tbased on the absolute difference \n" +
                            "\tbetween the last two results. \n");

                    max = Math.abs(iterRes[0] - iterCheck[0]);
                    double diff;

                    for (int i = 0; i < iterRes.length; i++) {
                        diff = Math.abs(iterRes[i] - iterCheck[i]);
                        System.out.printf(">> %.4f - %.4f = %.4f\n", iterRes[i], iterCheck[i], diff);
                        if (diff > max) max = diff;
                    }

                    System.out.println("____________________________________________________________________");
                    System.out.printf("\tThe maximum absolute difference between\n" +
                            "\titeration[%d] and iteration[%d] \n" +
                            "\t >> %.4f\n", p - 1, p, max);
                }
                System.arraycopy(iterRes, 0, iterCheck, 0, iterRes.length);
            }

            System.out.println("____________________________________________________________________");
            System.out.println(" Output: \n");
            for (int i = 0; i < iterRes.length; i++) {
                System.out.printf("\tX[%d] = %.4f. \n ", i + 1, iterRes[i]);
            }
            checkOutput();
            System.out.println("\nRESULT: Convergence condition is satisfied");
        }else {
            System.out.println("RESULT: Convergence condition is not satisfied");
        }
    }

    public void checkOutput(){
        double result = 0;
        for (int i = 0; i < arrayDefault.length; i++) {

            System.out.printf("\nLine[%d]  >> ", i + 1);
            for (int j = 0; j < arrayDefault[i].length; j++) {
                result = result + arrayDefault[i][j] * iterRes[j];
                if ((arrayDefault[i].length - j) == 1) {
                    System.out.printf("%.0f * %.4f", arrayDefault[i][j], approach[j]);
                } else System.out.printf("%.0f * %.4f + ", arrayDefault[i][j], approach[j]);
            }
            System.out.printf(" = %.0f. \n >> True statement: %.0f \n", result, bufer[i]);
            System.out.printf(" >>  Our statement: %.0f \n", result);
            result = 0;
        }
    }
}
