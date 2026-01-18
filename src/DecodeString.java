import java.util.*;
import java.util.LinkedList;


public class DecodeString {

    public static void main(String[] args) {
        String str = "2[abc]2[ef]";
        decodeString(str);

    }

    public static void decodeString(String str) {
        int num = 0;
        String emp ="";
        for(int i = 0; i< str.length(); i++){
            char ch  = str.charAt(i);
            while(ch!='['){
                num = num*10 + Integer.parseInt(String.valueOf(ch));
                i++;
                ch = str.charAt(i);
            }
            i++;
            while(ch!=']'){
                emp+= str.charAt(i);
                i++;
                ch = str.charAt(i);

            }
            for(int k=0;k<num;k++){
                System.out.print(emp);
            }
            num=0;
            emp="";
        }
    }

}
