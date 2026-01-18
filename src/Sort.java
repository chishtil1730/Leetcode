import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int len = arr.length;
        System.out.println("Length: "+len);

    }

    public static int search(int[] nums, int val){
        int res =  binarySearch(nums,0, nums.length-1,val);
        return res;
    }

    public static int binarySearch(int a[], int l, int r, int x){

        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == x) {
                return m;
            } else if (a[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int arr[]){
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static int partition(int[] arr,int low,int high) {
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

   public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


}
