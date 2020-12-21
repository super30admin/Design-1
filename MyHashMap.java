// Time Complexity : O(1), for put, get and remove operations
// Space Complexity : O(1000) or can say constant space O(1) since we are using list of size 1000
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Have some doubts about time complexity



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//Pair class of generic type to save (key,value)pair 
class Pair<U,V>{
     U first;
     V second;
     Pair(U first,V second){
         this.first = first;
         this.second = second;
     }
}

// Bucket class is used mainly to avoid collisions in the hashmap 
class Bucket{
    List<Pair<Integer,Integer>> bucket;

    Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();

    }

    //get function
    public Integer get(Integer key){
        for (Pair<Integer,Integer> pair : bucket){
            if (pair.first.equals(key)){
                return pair.second;
            }
        }
        return -1;
    }

    //update function
    public void update(Integer key, Integer value){
        boolean found = false;
        for (Pair<Integer,Integer> pair : bucket){
            if (pair.first.equals(key)){
                found= true;
                pair.second = value;
            }
        }
        if(!found){
            bucket.add(new Pair<Integer, Integer>(key,value));
        }

    }
    //remove function
    public void remove(Integer key){
        for (Pair<Integer,Integer> pair : bucket){
            if (pair.first.equals(key)){
                bucket.remove(pair);
                return;
            }
        }
    }
}
public class MyHashMap {
    List<Bucket> HashTable; 
    int modulo ;

    MyHashMap(){
        this.HashTable = new ArrayList<Bucket>(); //HashTable would be a list of type Bucket
        this.modulo = 1000; // assuming the size to be of 1000 elements
        for (int i =0; i < 1000;i++){
            HashTable.add(new Bucket());
        }
    }
    /** value will always be non-negative. */
    public void put(int key, int value)
    {
        int position = key % modulo; // 
        HashTable.get(position).update(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key)
    {
        int position = key % modulo;
        return HashTable.get(position).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key)
    {
        int position = key %modulo;
        HashTable.get(position).remove(key);
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(10,1);
        hm.put(10,4);
        hm.put(20,5);


        System.out.println(hm.get(10));

        System.out.println(hm.get(20));

        hm.remove(20);
        System.out.println(hm.get(20));
    }
}

