import java.util.*;
class MyHashMap {

    /** Initialize your data structure here. */
    int [] a ;
    public MyHashMap() {
        a = new int[1000001];
        Arrays.fill(a,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        a[key]=value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return a[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        a[key]=-1;
    }

    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        myHashMap.get(1);
        myHashMap.get(2);
        myHashMap.get(3);
        myHashMap.put(2,1);
        myHashMap.get(2);
        myHashMap.remove(2);
        myHashMap.get(2);
    }
}
