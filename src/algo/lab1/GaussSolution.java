package algo.lab1;

public class GaussSolution {

    double[][] arrayDefault = {
            {0.80, 1.61, 3.76, 1.75},
            {2.19, 1.26, 0.94, 1.29},
            {0.93, 2.38, 4.02, -2.50}};


    public void calcGauss(boolean modeDefault) {

        double[][] array;

        System.out.println("\tYasinGauss");

        System.out.println("____________________________________________________________________");
        Gauss.str = 3;
        Gauss.clm = 4;

        array = Gauss.selectOptionMode(modeDefault, arrayDefault);

        double[] tempLine = new double[4];

        double[][] tempArray = new double[3][4];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(array[i], 0, tempArray[i], 0, 4);
        }

        System.out.println(" Divide the first line by a[0][0]:");
        double tempValue = tempArray[0][0];
        for (int j = 0; j < 4; j++) {
            tempArray[0][j] /= tempValue;
        }
        Gauss.printMatrix(tempArray);

        System.out.println(" From the 2 line subtract the 1 line multiplied by [1][0]");
        tempValue = tempArray[1][0];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[0][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[1][j] -= tempLine[j];
        }
        Gauss.printMatrix(tempArray);

        System.out.println(" From the 3 line subtract the 1 line multiplied by [2][0]");

        tempValue = tempArray[2][0];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[0][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[2][j] -= tempLine[j];
        }
        Gauss.printMatrix(tempArray);

        System.out.println("Divide the 2 line by [1][1]");

        tempValue = tempArray[1][1];
        for (int j = 0; j < 4; j++) {
            tempArray[1][j] /= tempValue;
        }
        Gauss.printMatrix(tempArray);

        System.out.println("From the 1 line subtract the 2, multiplied by [0][1]");

        tempValue = tempArray[0][1];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[1][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[0][j] -= tempLine[j];
        }

        Gauss.printMatrix(tempArray);

        System.out.println("From the 3 line subtract the 2, multiplied by [1][2]");

        tempValue = tempArray[2][1];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[1][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[2][j] -= tempLine[j];
        }

        Gauss.printMatrix(tempArray);

        System.out.println("Divide the 3 line by [2][2]");
        tempValue = tempArray[2][2];
        for (int j = 0; j < 4; j++) {
            tempArray[2][j] /= tempValue;
        }
        Gauss.printMatrix(tempArray);

        System.out.println("From the 1 line subtract the 3, multiplied by [0][2]");
        tempValue = tempArray[0][2];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[2][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[0][j] -= tempLine[j];
        }
        Gauss.printMatrix(tempArray);

        System.out.println("From the 2 line subtract the 3, multiplied by [1][2]");
        tempValue = tempArray[1][2];
        for (int j = 0; j < 4; j++) {
            tempLine[j] = tempArray[2][j] * tempValue;
        }
        for (int j = 0; j < 4; j++) {
            tempArray[1][j] -= tempLine[j];
        }

        Gauss.printMatrix(tempArray);
        System.out.print("\n");

        Gauss.checkResult(array, tempArray);
    }
}
