// Time Complexity: O(N/k) where N = number of keys, k = number of buckets
// Space Complexity: O(k + M) where k = number of buckets, M = all the key-value pair nodes in the entire MyHashMap
// LeetCode: Yes(https://leetcode.com/problems/design-hashmap/)
/*
    Approach: Use an array of LinkedLists (Separate Chaining)
    The Hash function is dividing the key by number of buckets and add the key-value pair in the LinkedList of the bucket equal to the remainder of the solution
    Put function: Iterate through the Linked list of that bucket, insert a new node if node does not exists or update the value if the node exists
    Get function: Iterate through the Linked list of that bucket, return thre value if the key exists else return -1
    Remove function: Iterate through the Linked list of that bucket, remove the reference to the node of the key
*/

class MyHashMap {
    
    /** A Node Class to hold a key-value pair  */
    class Node {
        int key, value;
        Node next;
        
        
        /** Initialize a node */
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
    }
    
    /** Buckets for separate chaining */
    Node[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        /* Get the bucket in which the key-value pair will go */
        int bucket = hash(key);
        
        /* If there is no node in the bucket then insert the key-value pair Node in the beginning */
        if(buckets[bucket] == null) {
            buckets[bucket] = new Node(key, value);
            return;
        }
        
        /* If there is at least one node in the Linked List at the bucket corresponding to the passes key */
        
        /* Get the head of the Linked List in the current */
        Node current = buckets[bucket];
        
        /* If the node corresponding to the key to be inserted is the first node in the Linked List then update the value of the first node */
        if(key == current.key) {
            current.value = value;
            return;
        }
        
        /* Track the previous of the current*/
        Node previous = null;
        
        /* Traverse through the Linked List */
        while(current != null) {
            /* If a node corresponding to the passed key already exists then update its existing value */
            if(key == current.key) {
                current.value = value;
                return;
            }
            
            /* Move previous forward */
            previous = current;
            
            /* Move current forward */
            current = current.next;
            
            
        }
        
        /* If a node corresponding to the passed key did not exist then insert a new node at the end of the Linked List */
        previous.next = new Node(key, value);
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        /* Get the bucket in which the key-value pair may exist */
        int bucket = hash(key);
        
        /* If there is no node in the bucket corresponding to the key then the key-value pair does not exist so return -1 */
        if(buckets[bucket] == null) {
            return -1;
        }
        
        /* Get the head of the Linked List in the current */
        Node current = buckets[bucket];
        
        
        /* Traverse through the Linked List */
        while(current != null) {
            
            /* If a node corresponding to the passed key already exists then return its existing value */
            if(key == current.key) {
                return current.value;
            }
            
            /* Move current forward */
            current = current.next;
        }
        
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        /* Get the bucket in which the key-value pair may exist */
        int bucket = hash(key);
        
        /* If there is no node in the bucket corresponding to the key then the key-value pair does not exist so just return */
        if(buckets[bucket] == null) {
            return;
        }
        
        /* If the node corresponding to the key to be removed is the first node in the Linked List then remove the first node */
        if(buckets[bucket].key == key) {
            buckets[bucket] = buckets[bucket].next;
            return;
        }
        
        /* If the node corresoinding to the passed key is not the first node then set previous as the first node */ 
        Node previous = buckets[bucket];
        
        /* If the node corresoinding to the passed key is not the first node then set current as the second node */ 
        Node current = previous.next;
        
        /* Traverse through the Linked List */
        while(current != null) {
            
            /* If a node corresponding to the passed key already exists then remove reference to that node */
            if(key == current.key) {
                previous.next = current.next;
                return;
            }
            
            /* Update previous */
            previous = current;
            
            /* Update current */
            current = current.next;
        }
        
        
    }
    
    /** Helper function to hash the key */
    public int hash(int key) {
        return key % buckets.length;
    }
}
