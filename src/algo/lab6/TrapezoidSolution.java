package algo.lab6;

public class TrapezoidSolution {
    public static void calcTrapezoid(double n, double m, int k){
        double temp = FuncData.equation(n) + FuncData.equation(m);
        double h = (m - n) / k;
        for(int i = 1; i <= k - 1; i++){
            temp += 2 * (FuncData.equation(n + i * h));
        }
        temp += h / 2;
        System.out.println(" >>> Result of Trapezoid method: " + temp);
    }
}
