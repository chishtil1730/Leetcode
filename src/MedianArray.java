
import java.util.Arrays;
import java.util.Scanner;

public class MedianArray {
    public static void main(String[] args) {
        /*Scanner inp = new Scanner(System.in);
        int[] arr1 = {1,4,7};
        int[] arr2 = {2,3,8};

       int[] mergedArray = mergeArrays(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));*/


    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i =0;

        int[] mergedArray = new int[arr1.length+ arr2.length];

        int mi=0;

        while(mi<mergedArray.length){
            if(arr1[i]< arr2[i]){
                mergedArray[mi]= arr1[i];
                mi++;
                mergedArray[mi]= arr2[i];
                mi++;
                i++;
            }else{
                mergedArray[mi]= arr2[i];
                mi++;
                mergedArray[mi]= arr1[i];
                mi++;
                i++;
            }
        }
        return mergedArray;
    }
}
