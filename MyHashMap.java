class MyHashMap {

    // Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this. key = key;
            this.value = value;
        }
    }
    int PrimaryArray;
    Node [] nodes;

    public MyHashMap() {
        PrimaryArray = 10000;
        nodes = new Node[PrimaryArray];

    }

    public Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public int hashing(int key){
        return Integer.hashCode(key) % PrimaryArray;
    }


    public void put(int key, int value) {
        int hashvalue = hashing(key);
        if(nodes[hashvalue] == null){
            nodes[hashvalue] = new Node(-1,-1);
        }
        Node prev = find(nodes[hashvalue], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hashvalue = hashing(key);
        if(nodes[hashvalue] == null){
            return -1;
        }
        Node prev = find(nodes[hashvalue], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int hashvalue = hashing(key);
        if(nodes[hashvalue] == null){
            return;
        }
        Node prev = find(nodes[hashvalue], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */