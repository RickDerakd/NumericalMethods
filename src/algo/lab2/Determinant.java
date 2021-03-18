package algo.lab2;

public class Determinant {

    public static double[][] data;

    public static double[][] generateSubArray(double[][] matrix, int size, int j1){
        data = new double[size - 1][];
        for (int k = 0; k < (size - 1); k++)
            data[k] = new double[size - 1];

        for (int i = 1; i < size; i++){
            int j2 = 0;
            for (int j = 0; j < size; j++){
                if(j == j1)
                    continue;
                data[i - 1][j2] = matrix[i][j];
                j2++;
            }
        }
        return data;
    }

    //Calculate determinant recursively
    public static double determinant(double[][] matrix, int size){
        double result;

        // for matrix 1x1
        if (size == 1) result = matrix[0][0];
        // for matrix 2x2
        else if (size == 2) result = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        // for matrix NxN
        else{
            result = 0;
            for (int j1 = 0; j1 < size; j1++){
                data = generateSubArray (matrix, size, j1);
                result += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * determinant(data, size - 1);
            }
        }
        return result;
    }
}

