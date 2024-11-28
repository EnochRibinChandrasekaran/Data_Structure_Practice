public class Array {
    private int[] items;
    private int count;
    public Array (int length){
        items = new int[length];
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);

        }
    }

    public int  indexOf(int item){
        for (int i = 0; i < count; i++) {
            if(items[i] == item)
                return i;
        }
        return -1;
    }

    public void removeAt(int i){
        if(i < 0 || i> count){
            System.out.println("Index Not Found");
        }else{
            for (int j = i; j < count; j++) {
                items[j] = items[j+1] ;
            }
            count--;
        }
    }

    public void insert(int item){
        if(items.length == count){
            int[] largeItems = new int[count *2];
            for (int i = 0; i < count; i++) {
                largeItems[i] = items[i];
            }
            items = largeItems;
        }
        items[count] = item;
        count++;
    }

    public int max(){
        int max = 0;
        for (int i = 0; i < count; i++) {
            if(items[i] > max)
                max= items[i];

        }
        return max;
    }

    public void reverse(){
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = items[count -i];
        }
        items = reversed;
    }

//    O(1)
    public void insertAt(int item, int index){
        items[index] = item;
    }

    //O(n2)
    public void intersect(int[] items2){
        for (int i = 0; i < count; i++) {
            for (int k : items2) {
                if (items[i] == k) {
                    System.out.println(items[i]);
                }
            }
        }
    }
// Main Class
//    Array items = new Array(5);
//        items.insert(1);
//        items.insert(2);
//        items.insert(3);
//        items.insert(4);
//    int[] items2  = {1,2,3,4};
//        items.intersect(items2);
//        items.max();
//        System.out.println(items.max());





}
