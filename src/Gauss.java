import java.util.Scanner;

public class Gauss {

    public double[][] initMatrix(int clm, int str){
        Scanner sc = new Scanner(System.in);

        double [][] array = new double[clm][str];

        System.out.println("WARNING: if your Matrix (with answers) has a proportion\n" +
                             "3x4, program will fail.\n");

        for(int i = 0; i < clm; i++){
            for(int j = 0; j < str; j++){
                System.out.format(" a[%d][%d]: ", i, j);
                array[i][j] = sc.nextDouble();
            }
        }
        System.out.println("____________________________________________________________________");
        return array;
    }

    public void printMatrix(double [][]array, int clm, int str){
        System.out.println("  Array: ");
        for(int i = 0; i < clm; i++) {
            System.out.print("\n");
            for (int j = 0; j < str; j++) {
                System.out.format(" a[%d][%d]: ", i, j);
                System.out.format("%.2f",array[i][j]);
                System.out.print("\t");
            }
        }
        System.out.print("\n");
        System.out.println("____________________________________________________________________");
    }

    public void checkResult(double [][] matrixDflt, double [][] matrixRslt){
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
        double [] Result = new double[3];
        double [] Input = new double[3];
        double value;

        System.out.print("\n");

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Input[i] = matrixDflt[i][3];
                System.out.print("\t");
                value = matrixRslt[j][3] * matrixDflt[i][j];
                sum += value;
                Result[i] = sum;
            }
            System.out.format("%.2f", sum);
            System.out.print("\t");
            sum = 0;
        }
        System.out.print("\n");
        System.out.println("Task is done");
    }

    public void determinant(double [][]array){
        double determinant;
        double x,y,z;
        double[][] matrix = new double[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                matrix[i][j] = array[i][j];
            }
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
