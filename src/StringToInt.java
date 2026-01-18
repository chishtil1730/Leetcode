import java.util.HashMap;

public class StringToInt {

    public static void main(String[] args) {

        String s = "-12345678909876543";

        System.out.println(myAtoi(s));

    }




    public static int myAtoi(String s){
        int res =0;
        int mul=1;
        boolean signProcessed = false;
        boolean digitStarted = false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==(char) 32 && !digitStarted && !signProcessed){
                continue;
            }
            if(s.charAt(i)==(char) 45 && !signProcessed && !digitStarted){
                mul = -1;
                signProcessed = true;
                continue;
            }
            if(s.charAt(i)==(char) 43 && !signProcessed && !digitStarted){
                signProcessed = true;
                continue;
            }
            if(Character.isDigit(s.charAt(i))){
                digitStarted = true;
                int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
                if(res > (Integer.MAX_VALUE - digit) / 10){
                    return (mul == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res= res*10 + digit;
            } else {
                break;
            }
        }
        return res*mul;
    }

}
