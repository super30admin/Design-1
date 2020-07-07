// Time Complexity : for put, delete, get
//      Best:O(1)
//      Worst:O(n)
//      Amortized: O(1) using Better Has function
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach

class MyHashMap {

    // member variables
    HashNode nodes[];
    int capacity;
    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 1000;
        nodes = new HashNode[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        HashNode tempNode = findNode(key);
        // inserting the value
        if(tempNode.next == null)
            tempNode.next =  new HashNode(key, value);
        // updating the value
        else
            tempNode.next.value = value;

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        HashNode tempNode = findNode(key);
        return tempNode.next==null?-1:tempNode.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // getting previous node
        HashNode tempNode = findNode(key);
        // removing by updating next of previous node 
        if(tempNode.next!=null)
            tempNode.next = tempNode.next.next;
    }
     /** Finds the previous Node to the key */
    public HashNode findNode(int key){
        // hashing
        int index = getIndex(key);

        // if no node present forthe index
        if(nodes[index]==null)
            return nodes[index] = new HashNode(-1,-1);
        // Else find the previous node
        HashNode prevNode = nodes[index];
        while(prevNode.next!=null && prevNode.next.key!=key)
            prevNode =prevNode.next;
        
        return prevNode;
        
    }
    
     /** Hashing fucntion for the key */
    public int getIndex(int key){
        return key%capacity;
    }
    
    // Node class definition
    public static class HashNode{
        int key;
        int value;
        HashNode next;
        
        public HashNode(int key, int value){
            this.key= key;
            this.value=value;
            
        }
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        int key=5, value =10;
        System.out.println("Put key: "+key +", value: "+value);
        obj.put(key,value);
        int param_2 = obj.get(key);
        System.out.println("Value: "+param_2);
        obj.remove(key);
        System.out.println("Removed key: "+key);

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */