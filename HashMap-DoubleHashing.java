//Exercise_1 : Design Hashmap
// Time Complexity : O(1)  -> for all operations
// Space Complexity : O(N+K)=> Total Elements where N is size of parent array and K is the size of child list where value is stored(Linked List)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: Here Double Hashing is implemented. I created a class Node and initialised 2d array of Nodes. For each index I'm storing 1D array of nodes and then storing values on the index of 1D Array 


class MyHashMapDoubleHashing {

    
    //Using Double Hashing
    private int bucketSize;
    private int bucketItemsSize;
    
    class Node{
        private int val;
        
        Node(int val){
            this.val = val;
        }
    }
    
    private int getBucketHash(int key){
        return key%bucketSize;
    }
    
    private int getBucketItemHash(int key){
        return key/bucketItemsSize;
    }
    
    private Node[][] nodes;
    
    /** Initialize your data structure here. */
    public MyHashMapDoubleHashing() {
        bucketSize = 1000;
        bucketItemsSize = 1001;
        nodes = new Node[bucketSize][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int bucketIndex = getBucketHash(key);
        int bucketItemIndex = getBucketItemHash(key);
        
        if(nodes[bucketIndex]==null){
            nodes[bucketIndex] = new Node[bucketItemsSize];
        }
        
        if(nodes[bucketIndex][bucketItemIndex]==null){
            nodes[bucketIndex][bucketItemIndex] = new Node(value);
        }else{
           Node node = nodes[bucketIndex][bucketItemIndex];
           node.val = value; 
        }
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int bucketIndex = getBucketHash(key);
        int bucketItemIndex = getBucketItemHash(key);
        
        if(nodes[bucketIndex]==null){
            return -1;
        }
        
        if(nodes[bucketIndex][bucketItemIndex]==null){
            return -1;
        }else{
           Node node = nodes[bucketIndex][bucketItemIndex];
           return node.val; 
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         
        int bucketIndex = getBucketHash(key);
        int bucketItemIndex = getBucketItemHash(key);
        
        if(nodes[bucketIndex]==null){
            return;
        }
        
        if(nodes[bucketIndex][bucketItemIndex]==null){
            return;
        }else{
           nodes[bucketIndex][bucketItemIndex] = null;
        }
        
    }
}