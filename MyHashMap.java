/* Nov Cohort */ 

class MyHashMap {

    /** Initialize your data structure here. */
    
    // creating node of a linked list 
    private static class node{
        int key, value;
        node next;
        
        // node constructor
        node(int key, int value){
            
            // update member of the class 
            this.key = key;
            this.value = value;
        }
    }
    
    // array bucket
    
    node[] head = new node[1000];
        
    public MyHashMap() {
        
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % head.length;
        
        // if index is zero(bucket is empty) then add a new node
        if(head[index] == null){
            head[index] = new node(key, value);
            return;
        }
        else{
            node curr = head[index];
            if(curr.key == key){
                curr.value = value;
                return;
            }
            
            while(curr.next != null){
                if(curr.next.key == key){
                    curr.next.value = value;
                    return;
                }
                curr = curr.next;
            }
            curr.next = new node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % head.length;
        if(head[index] == null)
            return -1;
        else{
            node curr = head[index];
            while(curr != null)
            {
                if(curr.key == key){
                    return curr.value;
                } 
                 curr = curr.next;
            }
            
           
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = key % head.length;
        if(head[index] == null)
            return;
        
        if(head[index].key == key){
            head[index] = head[index].next;
        }
        
        node curr = head[index], prev = head[index];
        while(curr != null){
            if(curr.key == key){
                prev.next = curr.next;
                return;
            }
            
            prev = curr;
            curr = curr.next;
        }
    }
}

/*
Complexity Analysis 

Time Complexity: for each of the methods, the time complexity is O(N/K) 
where N is the number of all possible keys and 
K is the number of predefined buckets in the hashmap

Space Complexity: O(K+M) 
where K is the number of predefined buckets in the hashmap and 
M is the number of unique keys that have been inserted into the hashmap.
*/

 