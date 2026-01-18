import java.util.*;


public class Frequency {

    public static void main(String[] args){

        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k=4;

        System.out.println(topKFrequent(words,k));

        int[] nums = {1,2};

        List<Integer> out = majorityElement(nums);
        System.out.println(out);
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i : nums){
            if(hm.containsKey(i)){
                hm.replace(i,hm.get(i),hm.get(i)+1);
            }else {
                hm.put(i,1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        List<Integer> out = new ArrayList<>();
        int val = (nums.length)/3;
        for(int i=0;i<list.size();i++){
            Map.Entry<Integer,Integer> node = list.get(i);
            if(node.getValue()>val){
                out.add(node.getKey());
            }
        }
        return out;
    }


    private static String frequencySort(String str) {
        String out = "";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                hm.replace(ch, hm.get(ch),hm.get(ch)+1);
            }else {
                hm.put(ch,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for(int i=0;i<list.size();i++){
            Map.Entry<Character,Integer> lad= list.get(i);
            for(int j=0;j<lad.getValue();j++){
                out+=lad.getKey();
                System.out.print(lad.getKey());
            }
        }
        return out;
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> out = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();

        for(String i : words){
            hm.put(i , hm.getOrDefault(i,0)+1);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(hm.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        int k2=0;

        for(int i=0;i<list.size();i++){
            Map.Entry<String,Integer> mp = list.get(i);
            if(k2>=k){
                break;
            }else {
                out.add(mp.getKey());
                k2++;
            }
        }
        Collections.sort(out);
        return out;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();


        for(int i: nums){
            if(hm.containsKey(i)){
                hm.replace(i,hm.get(i),hm.get(i)+1);
            }else {
                hm.put(i,0);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int[] res = new int[k];
        int k1=0;
        for(Map.Entry<Integer,Integer> map : list){
            if(k1>=k){
                break;
            }
            res[k1] = map.getKey();
            k1++;
        }

        return res;
    }

}
