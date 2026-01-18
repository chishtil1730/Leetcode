import java.util.*;

public class OneCount {
    public static void main(String[] args) {
        int chum =824883294;
        int count=0;
        for(int i=0;i<=chum;i++){
            int num = i;
            while (num>0){
                if(num%10==1){
                    count++;
                    num = num/10;
                }else {
                    num=num/10;
                }
            }
        }
        System.out.println(count);

    }
}
