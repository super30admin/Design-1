public class MyHashMap {

    int[] hashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new int[1000001];
        for(int i = 0 ; i <= 1000000 ; i++){
        hashMap[i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    public void Put(int key, int value) {
        if(key > 1000000) return;
        hashMap[key]  = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int Get(int key) {
        if(key > 1000000) return -1;;
        if (hashMap[key] == null) return -1;
        return hashMap[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void Remove(int key) {
         if(key > 1000000) return;
         hashMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */