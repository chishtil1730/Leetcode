import java.util.*;

public class StackO {

    public static void main(String[] args) {
        String str = ")()())";

        int count = longestValidParanthesis(str);
        System.out.println(count);
    }

    public static int longestValidParanthesis(String str) {
        char[] chars = str.toCharArray();
        int count=0;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]=='('&&chars[i+1]==')'){
                count++;
                i=i+1;
            }
        }
        return count;
    }

    public static int supMethod(String str) {
        int count =0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
            }else if(str.charAt(i)==')'&&!st.empty()){
                st.pop();
                count++;
            }
        }
        System.out.println(count*2);
        return count*2;
    }
}
