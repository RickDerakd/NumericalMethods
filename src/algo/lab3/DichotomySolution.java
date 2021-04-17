package algo.lab3;

import java.util.*;

public class DichotomySolution {

    public Map<Double, Double> rootIsoInterMap;
    public String[] answer;
    double epsilon = 0.0001; // accuracy
    double left = -10;
    double right = 10;

    public void calcDichotomy() {

        double borderLeft;
        double borderRight;
        double x;
        double fLMax; // leftMax
        double fX;
        double multiFxFL;
        boolean flag = true;

        rootIsoInterMap = new LinkedHashMap<>();
        List<Double> listOfFxOnEachIter = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Set standard accuracy (0.0001)? [y/n]");
        String checkInput = sc.nextLine();

        if (checkInput.equals("n")) {
            System.out.println("Please enter accuracy: ");
            checkInput = sc.nextLine();
            epsilon = Double.parseDouble(checkInput);
        } else System.out.println("Standard epsilon selected 0.0001");

        System.out.println("Set standard interval (-10;10)? [y/n]");
        checkInput = sc.nextLine();
        if (checkInput.equals("n")) {
            while (flag) {
            System.out.println("Please enter left border: ");
            String checkLeftInput = sc.nextLine();
            left = Double.parseDouble(checkLeftInput);
            System.out.println("Please enter right border: ");
            String checkRightInput = sc.nextLine();
            right = Double.parseDouble(checkRightInput);
            System.out.println("____________________________________________________________________");
            if (!(left == right & left > right)) flag = false;
            }
        }else System.out.println("Standard interval selected [-10;10]");

        DichotomyData data = new DichotomyData(left, right);
        DichotomyUtil util = new DichotomyUtil(data, rootIsoInterMap, listOfFxOnEachIter);

        System.out.println("____________________________________________________________________");
        System.out.println(" Our intervals: \n");
        util.initCheckIsolationInterval();

        answer = new String[rootIsoInterMap.size()];

        System.out.println("____________________________________________________________________");
        System.out.println(" Input data cycle: \n");
        util.printList(listOfFxOnEachIter);
        System.out.println("____________________________________________________________________");
        System.out.println(" Interval map:  \n");
        util.printMap(rootIsoInterMap);

        //algorithm
        int k = 1;
        for (Map.Entry<Double, Double> map : rootIsoInterMap.entrySet()) {

            borderLeft = map.getKey();
            borderRight = map.getValue();

            x = (borderLeft + borderRight) / 2;
            fLMax = DichotomyUtil.calcFun(borderLeft);
            fX = DichotomyUtil.calcFun(x);
            multiFxFL = fLMax * fX;

            while (true) {
                if (multiFxFL > 0) {
                    borderLeft = x;
                }
                if (multiFxFL < 0) {
                    borderRight = x;
                }
                x = (borderLeft + borderRight) / 2;
                fLMax = DichotomyUtil.calcFun(borderLeft);
                fX = DichotomyUtil.calcFun(x);
                multiFxFL = fLMax * fX;
                if (Math.abs(fX) < epsilon) {
                    answer[k - 1] = "-> For " + k + " interval - Answer = " + x;
                    k++;
                    break;
                }
            }
        }
        System.out.println("\n" + util.rootIntervalIsolation(rootIsoInterMap) + "\n");

        System.out.println("____________________________________________________________________");
        System.out.println(" Results: \n\n");
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
