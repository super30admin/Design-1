// Time Complexity : O(1);
// Space Complexity : O(1);
// Did it run on Leetcode : YES;
// Any Problems: Had some doubts regarding optimization of this code;

class KVNode {

    
    public int key;
    public int value;

   
    public KVNode(int key, int value) {
        this.key    = key;
        this.value  = value;
    }
}



class MyHashMap {
 
    
    final int INITIAL_CAPACITY = 100000;
 
   
    private KVNode[] map;
    public int capacity;
 
    
    public MyHashMap() {
        this.map        = new KVNode[INITIAL_CAPACITY];
        this.capacity   = INITIAL_CAPACITY;
    }

    
    private int hashFc(int key) {
        return key % capacity;
    }
 
   
    public void put(int key, int value) {

        
        int bucket = hashFc(key);

        
        if (this.map[bucket] == null) {
            this.map[bucket] = new KVNode(key, value);
        } else {
            this.map[bucket].key    = key;
            this.map[bucket].value  = value;
        }
    }
 
    public int get(int key) {

       
        int bucket = hashFc(key);

       
        if (this.map[bucket] == null) {
            return -1;
        } else {
            return this.map[bucket].value;
        }
    }

    public void remove(int key) {

       
        int bucket = hashFc(key);
        
        
        this.map[bucket] = null;
    }
 
    
    @Override
    public String toString() {
 
        
        StringBuilder sb = new StringBuilder();
 
        
        for (int i = 0; i < this.map.length; i++) {
            if (this.map[i] != null) {
                sb.append(this.map[i].key + "=" + this.map[i].value + " ");
            }
        }
 
        
        return sb.toString();
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */