import java.util.*;

public class Main {

    public static void main(String [] args){

        Boolean flag = true;
        Scanner sc = new Scanner(System.in);
        double [][]array;
        double [][]arrayDefault = { { 0.80, 1.61, 3.76,	1.75},
                                    { 2.19, 1.26, 0.94, 1.29 },
                                    { 0.93, 2.38, 4.02, -2.50 }};

        System.out.println("\t Program YasinGauss");

        while(flag) {
            // String switch_on = sc.nextLine();
            // switch_on = switch_on.substring(0,1);

            System.out.println("____________________________________________________________________");
            System.out.println("    Select operating mode: ");
            System.out.println("[1] Default Calculation. ");
            System.out.println("[2] Calculation with variable values. ");
            System.out.println("[0] Exit. ");

            String switch_on = sc.next();
            Gauss algo = new Gauss();

            switch (switch_on) {
                case "0":{
                    System.out.println("____________________________________________________________________");
                    flag = false;
                    break;
                }
                case "1":{
                    System.out.println("____________________________________________________________________");
                    System.out.println(" >>> Creating Matrix for variant 26: ");
                    System.out.println("");
                    algo.printMatrix(arrayDefault, 3, 4);
                    algo.determinant(arrayDefault);

                    double []tempLine = new double[4];

                    double [][] tempArray = new double[3][4];
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 4; j++){
                            tempArray[i][j] = arrayDefault[i][j];
                        }
                    }

                    System.out.println(" Divide the first line by a[0][0]:");
                    double tempValue = tempArray[0][0];
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println(" From the 2 line subtract the 1 line multiplied by [1][0]");
                    tempValue = tempArray[1][0];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[0][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] -= tempLine[j];
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println(" From the 3 line subtract the 1 line multiplied by [2][0]");

                    tempValue = tempArray[2][0];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[0][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] -= tempLine[j];
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("Divide the 2 line by [1][1]");

                    tempValue = tempArray[1][1];
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 1 line subtract the 2, multiplied by [0][1]");

                    tempValue = tempArray[0][1];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[1][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 3 line subtract the 2, multiplied by [1][2]");

                    tempValue = tempArray[2][1];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[1][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);
/////
                    System.out.println("Divide the 3 line by [2][2]");

                    tempValue = tempArray[2][2];
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 1 line subtract the 3, multiplied by [0][2]");

                    tempValue = tempArray[0][2];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[2][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 2 line subtract the 3, multiplied by [1][2]");

                    tempValue = tempArray[1][2];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[2][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);
                    System.out.print("\n");

                    algo.checkResult(arrayDefault, tempArray);


                    break;
                }
                case "2":{
                    System.out.println("____________________________________________________________________");
                    System.out.println("  ");

                    array = algo.initMatrix(3, 4);
                    algo.printMatrix(array, 3, 4);

                    double []tempLine = new double[4];

                    double [][] tempArray = new double[3][4];
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 4; j++){
                            tempArray[i][j] = array[i][j];
                        }
                    }

                    System.out.println(" Divide the first line by a[0][0]:");
                    double tempValue = tempArray[0][0];
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println(" From the 2 line subtract the 1 line multiplied by [1][0]");
                    tempValue = tempArray[1][0];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[0][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] -= tempLine[j];
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println(" From the 3 line subtract the 1 line multiplied by [2][0]");

                    tempValue = tempArray[2][0];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[0][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] -= tempLine[j];
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("Divide the 2 line by [1][1]");

                    tempValue = tempArray[1][1];
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 1 line subtract the 2, multiplied by [0][1]");

                    tempValue = tempArray[0][1];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[1][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 3 line subtract the 2, multiplied by [1][2]");

                    tempValue = tempArray[2][1];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[1][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);
/////
                    System.out.println("Divide the 3 line by [2][2]");

                    tempValue = tempArray[2][2];
                    for (int j = 0; j < 4; j++){
                        tempArray[2][j] /= tempValue;
                    }
                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 1 line subtract the 3, multiplied by [0][2]");

                    tempValue = tempArray[0][2];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[2][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[0][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);

                    System.out.println("From the 2 line subtract the 3, multiplied by [1][2]");

                    tempValue = tempArray[1][2];
                    for (int j = 0; j < 4; j++){
                        tempLine[j] = tempArray[2][j] * tempValue;
                    }
                    for (int j = 0; j < 4; j++){
                        tempArray[1][j] -= tempLine[j];
                    }

                    algo.printMatrix(tempArray,3,4);

                    System.out.print("\n");

                    algo.checkResult(array, tempArray);

                    break;
                }
                default: {
                    System.out.println("Error: Wrong number.");
                    break;
                }
            }
        }
    }
}
