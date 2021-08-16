// Time Complexity : o(N)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.LinkedList;

class Entry{
    public int key;
    public int value;
    public Entry(int key,int value){
        this.key=key;
        this.value = value;
    }

}

class MyHashMap {
    LinkedList<Entry>[] map;
    private static int size = Integer.MAX_VALUE;

    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //hashcode logic
       int index = key%size;
       if(map[index]== null){
           map[index]= new LinkedList<Entry>();
           map[index].add(new Entry(key,value));
           return;
           
       }else{
            for(Entry entry: map[index]){
                if(entry.key==key){
                    entry.value=value;
                    return;
                }
            }
           
       }
        

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%size;
        LinkedList<Entry> entries = map[index];
        if(entries == null){
            return -1;
        }
        for(Entry entry : entries ){
            if(entry.key==key){
                return entry.value;
            }
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%size;
        Entry toremove = null;
        if(map[index]== null){
            return;
        }
        for(Entry entry: map[index]){
            if(entry.key==key){
                toremove= entry;
            }
        }
        if(toremove== null){
            return;
        }else{
            map[index].remove(toremove);
        }

        
    }
}

