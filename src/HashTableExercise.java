import java.util.*;

public class HashTableExercise {

    public Set<Integer> twoSum (int[] arr, int k){
       Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],k-arr[i]);

        }for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(k-arr[i]))
                set.add(i);
        }
        return set;
    }

//    public int mostFrequent(int[] arr){
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int item: arr){
//            if(map.containsKey(item)){
//                int value = map.get(item);
//            map.put(
//
//
//
//
//
//
//
//            }
//        }
    }
//}
