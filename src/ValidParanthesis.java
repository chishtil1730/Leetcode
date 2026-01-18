import java.util.*;

public class ValidParanthesis {
    static LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
    public static void main(String[] args) {
       /* printPar(3,0);
        System.out.println();
        printPar(2,1);
        System.out.println();
        printPar(1,2);
        System.out.println();
        printPar(0,3);*/

        rec(3,0);
        ArrayList<String> al = new ArrayList<>();
        System.out.println("The hash set is: ");
        for(Map.Entry<String ,Integer> np : map.entrySet()){
            al.add(np.getKey());
        }
        System.out.println(al);

    }

    public static void rec(int num1, int num2) {
        if (num1 < 0) {
            return;
        }

        //System.out.println("\nFor num1 = " + num1 + " num2 = " + num2);
        if(printPar(num1, num2).length()!=0){
            map.put(printPar(num1,num2),0);
        }


        if (num1 > 0) {
            //System.out.println("\nFor num1 = " + (num1 - 1) + " num2 = " + (num2 + 1));
            if(printPar(num1 - 1, num2 + 1).length()!=0){
                map.putIfAbsent(printPar(num1-1,num2+1),0);
            }
            rec(num1 - 1, num2 + 1);
        }
    }

    public static String printPar(int num1, int num2) {
        String emp ="";
        if(num1 ==0){
            for(int i = 0; i< num2; i++){
                emp+="( )";
                //System.out.print("( )");
            }
        }else if(num2 ==0){
            for(int i = 0; i< num1 *2; i++){
                if(i< num1){
                    emp+="( ";
                    //System.out.print("( ");
                }else{
                    emp+=" )";
                    //System.out.print(" )");
                }
            }
        }else if(num1 > num2){
            for(int i = 0; i< num1 *2; i++){
                if(i< num1){
                    emp+="( ";
                    //System.out.print("( ");
                }else {
                    emp+=" )";
                    //System.out.print(" )");
                }
            }
            for(int i = 0; i< num2; i++){
                emp+="( )";
                //System.out.print("( )");
            }
        }else if(num2 > num1){
            for(int i = 0; i< num1; i++){
                emp+="( )";
                //System.out.print("( )");
            }
            for (int i = 0; i< num2 *2; i++){
                if(i< num2){
                    emp+="( ";
                    //System.out.print("( ");
                }else {
                    emp+=" )";
                    //System.out.print(" )");
                }
            }
        }
        return emp;
    }
}