import java.util.*;

public class HashingCount {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        int choice =1;
        do {
            System.out.println("Enter data: ");
            int dat = inp.nextInt();
            if(map.containsKey(dat)){
                map.replace(dat,map.get(dat),map.get(dat)+1);
            }else{
                map.put(dat,0);
            }
            System.out.println("Enter choice ");
            choice = inp.nextInt();
        }while(choice==1);
        for(Map.Entry<Integer,Integer> iter : map.entrySet()){
            System.out.println("Key: "+iter.getKey()+" , Value: "+iter.getValue());
        }
    }
}
