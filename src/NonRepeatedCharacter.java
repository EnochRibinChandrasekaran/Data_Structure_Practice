import java.util.*;

public class NonRepeatedCharacter {
    public char firstNonRepeatedCharacter(String item){
        Map<Character, Integer> map = new HashMap<>();
        for ( char ch: item.toCharArray()){
            if(map.containsKey(ch)){
                int value = map.get(ch);
                map.put(ch,++value);
            }else{
                map.put(ch,1);
            }
        }
        char single = 0;
        for( char ch: item.toCharArray()){
            if(map.get(ch)==1){
                return ch;
            }
        }
        return single;
    }

    public char firstRepeatingChar(String item){
        Set<Character> set = new HashSet<>();
        var chars = item.toCharArray();
        for( char ch: chars){
            if(set.contains(ch))
                return ch;
            else
                set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
