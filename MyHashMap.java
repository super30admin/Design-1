//Time Complexity: The time complexity for retrieval and adding is O(1).
//Space Complexity: The space complexity is O(100001).
//Leet Code prblem: runs on leet code.
//Approach: Create an array. Fill the array with -1.Get the key for the value. Remove a value if it is not already empty.
class MyHashMap {
      int[] map=new int[100001];
    /** Initialize your data structure here. */
    public MyHashMap() {
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(map[key]!=-1)
            map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//Time Complexity: The time complexity for retrieval and adding each element is O(1).
//Space Complexity: The space complexity if all the 10^6 elements are inserted is O(10,000) for arrays and O(100) for the linked list.
//Leet Code prblem: runs on leet code.
//Approach: Create an Node class. Create an array of the nodes class elements. Whenever we want to get or put, get the hashcode of the key, find the key  and insert it using the previous pointer.
//Runs on leet code.

class MyHashMap {
    class Node{
        int key;int val;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
     
    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes=new Node[10000];
    }
    
    private int index(int key){
        return Integer.hashCode(key)% nodes.length;
    }
    private Node find(Node head,int key){
        Node curr=head; Node prev=null;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
            
        }
        return prev;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=index(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1);
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.val=value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=index(key);
        if(nodes[index]==null) return -1;
        Node prev=find(nodes[index],key);
        if(prev.next==null) return -1;
        return prev.next.val;
            
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=index(key);
        if(nodes[index]==null) return;
        Node prev=find(nodes[index],key);
        if(prev.next==null) return;
        else
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */