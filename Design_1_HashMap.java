// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    
    LinkedList<Entry>[]  map;
    public static int size = 769;

    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int bucket = key % size;
         if(map[bucket] == null){
             map[bucket] = new LinkedList<Entry>();
             map[bucket].add(new Entry(key, value));
         } else
         {
             for(Entry x  : map[bucket]){
                 if(x.key == key){
                     x.value = value;
                     return;
                 }
             }
             map[bucket].add(new Entry(key,value));
         }
        
    }
    
    public int get(int key) {
        int bucket = key % size;
        LinkedList<Entry> entrie = map[bucket];
        
        if(entrie == null) return -1;
        for (Entry entry: entrie){
            if(entry.key ==key) return entry.value;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int bucket = key % size;
        Entry toRemove = null;
        if(map[bucket] == null){
            return;
        }else{
            for( Entry x : map[bucket]){
                if(x.key==key){
                    toRemove = x;
                }
            }
            if(toRemove == null) return ;
            map[bucket].remove(toRemove);
        }
            
    }

    class Entry{
        int key;
        int value;
        
        
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
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