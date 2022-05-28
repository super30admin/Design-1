//Time Complexity

// Add: on average case it is O(1)
// Remove: on average case it is O(1)
// Contains: on average case it is O(1)

// Space Complexity : O(S + U): where is the predifined buckets, and U the number of unique nodes in the list that stores numbers

// Did this code successfully run on Leetcode : Yes


import java.util.LinkedList;

public class MyHashSet {
    // variable size to store the size of the hashset.
        private int size;
    //Utilised Array of Linkedlist to store the values so that we can implement seperate Chaining
        private LinkedList[] buckets;

    public MyHashSet(){
        this.size = 100;
        this.buckets = new LinkedList[size];
        // Initialised the linkedList in the buckets
        for(int i=0; i < this.size; i++)
            buckets[i] = new LinkedList();
    }

    // Hashfunction that returns the modulo with respect to the size of the hashSet
    private int hashFunction(int key){
        return key % this.size;
    }

    public void add(int key){
        // The index is calculated from the hash function
        int index = this.hashFunction(key);
        // getting its respective list from the bucket
        LinkedList<Integer> list = this.buckets[index];
        // Checking if the list is empty. If the list is empty then we add key to the list
        if(list.size() == 0){
            list.add(key);
        }
        // if the list is not empty then we check if they key is already present. If the key doesn't exist then we add it to the list
        else{
            if(!list.contains(key)){
                list.add(key);
            }
        }
    }

    public void remove(int key){
        // The index is calculated from the hash function
        int index = this.hashFunction(key);
        // getting its respective list from the bucket
        LinkedList<Integer> list = this.buckets[index];
        // If the list contains the key then we remove it from the list
        if(list.contains(key)){
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key){
        // The index is calculated from the hash function
        int index = this.hashFunction(key);
        // // getting its respective list from the bucket based on index
        LinkedList<Integer> list = this.buckets[index];
        // returns true of the key exists else it returns false.
        return list.contains(key);
    }


    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2 ));

    }

}
