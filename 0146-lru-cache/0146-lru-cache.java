class LRUCache {
    // implement using double linked list and a hashmap

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;
   
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        // for LRU remove and add
        remove(node);
        add(node);
        return node.value;

    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        }    

        Node node = new Node(key,val);
        add(node);
        map.put(key,node);
        if(map.size() > this.capacity) {
            Node first = head.next;
            remove(first);
            map.remove(first.key);
        }
    }
    
    
   

    void add(Node node) {
        // add at the tail
        Node previous = tail.pre;
        tail.pre = node;
        node.next = tail;
        node.pre = previous;
        previous.next = node;
    }

    void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre; 
        
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);


  void add(Node node) {
        //add at the tail
        Node previous = tail.pre;
        tail.pre = node;
        previous.next = node;
        node.pre = previous;
        node.next = tail;
        
    }

    void remove(Node node) {
        //add at the tail
        node.pre.next = node.next;
        node.next.pre = node.pre;
        
    }
 */