import java.util.*;
import java.util.Stack;

public class Graph {
    private class Node {
        String label;
        public Node (String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNodes (String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge( String from, String to){
        if(nodes.get(from) == null){
            throw new IllegalStateException();
        }
        if(nodes.get(to) == null){
            throw new IllegalStateException();
        }
        List<Node> nodeList = adjacencyList.get(nodes.get(from));
        if(!nodeList.contains(nodes.get(to)))
            nodeList.add(nodes.get(to));
    }

    public void print(){
        for(var itr:nodes.keySet()){
            System.out.println(itr + " Connected to "+
                    adjacencyList.get(nodes.get(itr)));
        }
    }

    public void removeNode(String label){
        if(nodes.containsKey(label)){
            for (var keyNode:adjacencyList.keySet()){
                adjacencyList.get(keyNode).removeIf(edge -> edge.label.contentEquals(label));
            }
            adjacencyList.remove(nodes.get(label));
    nodes.remove(label);
        }
    }

    public void removeEdge(String from, String to){
        if(nodes.get(from) == null){
            throw new IllegalStateException();
        }
        if(nodes.get(to) == null){
            throw new IllegalStateException();
        }
        adjacencyList.get(nodes.get(from)).remove(nodes.get(to));
    }

    public void dftraversal(String label){
        dfsitr(label);
//        dfsrecursive(nodes.get(label), new HashSet<>());
    }

    private void dfsrecursive(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for(var adj:adjacencyList.get(root)){
            dfsrecursive(adj,visited);
        }
    }

    private void dfsitr(String label){
        Set<Node> visited = new HashSet<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(nodes.get(label));
        while(!nodeStack.isEmpty()){
            var value = nodeStack.pop();

            if(visited.contains(value))
                continue;
            visited.add(value);
            System.out.println(value);

            for(var val:adjacencyList.get(value)){
                if(!visited.contains(val))
                    nodeStack.push(val);
            }
        }
    }



    private void bfsitr(String label){
        Queue<Node> nodeQueue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        nodeQueue.add(nodes.get(label));//A
        while(!nodeQueue.isEmpty()){
            var value = nodeQueue.remove();// A -- B --- C --- D
            if(visited.contains(value))
                continue;
            visited.add(value); //[A, B, C, D]
            System.out.println(value);
            for (var neighbour: adjacencyList.get(value)){
                if(!visited.contains(neighbour))
                    nodeQueue.add(neighbour); // B C---C D---D--
            }
        }
    }

    public List<String> topologicalSorting(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(var node:nodes.values())
            topologicalSort(node, stack, visited);

        List<String> path = new ArrayList<>();
        while(!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited) {
        if(visited.contains(node))
            return;

        for(var item:adjacencyList.get(node))
            topologicalSort(item, stack, visited);

        stack.push(node);
        visited.add(node);
    }

    public void hasCycle(){
        Set<Node> all = new HashSet<>();
        Map<Node,Node> visiting = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        all = (Set<Node>) nodes.values();
        for(var node:all){
            cycleDetection(node,visiting, visited);
        }
    }

    private void cycleDetection(Node node, Map<Node, Node> visiting, Set<Node> visited) {
        if(visited.contains(node))
            return;
        visiting.add
    }


}
