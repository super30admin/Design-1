/*The code is submitted successfully in Leetcode. The search complexity is O(1) and space complexity is O(size(ArrayList)) or O(max(Key)).
The question specify to update values of key to handle collision scenarios so no chaining is done here otherwise I was planning to create Nested List*/

class MyHashMap {
    //Current bucket size of HashMap
    int bucket_size = 0;
    
    //List is used here and is created with buckets size initially 0
    ArrayList<Integer> hm = new ArrayList<Integer>();
    public MyHashMap() {    
        //Initially assign it to be current HashMap size
        bucket_size = hm.size();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //Creating HashMap with Size = MaxKey as we dont want chaining
        if(key >= hm.size()){
            for(int i=hm.size(); i<=key; i++)
                hm.add(i,-1);
        }
        hm.set(key,value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key >= hm.size()){
            for(int i=hm.size(); i<=key; i++)
                hm.add(i,-1);
        }
        
        if(hm.get(key)!= -1){
            return(hm.get(key));
        }
            return(-1);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(key >= hm.size()){
            for(int i=hm.size(); i<=key; i++)
                hm.add(i,-1);
        }
        
        if(hm.get(key) != -1){
            hm.set(key,-1);
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
