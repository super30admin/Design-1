/*Leetcode Problem :706 */

// Time Complexity : O(n) where n is the number of nodes at a certain array index
// Space Complexity : O(M + N), where M is the number of array indexs and N is the number of nodes in each index
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */
    //array of Nodes 
    Node[] buckets;
    
    //structure for each node that is added as input
    class Node{
        int key, value;
        Node next;
        
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    
    
    public MyHashMap() {
       buckets = new Node[10000]; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        int hash = key % 10000; //calculating the Hashcode value based on the key
        
        Node currentBucket = buckets[hash]; //first node at the hash based array index
        Node ptr = currentBucket;
        Node prev = null;
        
        //no node at the array index
        if(ptr == null)
            buckets[hash] = newNode;
        else{
            
            while(ptr != null){
                //update existing node
                if(ptr.key == newNode.key){
                  ptr.value = newNode.value;
                  return;  
                }
              
              prev = ptr; 
              ptr= ptr.next;
             
            }
            
            //add new node at the end of the Linked List at a particule array index
            prev.next = newNode;
            

        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int hashCode = key % 10000;
        Node currentBucket = buckets[hashCode];
        Node ptr = currentBucket;
        while(ptr!= null){
            //if key exists in any node at that particular array index
            if(ptr.key == key)
                return ptr.value;
            
            ptr = ptr.next;
            
        }
        
        //if key does not exist at all at that particular index
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = key % 10000;
        Node currentBucket = buckets[hashCode];
        Node ptr = currentBucket;
        
        //no node to remove
        if(ptr == null)
            return;
        Node prev = null;
        
        
        while(ptr!= null){
            if(ptr.key == key){
                if(prev != null)
                    prev.next = ptr.next;
                else
                    buckets[hashCode] = ptr.next; //if node removed is the first node of the array index
                
                ptr.next = null;
                
            }
            
            prev = ptr;
            ptr = ptr.next;
           
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