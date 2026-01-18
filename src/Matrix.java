import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int size=3;
        int a = (int)Math.pow(9,2);

        int[][] matrix = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.println("Enter element: ");
                matrix[i][j] = inp.nextInt();
            }
        }
        display(matrix);
        rotateMatrix(matrix);

    }
    public static void rotateMatrix(int[][] matrix){
        int size=matrix.length;
        for(int i=0;i<size;i++){
            for(int j=size-1;j>0;j--){
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void display(int[][] matrix){
        int size=3;
        for(int i=0;i<size;i++){
            for(int j=size-1;j>0;j--){
                System.out.println(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
