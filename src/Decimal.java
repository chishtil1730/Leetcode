import java.util.HashMap;

public class Decimal {
    public static void main(String[] args) {
        float a = (float) 4/333;
        System.out.println(a);
        int b =(int) a;
        String ls = Float.toString(a);
        String decimalVal  = ls.substring(ls.indexOf('.')+1,ls.length()-1);
        String emp = "";
        int i=0;
        int c=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            char ch = decimalVal.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
                emp+=ch;
                i++;
            }else{
                c=1;
                break;
            }
        }
        if(c==1){
            int j=0;
            String empn="";
            int len = emp.length()*2;
            for(int k=0;k<len;k++){
                empn+= decimalVal.charAt(k);
            }
            if((emp+emp).equals(empn)){
                System.out.println(b+".("+emp+")");
            }
        }
    }
}
