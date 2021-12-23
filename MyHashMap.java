package S30;

// Time Complexity : Get : O(1)  Put : O(1)  Remove : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;

public class MyHashMap {
    LinkedList<Entry>[] map;
    public static int SIZE = 769;
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % SIZE;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        } else {
            for(Entry entry: map[bucket]){
                if(entry.key == key){
                    entry.val = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }
    }

    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        if(entries == null)
            return -1;
        for(Entry entry: entries){
            if(entry.key == key)
                return entry.val;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        if(map[bucket] == null) return;
        else{
            for(Entry entry:map[bucket]){
                if(entry.key == key){
                    toRemove = entry;
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

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);
        hashMap.put(2, 3);
        hashMap.get(1);            // returns 2
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 4);          // update the existing value
        hashMap.get(2);            // returns 4
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}
