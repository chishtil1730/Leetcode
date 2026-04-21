import java.util.*;
//Wrong solution, doesn't work for certain test cases, we need to use dynamic programming for perfect result.
public class Triangle {
    public static void main(String[] args) {
        ArrayList<List<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>(Arrays.asList(1)));
        al.add(new ArrayList<>(Arrays.asList(2,3)));
        al.add(new ArrayList<>(Arrays.asList(1,1,100)));
        al.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        int minTotal = minimumTotal(al);
        System.out.println("The minimum sum = "+minTotal);


    }

    public static int minimumTotal(List<List<Integer>> al) {
        if (al == null || al.isEmpty()) {
            return 0;
        }
        int minSum =0;

        for(int i = 0; i< al.size(); i++){
            minSum+=returnMin((ArrayList<Integer>) al.get(i));
            System.out.println("Minimum in the level "+ al.get(i)+" is: "+returnMin((ArrayList<Integer>) al.get(i)));
        }

        return minSum;

    }

    public static int returnMin(ArrayList<Integer> list){

        if (list == null || list.isEmpty()) {
            return 0;
        }

        int min = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<min){
                min = list.get(i);
            }
        }
        return min;
    }
}
