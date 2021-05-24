import java.util.LinkedList;
//time complexity=O(1)
//space complexity=O(N)
class MyHashMap {

    class Entry
    {
        int key,value;
        
        Entry(int key,int value){
            this.key=key;
            this.value=value;

        }
    }

    LinkedList<Entry>[] map;
    int size=1001;
    int bucket;
    Entry temp;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map=new LinkedList[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        bucket =key%size;
        if(map[bucket]==null)
        {
            map[bucket]=new LinkedList<>();
            map[bucket].add(new Entry(key,value));
        }
        else
        {
            for (Entry entry:map[bucket])
            {
                if(entry.key==key)
                {
                    entry.value=value;
                    return;
                }
            }
            map[bucket].add(new Entry(key,value));
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        bucket=key%size;
        LinkedList<Entry> entries=map[bucket];
        for(Entry entry:entries)
        {
            if(entry.key==key)
            
            {
                return entry.value;
            }

        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        bucket=key%size;
        temp=null;
        for (Entry entry:map[bucket])
        {
            if(entry.key==key)
            {
                temp=entry;
        
            }
            map[bucket].remove(temp);
        }
    }

    public static void main(String[] args){
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        obj.remove(2);
        System.out.println(obj.get(2));
        //obj.remove(1);
        
    }
}
