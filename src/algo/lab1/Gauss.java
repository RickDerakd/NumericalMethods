package algo.lab1;

import java.util.Scanner;

public class Gauss {

    public static int str = 4;
    public static int clm = 4;

    //method of data input a matrix
    public static double[][] initMatrix(){
        Scanner sc = new Scanner(System.in);

        double [][] array = new double[str][clm];

        for(int i = 0; i < str; i++){
            for(int j = 0; j < clm; j++){
                System.out.format(" a[%d][%d]: ", i, j);
                array[i][j] = sc.nextDouble();
            }
        }
        System.out.println("____________________________________________________________________");

        return array;
    }

    public static void printMatrix(double [][]array){
        System.out.println("  Matrix: ");
        for(int i = 0; i < str; i++) {
            System.out.print("\n");
            for (int j = 0; j < clm; j++) {
                System.out.print("\t");
                //System.out.format(" a[%d][%d]: ", i, j);
                System.out.format("%.2f",array[i][j]);
                System.out.print("\t");
            }
        }
        System.out.print("\n");
        System.out.println("____________________________________________________________________");
    }

    public static void checkResult(double [][] matrixDflt, double [][] matrixRslt){
        System.out.println(" Checking results: ");

        System.out.println(" Input Matrix: ");

        for(int i = 0; i < 3; i++) {
            System.out.print("\n");
            for (int j = 0; j < 4; j++) {
                System.out.format("%.2f", matrixDflt[i][j]);
                System.out.print("\t");
            }
        }
        System.out.print("\n");

        System.out.println("____________________________________________________________________");
        System.out.println("Results: ");

        double sum = 0;

        double value;

        System.out.print("\n");

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("\t");
                value = matrixRslt[j][3] * matrixDflt[i][j];
                sum += value;
            }
            System.out.format("%.2f", sum);
            System.out.print("\t");
            sum = 0;
        }
        System.out.print("\n");
        System.out.println("Task is done");
    }

    //determinant method working with a 3-by-3 matrix
    public static void determinant(double[][] array){
        double determinant;
        double x,y,z;
        double[][] matrix = new double[3][3];

        for(int i = 0; i < 3; i++){
            System.arraycopy(array[i], 0, matrix[i], 0, 3);
        }

        x = (matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]));
        y = (matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]));
        z = (matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]));
        determinant = x - y + z;

        System.out.print(" Determinant of the Matrix: ");
        System.out.format("%.2f", determinant);
        System.out.print("\n");
        System.out.println("____________________________________________________________________");
    }
}
