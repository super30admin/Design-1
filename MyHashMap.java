// Time Complexity : O(1) of all methods
// Space Complexity : O(n) , size of the hashmap i.e. number of key,value pairs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/**
    Thoughbt process:
        - chaining methos: aray of LinkedLists
        - input size is 10^6
        - define an array of size 10^4, thus the max size of Linkedlist is 100
        - for get,put,remove find the node previous to the required node/interest
        - this will be O(n), where n is the size of the linkedList

*/

class MyHashMap {

    class Node{
        int key =-1, value=-1;
        Node next;
        public Node(int key, int value){
            this.key = key; 
            this.value = value;
            //next is defaulted to null
        }
        public Node(){}
    }
    
    Node[] map;
    private static final int MAP_SIZE = 10000;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Node[MAP_SIZE];    
    }
    
    private int getHash(int key){
        return key % MAP_SIZE;
    }
    
    private Node find(int key){
        int idx = getHash(key);
        if(map[idx] == null){
            Node node = new Node();
            map[idx] = node;
        }
        Node head=map[idx], prev=null;
        while(head!=null){
            if(head.key == key){
                return prev;
            }
            prev = head;
            head = head.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node res = find(key);
        if(res == null) {
            System.out.println(key +" " + value);
        }
        if(res.next == null){
            res.next = new Node(key,value);
        }else{
            res.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node res = find(key);
        return res.next == null ? -1 : res.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node res = find(key);
        if(res.next != null){
            res.next = res.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */