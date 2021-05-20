package algo.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InterpolationData {

    private ArrayList<Double> dataX = new ArrayList<>(Arrays.asList(-2.0, -1.0, 1.2, 3.5, 5.0));
    private ArrayList<Double> dataFX = new ArrayList<>(Arrays.asList(-4.0, 0.0, 3.8, 2.0, 7.0));

    Scanner sc = new Scanner(System.in);

    public void printFX(){
        System.out.println("F(X) = " + dataFX);
    }

    public void printX(){
        System.out.println("X = " + dataX);
    }

    public ArrayList<Double> getDataX() {
        return dataX;
    }

    public void setDataX(ArrayList<Double> dataX) {
        this.dataX = dataX;
    }

    public ArrayList<Double> getDataFX() {
        return dataFX;
    }

    public void setDataFX(ArrayList<Double> dataFX) {
        this.dataFX = dataFX;
    }

    public void setAllX(){
        double input;
        dataX.clear();
        for(int i = 0; i < 5; i++){
            input = sc.nextDouble();
            dataFX.add(input);
        }
    }

    public void setAllFX(){
        double input;
        dataFX.clear();
        for(int i = 0; i < 5; i++){
            input = sc.nextDouble();
            dataFX.add(input);
        }
    }
}
