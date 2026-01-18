import java.util.Arrays;

public class Robber {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6};
        long t1 = System.currentTimeMillis();
        int sum = rob(arr);
        long t2 = System.currentTimeMillis();

        long t11 = System.currentTimeMillis();
        int sum2 = robN(arr);
        long t22 = System.currentTimeMillis();

        System.out.println(sum);
        System.out.println(t2-t1+" ms");
        System.out.println();
        System.out.println(sum2);
        System.out.println(t22-t11+" ms");
    }

    public static int rob(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        if(arr.length%2==0){
            right--;
        }
        int sum =0;
        if(arr.length>2){
            while(left<=right&&left< arr.length&&right>=0){
                if(left==right){
                    sum+= arr[left];
                }else{
                    sum+=(arr[left]+ arr[right]);
                }
                System.out.println("sum added with "+ arr[left]+" "+ arr[right]);
                left+=2;
                right-=2;
            }
        }else{
            sum+= arr[0];
        }
        return sum;
    }

    public static int robN(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[arr.length - 1];
    }

}
