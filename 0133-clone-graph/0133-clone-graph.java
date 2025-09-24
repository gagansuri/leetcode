/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        // clone the node and go over the list of nodes
        // mapping of node in original and in the clone 
        if (node == null)
            return null;
        Map<Node, Node> lookup = new HashMap<>();
        return cloneGraph(node, lookup);
    }

    Node cloneGraph(Node node, Map<Node, Node> lookup) {
        Node copy = new Node(node.val);
        lookup.put(node, copy);
        for (Node n : node.neighbors) {
            // node is already been copied
            if (lookup.containsKey(n)) {
                copy.neighbors.add(lookup.get(n));
            } else {
                // create a copy deep of the neighbor node
                Node c = cloneGraph(n, lookup);
                //lookup.put(n,c);
                copy.neighbors.add(c);
            }
        }
        return copy;
    }

    
}
