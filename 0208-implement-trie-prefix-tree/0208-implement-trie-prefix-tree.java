class Trie {
    Node root;
    class Node{
        public char c;
        public Node[] children;
        public boolean isWord;

        public Node(char c) {
            this.c = c;
            children = new Node[26];
            isWord = false;
        }

    }
    public Trie() {
        root = new Node('#') ;
    }
    
    public void insert(String word) {
        //start from the root
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                Node n = new Node(c);
                curr.children[c - 'a'] = n;
                curr = n;
            } else {
                curr = curr.children[ c - 'a'];
            }
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
     Node curr = root;
     for(char c : word.toCharArray()) {
        if(curr.children[c - 'a'] == null) {
            return false;
        } else {
            curr = curr.children[c - 'a'];
        }
     }
     return curr.isWord;   
    }
    
    public boolean startsWith(String prefix) {
     Node curr = root;
     for(char c : prefix.toCharArray()) {
        if(curr.children[c - 'a'] == null) {
            return false;
        } else {
            curr = curr.children[c - 'a'];
        }
     }
     return true;   
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */