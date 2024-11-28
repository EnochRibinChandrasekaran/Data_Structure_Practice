import java.util.Arrays;

public class Heapify {
    public static void main(String[] args) {
        int[] numbers = {5,3,8,4,1,2};
        heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }




    private static void heapify(int[] numbers) {
        //for looop i
        //second loop check if the value is less
        for (int i = numbers.length/2-1 ; i >= 0 ;i--) {
            heapifySwap(i, numbers);
        }
    }

    private static void heapifySwap(int index,int[] numbers){
        int largerIndex = largerIndex(index, numbers);
        if(largerIndex != -1){
            swap(index,largerIndex, numbers);
            heapifySwap(largerIndex,numbers);
        }

    }

    private static int getLeftIndex(int index){
        return (index *2) + 1;
    }
    private static int getRightIndex(int index){
        return (index *2)  + 2;
    }

    private static int getParentIndex(int index){
        return (index-1)/2;
    }

    private static boolean validParent(int index,int[] numbers){
        int left = getLeftIndex(index);
        int right = getRightIndex(index);
        if(validIndex(left,numbers) && validIndex(right, numbers))
            if(numbers[index] > numbers[getLeftIndex(index)] && numbers[index] > numbers[getRightIndex(index)]) return true;
        if(validIndex(left, numbers))
            if(numbers[index] < numbers[left]) return false;
        if(validIndex(right, numbers))
            if(numbers[index] < numbers[right]) return false;

        return true;
    }



    private static boolean validIndex(int index, int[] numbers){
        return (index < numbers.length);
    }

    private static void swap(int index1,int index2,int[] numbers){
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static int largerIndex(int index, int[] numbers){

        if(getLeftIndex(index) < numbers.length && getLeftIndex(index) >= 0)
            if(numbers[getLeftIndex(index)]  > numbers[index])
                return getLeftIndex(index);
        if(getRightIndex(index) < numbers.length && getRightIndex(index) >= 0)
            if(numbers[getRightIndex(index)]  > numbers[index])
                return getRightIndex(index);
        return -1;
    }


}
