package algo.lab6;

public class RectangleSolution {
    public static void calcRectangle(double n, double m, int k){
        double temp = 0;
        double h = (m - n) / k;
        for(int i = 1; i <= k; i++){
            temp += FuncData.equation(n + i * h);
        }
        double res = h * temp;
        System.out.println(" >>> Result of Rectangle method: " + res);
    }
}
