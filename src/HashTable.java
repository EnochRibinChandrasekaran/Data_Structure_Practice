import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {
    private final int size;
    private final LinkedList<Entry>[] bucketList;
    public HashTable(int size){
        this.size = size;
        this.bucketList = (LinkedList<Entry>[]) new LinkedList[size];
    }
    private class Entry{
        int key;
        String value;

        private Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "[ "+ key + " : " + value + " ]";

        }

        @Override
        public int hashCode(){
            return key;
        }
    }



    public void put(int key, String value){
        var entry = new Entry(key,value);
        if(bucketList[hash(key)]==null){
            bucketList[hash(key)] = new LinkedList<>();
        }
        var bucket = bucketList[hash(key)];
        for(var item : bucket){
            if(item.key == key){
                item.value = value;
                return;
            }
        }
        bucket.addLast(entry);
    }

    public String get(int key){
        var bucket = bucketList[hash(key)];
        if(bucket == null){
            return "No Entry";
        }
        for(var item: bucket){
            if(item.key == key)

                return item.value;
        }
        return "No Data";
    }

    public void remove(int key){
        var bucket = bucketList[hash(key)];
        if(bucket == null){
            throw new NoSuchElementException();
        }
        for(var item:bucket){
            if(item.key == key){
                bucket.remove(item);
                return;
            }
        }

    }
    private int hash(int key){
        return Math.abs(key % size);
    }

    @Override
    public String toString(){

        return Arrays.toString(bucketList);
    }

    private LinkedList<Entry> getLinkedList(int key){
        return bucketList[hash(key)];
    }

}
