package algo.lab6;

public class SimpsonSolution {
    public static void calcSimpson(double n, double m, int k){
        double temp = FuncData.equation(n) + FuncData.equation(m);
        double h = (m - n) / k;
        int l;
        for(int i = 1; i <= k - 1; i++){
            l = 2 + 2 * (i % 2);
            temp += l * (FuncData.equation(n + i * h));
        }
        temp += h / 3;
        System.out.println(" >>> Result of Simpson method: " + temp);
    }
}
