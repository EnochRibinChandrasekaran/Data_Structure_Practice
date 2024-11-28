import java.util.*;

public class BinarySearchTree {
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "[ " + value + " ]";
        }
    }

    private Node root;

    private int count;


    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            count++;
            return;
        }
        var current = root;
        while (true) {
            if (current.value > value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    count++;
                    break;
                }
                current = current.leftChild;
            } else if (current.value < value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    count++;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        if(root ==  null)
            throw new NoSuchElementException();
        var current = root;
        while(true){
            if(current == null){
                return false;
            }
                if(current.value > value){
                    current = current.leftChild;
                }else if(current.value < value)
                    current = current.rightChild;
                else
                    return true;
            }

        }

        public void postOrder() {
            var current = root;
//            while (current != null) {
//                //LRROOT
//                if (current.leftChild != null) {
//                    current = current.leftChild;
//                    System.out.println(current.value + " , ");
//                } else if (current.rightChild != null) {
//                    current = current.rightChild;
//                    System.out.println(current.value + " , ");
//                } else if (current != null) {
//                    System.out.println(current.value + " , ");
//                }
//            }
            System.out.println(count);
            ArrayList<Integer> leafNodes = new ArrayList<>();
            System.out.println(countLeaves(root,leafNodes).toString());
            System.out.println(maxValue(root));
            System.out.println(contains(1,root));
            ArrayList<Integer> ancestors = new ArrayList<>();
            System.out.println(getAncestors(200,root,ancestors).toString());
            System.out.println(areSibling(1,4,root));

        }

        public void postOrderTraversal(Node current){
        if(current == null){
            return;
        }
        postOrderTraversal(current.leftChild);
        postOrderTraversal(current.rightChild);
            System.out.println(current.value);
        }

        public void inOrderTraversal(Node current){
        if(current == null)
            return;
            inOrderTraversal(current.rightChild);
            System.out.println(current.value);
            inOrderTraversal(current.leftChild);
        }

        public void preOrderTraversal(Node current){
        if(current == null){
            return;
        }
            System.out.println(current.value);
        preOrderTraversal(current.leftChild);
        preOrderTraversal(current.rightChild);
        }

        //          7
//              4       9
//          1       6 8     10
     public void levelOrder(Node current){
         Queue<Node> queue = new LinkedList<>();
         queue.add(current);
         while(!queue.isEmpty()){
                current = queue.remove();
             System.out.println(current.value);
             if(current.leftChild !=null)
                 queue.add(current.leftChild);
             if(current.rightChild != null)
                queue.add(current.rightChild);

         }
     }



     private int treeHeight(Node current){
        if(current.rightChild == null && current.leftChild==null){
            return 0;
        }
        return 1 + Math.max(treeHeight(current.leftChild), treeHeight((current.rightChild)));
     }

     private int minValueOrdered(Node current){
        if(current.leftChild == null){
            return current.value;
        }
         return minValueOrdered(current.leftChild);
     }

     private int minValue(Node current){
         if(current.rightChild == null && current.leftChild==null){
             return current.value;
         }
         var left  = minValue(current.leftChild);
         var right = minValue(current.rightChild);

         return Math.min(Math.min(left, right), current.value);
     }

    public boolean equals(BinarySearchTree bst) {
        Node node = bst.root;
        return equalTrees(root, node);
    }


    private boolean equalTrees(Node current1, Node current2){
        if(current1 == null && current2 == null )
            return true;
        if(current1 != null && current2 != null ){
            return current1.value == current2.value &&
                    equalTrees(current1.leftChild, current2.leftChild) &&
                    equalTrees(current1.rightChild, current2.rightChild);
        }
        return false;
    }

    private boolean validateTree(Node current,int min, int max){
       if(current == null)
           return true;
       if(current.value < min && current.value > max)
           return false;

       return
               validateTree(current.leftChild, min, current.value -1) &&
                       validateTree(current.rightChild, current.value, max);
    }

    private void NodesAtK ( Node current, int k){
        if(current == null){
            return;
        }
        if(k==0){
            System.out.println(current.value);
        }
        NodesAtK(current.leftChild,k-1);
        NodesAtK(current.rightChild,k-1);
    }

    private ArrayList<Integer> countLeaves(Node current,ArrayList<Integer> leaves){
        if(current.rightChild == null && current.leftChild==null)
            leaves.add(current.value);
        if(current.leftChild != null)
            countLeaves(current.leftChild,leaves);
        if(current.rightChild != null)
            countLeaves(current.rightChild, leaves);
        return leaves;
    }

    private int maxValue(Node current){
        if(current.rightChild == null){
            return current.value;
        }
        return maxValue(current.rightChild);
    }

    private boolean contains(int value, Node current){
        if(current == null)
            return false;
        if(current.value == value) return true;
        if(current.value > value && current.leftChild != null)
           return contains(value,current.leftChild);
        if(current.value < value && current.rightChild != null)
            return contains(value,current.rightChild);
        return false;
    }

    private ArrayList<Integer> getAncestors(int value,Node current, ArrayList<Integer> items){
        if(current == null) return items;
        if(current.value == value) return items;
        else items.add(current.value);
        if(current.value > value && current.leftChild != null) return getAncestors(value,current.leftChild, items);
        if(current.value < value && current.rightChild != null) return getAncestors(value,current.rightChild, items);
        return new ArrayList<>();
    }

    private boolean areSibling(int right, int left,Node current){
        if(current.rightChild == null && current.leftChild == null)
            return false;
        if(current.rightChild!=null && current.leftChild!=null){
            if((current.rightChild.value == right && current.leftChild.value == left )
                    || ( current.rightChild.value == left &&  current.leftChild.value == right ))
                return true;
        }
        if(current.value > left )
            return areSibling(right,left,current.leftChild);
        if(current.value < left )
            return areSibling(right,left,current.rightChild);
        return false;
    }
}
