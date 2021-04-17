package algo.lab3;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class DichotomyUtil {

    DichotomyData data;
    Map<Double, Double> rootIsoInterMap;
    List<Double> listIterFx;

    public DichotomyUtil(DichotomyData data, Map<Double, Double> rootIsolationIntervalMap, List<Double> listOfFxOnEachIter){
        this.data = data;
        this.listIterFx = listOfFxOnEachIter;
        this.rootIsoInterMap = rootIsolationIntervalMap;
    }

    //interval check
    public void initCheckIsolationInterval(){
        int previous = 0;
        int now = 1;

        for (double i = data.getLeft(); i <= data.getRight(); i += 0.1) {
            listIterFx.add(DichotomyUtil.calcFun(i));

            if (i > data.getLeft()) {
                if ((listIterFx.get(previous) < 0 && listIterFx.get(now) > 0) ||
                        (listIterFx.get(previous) > 0 && listIterFx.get(now) < 0)) {

                    System.out.println(" [" + (i - 0.1) + " ; " + i + "]");
                    rootIsoInterMap.put(i - 0.1, i);
                }
                previous++;
                now++;
            }
        }
    }

    public void printList(List<Double> listIterFx){
        for (int i = 0; i < listIterFx.size(); i++) {
            System.out.println(" Step: "+ i + " -> Res:   " + listIterFx.get(i));
        }
    }

    public void printMap(Map<Double, Double> rootIsoInterMap){
        for (Map.Entry<Double, Double> map : rootIsoInterMap.entrySet()) {
            System.out.println(" [ " + map.getKey() + ";  " + map.getValue() + " ]");
        }
    }

    //equation calculation
    public static double calcFun(double i) {
        //2,5х3 – 0,9х2 – 0,8х – 2,2 = 0
        // return 2.5 * Math.pow(i, 3) - 0.9 * Math.pow(i, 2) - 0.8 * i - 2.2;
        return Math.pow(i, 3) - 2.8 * Math.pow(i,2) - 6.2 * i + 3.7;
    }


    public String rootIntervalIsolation(Map<Double, Double> rootIsoInterMap) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Double, Double> map : rootIsoInterMap.entrySet()) {
            str.append(" - - [ ").append(new DecimalFormat().format(map.getKey())).append(";").append(new DecimalFormat().format(map.getValue())).append(" ] - -");
        }
        return str.toString();
    }
}
