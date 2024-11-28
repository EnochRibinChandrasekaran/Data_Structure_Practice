import java.util.*;

public class Tries {
  private class Node{
      char value;

      HashMap<Character,Node>  children = new HashMap<>();

      boolean isEndOfWord;

      public Node (char value){
          this.value = value;
      }

      private boolean hasChild(char ch){
          return children.containsKey(ch);
      }


      private void removeChild(char ch){
      children.remove(ch);
      }
      @Override
      public String toString() {
          return "[" + value + " ]";
      }
  }

  Node root  = new Node(' ');

  public void insert(String word){
      Node current = root;
      for(char ch:word.toCharArray()){
          if (!current.hasChild(ch)){
              current.children.put(ch, new Node(ch));
          }
          current = current.children.get(ch);
      }
      current.isEndOfWord = true;
  }

  public boolean contains(String word){
//      Node current  =  root;
//      for(char ch:word.toCharArray()){
//          if(current.hasChild(ch)){
//              current = current.children.get(ch);
//          }
//      }
//      return current.isEndOfWord;
     return containsRec(root, word,0);
  }

  private boolean findWord(String word, int index, Node current){
      if(index == word.length()-1)
          return current.isEndOfWord;
      if(current.hasChild(word.charAt(index))){
          current = current.children.get(word.charAt(index++));
          return findWord(word, index, current);
          }
      return false;
  }

  public boolean removeWord(String word){
      return removeWord(root, word,0);
  }

  public void preOrderTraversal(){
      preOrder(root, "");
  }

  public void postOrderTraversal(){
      postOrder(root, "");
  }

    private void postOrder(Node current, String word) {
      for(char ch: current.children.keySet())
          postOrder(current.children.get(ch), word + ch);
        if(current.isEndOfWord)
            System.out.println(word);
    }

    private void preOrder(Node current, String word) {
      if(current.isEndOfWord)
          System.out.println(word);
      for(var ch: current.children.keySet()){
          preOrder(current.children.get(ch),word + ch);
      }
    }

    private boolean removeWord(Node current, String word, int index){
      if(index == word.length()){
          if(!current.isEndOfWord)
              return false;
          current.isEndOfWord = false;
          return current.children.isEmpty();
      }
      char ch = word.charAt(index);
      Node child = current.children.get(ch);
      index  = index + 1;
      boolean isLastChildFound = removeWord(child,word,index);
      if(isLastChildFound){
          current.removeChild(ch);
          return current.children.isEmpty() && !current.isEndOfWord;
          }
      return false;
      }

      public List<String> findPrefix(String word){
      List<String> words = new ArrayList<>();
      var current = root;
      for(var ch:word.toCharArray()){
          if(current.hasChild(ch)){
              current = current.children.get(ch);
          }
          if(current == null)
              return words;
      }
      prefix(current,word,words);
       return words;
      }

    private void prefix(Node current, String word, List<String> words) {
        if (current.isEndOfWord)
            words.add(word);
        for (var chs : current.children.keySet()) {
            prefix(current.children.get(chs), word + chs, words);
        }
    }

    private boolean containsRec(Node current, String word, int index){
      if(index == word.length()-1){
          if(current.hasChild(word.charAt(index)))
              return current.children.get(word.charAt(index)).isEndOfWord;
      }
      if(current.hasChild(word.charAt(index))){
          return containsRec(current.children.get(word.charAt(index)), word, index+1);
      }
      return false;
    }
    public String findLongestPrefix(List<String> words){
        return longestPrefix(root,"",0,words);
    }
    private String longestPrefix(Node current, String commonWord, int index,List<String> words){
      if(commonInList(index,words)){
          var ch  = words.getFirst().charAt(index);
          if(current.hasChild(ch)){
              index++;
              var child =  current.children.get(ch);
              commonWord = (commonWord+ ch) + longestPrefix(child, commonWord,index,words);
              return commonWord;
          }


      }
        return commonWord;

    }

    private boolean commonInList(int index, List<String>  words){
        var ch  = words.getFirst().charAt(index);
        for(var word:words){
            if(word.charAt(index) != ch)
                return false;
        }
        return true;
    }


}







