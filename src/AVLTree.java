public class AVLTree {
    private class AVLNode {
        AVLNode leftChild;
        AVLNode rightChild;
        int value;
        int height;

        private AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return " [" +value+"]";
        }
    }

    AVLNode root;

    int count;

    public void insert(int value){
        root  = insertInTree(value, root);
        count++;
    }

    private AVLNode insertInTree(int value, AVLNode root){
        if(root == null)
            return new AVLNode(value);
        if(root.value > value)
            root.leftChild = insertInTree(value, root.leftChild);
        if(root.value < value)
            root.rightChild = insertInTree(value, root.rightChild);

        root.height = calculateHeight(root);

        return balanceTree(root);
    }

    private AVLNode balanceTree(AVLNode root){
        if(LeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild); //LR
            root = rotateRight(root);
        }
        if(RightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            root = rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);

        return newRoot;
    }
    private int height(AVLNode node){
        return (node ==  null ? -1 : node.height);
    }

    private int calculateHeight(AVLNode root){
        return (Math.max(height(root.leftChild),(height(root.rightChild))) + 1);
    }

    private int balanceFactor(AVLNode node){
        return (node == null ? 0 : height(node.leftChild) - height(node.rightChild));
    }

    private boolean LeftHeavy(AVLNode node){
        return (balanceFactor(node) > 1);
    }

    private boolean RightHeavy(AVLNode node){
        return (balanceFactor(node) < -1);
    }





}
