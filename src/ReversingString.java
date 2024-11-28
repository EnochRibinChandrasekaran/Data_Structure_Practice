import java.util.Arrays;
import java.util.Stack;

public class ReversingString {
    public static void main(String[] args){
        String str = "abcd";
        System.out.println(str.toCharArray());
        Stack<Character> deconstructedString = new Stack<Character>();
        for (char ch: str.toCharArray())
            deconstructedString.push(ch);
        StringBuffer reversedString = new StringBuffer();
        while(!deconstructedString.isEmpty())
            reversedString.append(deconstructedString.pop());
        System.out.println(reversedString);

    }
}
