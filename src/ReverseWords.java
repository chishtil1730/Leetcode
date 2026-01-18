
public class ReverseWords {
    public static void main(String[] args) {
        String str = "a good            example is a";
        String rev = reverseWords(str);
        System.out.println('"'+rev+'"');
    }

    public static String reverseWords(String str) {
        String emp="";
        String[] arrStr = str.split("\s+");
        for(int i = arrStr.length-1;i>=0;i--){
            if(i!=0){
                emp+=arrStr[i]+" ";
            }else {
                emp+=arrStr[i];
            }
        }
        return emp;
    }
}
