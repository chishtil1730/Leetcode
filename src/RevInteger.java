public class RevInteger {

    public static void main(String[] args) {
        int a = reverse(1534236469);
        System.out.println(a);
        System.out.println(42);
    }

    public static int reverse(int x){

        int c;
        if(x<0){

            x = x*-1;
            String s = Integer.toString(x);
            String emp = "";
            for(int i=s.length()-1;i>=0;i--){
                emp+=s.charAt(i);
            }
            try {
                int b = Integer.parseInt(emp);
                return b*-1;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        else{
            String s = Integer.toString(x);
            String emp = "";
            for(int i=s.length()-1;i>=0;i--){
                emp+=s.charAt(i);
            }
            try {
                int b = Integer.parseInt(emp);
                return b;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}