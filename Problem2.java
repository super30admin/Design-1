//Time Complexity : 
	/*
	 * put(): O(k) where k = no of values/no of operations in this case 
	 * 							10^6/10^4 = 10^2
	 * remove(): O(k) where k same as put()
	 * get(): O(k) where k same as put()
	 */
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : 


//Your code here along with comments explaining your approach
/*
 * 1. hashcode function to create hash of key(user input)
 * 2. A linkedlist to store user input K,V at hashedIndex
 * 3. search functionality to return previous pointer
 *    to ease put and remove function 
 */

class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] hashMap;
    
    public MyHashMap() {
        hashMap = new Node[10000];
    }
    
    //generate hash for index using key
    public int index(int key){
        return Integer.hashCode(key) % 10000;
    }
    
    public Node search(int key){
        int i = index(key);
        
        Node head = hashMap[i];
        Node prev = head;
        Node curr = head; 
        
        while( head != null && curr.next != null && key != curr.key){
            prev = curr;
            curr = curr.next;
        } 
        return prev;
    }
    
    public void put(int key, int value) {
        int i = index(key);
        
        //if hashMap bucket is empty then initialize root node
        if(hashMap[i] == null) {
            Node root = new Node(-1,-1);
            hashMap[i] = root;
            root.next = new Node(key, value);
        } else {
            Node ptr = search(key);
            if (ptr.next == null) ptr.next = new Node(key,value);
            else ptr.next.value = value;
        }
     }
    
    public int get(int key) {
        int i = index(key);
        if(hashMap[i] == null)  return -1;
        
        Node ptr = search(key);
        
        return ptr.next == null ? -1 : ptr.next.value ;
    }
    
    public void remove(int key) {
        int i = index(key);
        //if hashIndex exists perform deletion
        if(hashMap[i] != null) {
            Node ptr = search(key);
            //if key exists remove it
            if(ptr.next != null){
                ptr.next = ptr.next.next;
            }
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