public class Ones {
    public static void main(String[] args) {
        String str = "111101010101";
        char[] chArr = str.toCharArray();
        int[] nums = str.chars().map(s->Character.getNumericValue(s)).toArray();
        int maxL = longestSubarray(nums);
        System.out.println(maxL);
    }

    public static int longestSubarray(int[] nums) {
        String str ="";
        for(int i:nums){
            str+=i;
        }
        if(countCharacter(str,'0')==0){
            return str.length()-1;
        }

        int zeroCount = 0;
        int startIndex = 0;

        long now = countCharacter(str,'0');
        System.out.println("The total window count is: "+now);

        int n=0;
        int maxL=0;

        while(n<now) {
            int i= startIndex;
            String emp = "";
            while(i< str.length()){
                if(str.charAt(i)=='0'){
                    zeroCount++;
                    if(zeroCount>0&&zeroCount%2==0){
                        break;
                    }else{
                        startIndex=i+1;
                        emp+= str.charAt(i);
                    }
                }else{
                    emp+= str.charAt(i);
                }
                i++;
            }
            System.out.println("Window number "+(n+1)+" is: "+emp);
            if(emp.length()-1>maxL){
                maxL=emp.length()-1;
            }
            n++;
        }
        System.out.println("\nMaximum number of ones is: "+maxL);
        return maxL;
    }

    public static long countCharacter(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }

}