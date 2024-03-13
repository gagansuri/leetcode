package com.leetcode;

class MyHashMap2<K,V> {
    private int CAPACITY = 16;
    private Node[] buckets;

    public MyHashMap2() {
        buckets = new Node[CAPACITY];
    }


    public V get(K key) {
        int index = hash(key) % buckets.length;
        Node node = buckets[index];
        if (node == null) {
            return null;
        }

        while (node != null) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;

        }
        return null;

    }

    public void put(K key, V value) {
        int index = hash(key) % buckets.length;
        Node newNode = new Node(key, value);
        Node node = buckets[index];
        if (node == null) {
            buckets[index] = newNode;
            return;
        }
        while (node.next != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        //check last node
        if (node.key.equals(key)) {
            node.value = value;
            return;
        }

        node.next = newNode;
    }

    public void remove(K key) {
        int index = hash(key) % buckets.length;
        Node node = buckets[index];
        if (node == null) {
            return;
        }

        if (node.key.equals(key)) {
            buckets[index] = node.next;
            return;
        }

        Node currentNode = node, previousNode = node, nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode;
            if (currentNode.key.equals(key)) {
                previousNode.next = currentNode.next;
                return;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

    }


    private int hash(K key) {
        return key.hashCode();
    }


    class Node<K, V> {
        private K key;
        private V value;
        Node next;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

    }


    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    public static void main(String[] args) {
        MyHashMap2<Integer, Integer> myHashMap2 = new MyHashMap2<>();
        myHashMap2.put(1,1);
        myHashMap2.put(2,2);
        myHashMap2.put(3,3);
        System.out.println(myHashMap2.get(2));
        System.out.println(myHashMap2.get(3));
        System.out.println(myHashMap2.get(4));
    }
}