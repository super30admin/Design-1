Time Complexity - O(1)
Space Complexity - O(n)
import java.util.*;

class MyHashMap {
    LinkedList<Entry>[] map;
    public static int size = 769;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      int bucket = key % size;
      if(map[bucket]== null){
          map[bucket] = new LinkedList<Entry>();
          map[bucket].add(new Entry(key,value));
      }
        else{
            for(Entry entries: map[bucket]){
               if(entries.key == key)
                   entries.val = value;
                   return;
               }
            }
            map[bucket].add(new Entry(key,value));
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int bucket = key % size;
      LinkedList<Entry> enteries = map[bucket];
        if(enteries == null) return -1;
      for(Entry entry: enteries){
          if(entry.key == key){
              return entry.val;
          }
      }
          return -1;
      } 
    
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % size;
        Entry teRemove = null;
        if(map[bucket] == null) return;
        else{
            for(Entry entries : map[bucket]){
                if(entries.key == key){
                  toRemove = entries;
                }
            }
            if(toRemove == null) return;
            map[bucket].remove(toRemove);
        }
    }
    

class Entry{
    public int key;
    public int val;
    
    public Entry(int key, int val){
        this.key = key;
        this.val = val;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */