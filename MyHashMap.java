/**
 * Time Complexity : 
 * put() : O(n) where n = size of buckets (while initializing bucketItems to -1 when empty)
 * get() and remove(): O(1)
 * Space Complexity : O(1)  
 */

class MyHashMap {

    int [][] store;
    int buckets,bucketItems;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1001;
        store = new int[buckets][];
    }
    
    private int getBkt(int key){
        return key%buckets;
    }
    
    private int getBktItm(int key){
        return key%bucketItems;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = getBkt(key);
        int bucketItem = getBktItm(key);
        if(store[bucket] == null){
            store[bucket] = new int[bucketItems]; 
            //-1 at the bucketItem means empty bucketItem
            for(int i=0;i<store[bucket].length;i++){
                store[bucket][i] = -1;
            }
        }
        store[bucket][bucketItem] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = getBkt(key);
        int bucketItem = getBktItm(key);
        if(store[bucket] == null || store[bucket][bucketItem]==-1){
            return -1;
        }
        return store[bucket][bucketItem];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = getBkt(key);
        int bucketItem = getBktItm(key);
        if(store[bucket] != null){
            store[bucket][bucketItem] = -1;
        }
    }

    public static void main(String args[]){
        MyHashMap obj = new MyHashMap();
        int key = 1024;
        int value = 20;
        obj.put(key,value);
        int param_2 = obj.get(key);
        System.out.println("value for key "+key+" = "+param_2);
        obj.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */