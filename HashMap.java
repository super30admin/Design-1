// Time Complexity : Assuming that hashing function is equally distributed = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couple of run time errors.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class MyHashMap {

    /** Initialize your data structure here. */
    List<Container> mainList;
    int capacity = 16;

    public MyHashMap() {
        mainList = new ArrayList<>();
        for(int i=0; i<=capacity; i++){
            mainList.add(i, new Container());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int position = new Integer(key).hashCode();
        position = position%capacity;

        Container myContainer = mainList.get(position);

        if(myContainer == null){
            Container newContainer = new Container();
            newContainer.put(key,value);
            mainList.add(position,newContainer);
        }else{
            myContainer.put(key,value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int position = (new Integer(key).hashCode())%capacity;
        Container myContainer = mainList.get(position);

        if(myContainer == null){
            return -1;
        }else{
            return myContainer.get(key);
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int position = (new Integer(key).hashCode())%capacity;
        Container myContainer = mainList.get(position);

        if(myContainer == null){
            return;
        }else{
            myContainer.remove(key);
        }
    }

    static class Entry{
        int first;
        int second;

        public Entry(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    class Container{
        List<Entry> entries = new LinkedList<>();

        public int get(int key){
            for(MyHashMap.Entry entry: entries){
                if(entry.first == key){
                    return entry.second;
                }
            }
            return -1;
        }

        public void put(int key, int value){
            for(MyHashMap.Entry entry: entries){
                if(entry.first == key){
                    entry.second = value;
                    return;
                }
            }

            MyHashMap.Entry newEntry = new MyHashMap.Entry(key, value);
            entries.add(newEntry);
        }

        public void remove(int key){
            MyHashMap.Entry entryToBeRemoved = null;
            for(MyHashMap.Entry entry: entries){
                if(entry.first == key){
                    entryToBeRemoved = entry;
                }
            }
            if (entryToBeRemoved != null){
                entries.remove(entryToBeRemoved);
            }
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
