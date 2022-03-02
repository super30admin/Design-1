// Time Complexity : O(1) FOR PUT, GET, DELETE in BEST CASE (If only 1 element in the list or that index is null) 
  //O(N) for PUT, GET, DELETE in Average case, WORST CASE. 

// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*

Created primary array of Type Nodes with size 10000 --> Each array will be having max 100 items of key-value pairs
Used hasing for calculating the index to store key-value pair

Used chaining (LINKEDLIST)to add, get and delete key-value pair in hashmap

Implemented find() to get the current node in list stored at specific index for given key

If the key is not in the list --> Will add new node in the list after prev node returned from find() 
If the key is already there, just update the value for that key


Same for delete(key-value pair) and get value for any key : Used find() to get the current node in list stored at specific index for given key

*/



class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    private Node[] nodes;
    private int buckets;
    public MyHashMap() {
        this.buckets = 10000;
        nodes = new Node[buckets];
    }
    private int hash(int key){
        return key % buckets;
    }
    
    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    public void put(int key, int value) {
        int h = hash(key);
        
        if(nodes[h] == null){
            nodes[h] = new Node(-1,-1);      
        }
        Node prev = find(nodes[h], key);
        
        if(prev.next == null){
            prev.next = new Node(key,value);    
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int h = hash(key);
        Node prev = find(nodes[h], key);
        
        if(nodes[h] == null){
            return -1;   
        }
        
        if(prev.next == null)    return -1;
        
        return prev.next.val;
    }
    
    public void remove(int key) {
        int h = hash(key);
        Node prev = find(nodes[h], key);
        
        if(nodes[h] == null){
            return;   
        }
        if(prev.next == null) return;
        
        prev.next = prev.next.next;
    }
}




public class Design1_Problem1{
    public static void main(String[] args){
        MyHashMap map = new MyHashMap();

        map.put(1,1); map.put(2,2);
        System.out.println("map.get(1) : " + map.get(1) );
        System.out.println("map.get(3) : " + map.get(3) );
        
        map.put(2,1);

        System.out.println("map.get(2) : " + map.get(2) );
        map.remove(2);

        System.out.println("map.get(2) : " + map.get(2) );

    }
}