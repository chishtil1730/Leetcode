import java.util.Arrays;

public class FindPos {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 6;
        int[] index = returnExpectedIndex(arr, target);
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(index));
        long endTime = System.nanoTime();
        System.out.println("Total time to  execute this method is: "+(endTime-startTime)+" ns");

    }

    private static int[] returnExpectedIndex(int[] arr, int target) {

        if(arr.length == 0){
            return new int[] {-1,-1};
        }

        if(arr.length==1){
            if(target==arr[0]){
                return new int[] {0,0};
            }
            return new int[] {-1,-1};
        }else{
            int left = 0;
            int right = arr.length - 1;
            boolean found = false;

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] == target) {
                    found = true;
                    break;
                } else if(arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if(!found) return new int[]{-1, -1};


            int firstPos = -1;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == target) {
                    firstPos = i;
                    break;
                }
            }


            int lastPos = -1;
            for(int i = arr.length - 1; i >= 0; i--) {
                if(arr[i] == target) {
                    lastPos = i;
                    break;
                }
            }

            return new int[]{firstPos, lastPos};
        }
    }
}