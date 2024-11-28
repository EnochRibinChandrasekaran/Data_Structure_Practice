import java.util.Arrays;

public class LinearProbing {
    private class Entry{
        int key;
        String value;
        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return " [ "+ key + " : " + value + " ] ";
        }
    }

    Entry[] entries = new Entry[5];

    public void put(int key, String value){
        if(entries[hash(key)] ==  null){
            entries[hash(key)] = new Entry(key, value);
        }else{
            for (int i = 0;; i++) {
                var index = hash(key + i % entries.length);
                if(entries[index] == null){
                    entries[index] = new Entry(key, value);
                    break;
                }
            }
        }
    }

    public String get(int key){

        if(entries[hash(key)] != null && entries[hash(key)].key == key){
            return entries[hash(key)].value;
        }
        for (int i = 0;; i++) {
            var index = hash(key + i % entries.length);
            if(entries[index].key == key)
                return entries[index].value;
        }
    }
    private int hash(int key){
        return (key % entries.length);
    }

    public String toString(){
        return Arrays.toString(entries);
    }

}
