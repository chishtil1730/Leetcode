public class Pattern {
    public static void main(String[] args) {
        int num = 3;
        for(int i=0;i<num;i++){
            for(int j=0; j<num;j++){
                System.out.print( num - Math.min(Math.min(i,j),Math.min(num-i-1,num-j-1)) -1 );
            }
            System.out.println();
        }
    }
}
