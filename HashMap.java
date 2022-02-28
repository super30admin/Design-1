// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
package HashMap;

import java.util.LinkedList;

class MyHashMap {

    // Implementing array of a linkelist
    LinkedList<Entry>[] map;
    public static int SIZE = 769;

    // creating bucket
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    // Get the hashvalue; If map[hashvalue] is null create a LL and add the value
    //Or else check for entries if found the similar key replace value or create a new entry
    public void put(int key, int value) {
        int bucket = key % SIZE;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key,value));
        }
        else{
            for(Entry entry: map[bucket]){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }

            map[bucket].add(new Entry(key,value));
        }
    }

    // Get the hashvalue; If map[hashvalue] is null return -1
    // Search for entries is similar key found return the value ,  if not return -1
    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];

        if(entries== null) return -1;

        for(Entry entry: entries){
            if(entry.key == key)
                return entry.value;

        }
        return -1;
    }

    // Get the hashvalue; If map[hashvalue] is null return
    // Search for entries if similar key found get the value in temp variable and remove that element from LL
    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        if(map[bucket] == null) return;
        else{
            for(Entry entry: map[bucket]){
                if(entry.key== key){
                    toRemove = entry;
                }
            }
            if( toRemove == null) return;
            map[bucket].remove(toRemove);
        }
    }
}

class Entry{
    public int key;
    public int value;

    public Entry(int key, int value){
        this.key= key;
        this.value = value;
    }
}

