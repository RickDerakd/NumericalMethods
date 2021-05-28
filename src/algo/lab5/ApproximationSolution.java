package algo.lab5;

import algo.lab4.InterpolationData;

public class ApproximationSolution {

    double degree = 2;
    double left = -10;
    double right = 5;
    boolean flag = true;

    public void dataInput(){
        InterpolationData approx = new InterpolationData();
        approx.setDataX(3.0, 4.0, 5.0, 6.0, 7.0);
        approx.setDataFX(2.5, 1.1, -0.8, -1.9, -1.1);
        approx.printX();
        approx.printFX();
        System.out.println("____________________________________________________________________");
    }

    public void calcApproximation(){
        dataInput();
    }
}
