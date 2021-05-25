/*
Created HashMap DS using LinkedList Node --> key, value, next
Time Complexity: O(1) average and O(n) for worst-case
Space Complexity:O(1)
Ran on LeetCode: Yes, accepted solution without issue
*/

class MyHashMap {
    
    int MAX_SIZE = 2069;
    Node n[];
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        n = new Node[MAX_SIZE]; // Array of nodes initialized to node data in bucket
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashValue(key);
        Node newNode = new Node(key, value);
        Node bucket = n[hash];
        
        // check if its the first node to be entered else iterate
        if (bucket == null) {
            n[hash] = newNode;
            return;
        }
        
        //iterate
        while(bucket.next != null) {
            if (bucket.key == key) {
                bucket.value = value;
                return;
            }
            bucket = bucket.next;
        }
        
        //check if that node is already present and replace
        if (bucket.key == key) {
            bucket.value = value;
        } else {
            bucket.next = newNode;
        }  
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashValue(key);
        Node bucket = n[hash];
        
        //not found - empty
        if (bucket == null) {
            return -1;
        }
        
        //iterate and search
        while (bucket.next != null) {
            if (bucket.key == key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        
        if (bucket.key == key) {
            return bucket.value;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hashValue(key);
        Node bucket = n[hash];
        
        if (bucket == null) {
            return;
        }
        
        if (bucket.key == key) {
            n[hash] = bucket.next;
            return;
        }
        
        Node current = bucket.next, previous = bucket;
        while (current != null) {
            if (current.key == key) {
                //key found now remove it
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    
    public int hashValue(int key) {
        return key % MAX_SIZE;
    }

    public static void main(String args[]) 
    { 
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

class Node {
    int key;
    int value;
    Node next;
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}