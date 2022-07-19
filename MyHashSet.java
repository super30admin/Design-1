import java.util.Iterator;
import java.util.LinkedList;

class MyHashSet {

    /*
     * Time Complexity:: add() - O(1), remove - O(1), contains - O(1)
     * Space Complexity:: O(n) where n is the maximum number of elements
     * in the array. 
     * 
     * The code ran successfully on leetcode.
     */
    LinkedList<Integer>[] arr;
    // Initialize an array of LinkedLists 
    public MyHashSet() {
        arr = new LinkedList[100];
        for(int i=0; i<100; i++)
            arr[i] = new LinkedList<Integer>();
    }
    
    // Use modulus as hash function to determine the index of key
    public void add(int key) {
        int index = key%100;
        if (!contains(key))
            arr[index].add(key);
    }
    
    public void remove(int key) {
        int index = key%100;
        Iterator<Integer> itr = arr[index].iterator();
        while(itr.hasNext()) {
            if (itr.next() == key) {
                itr.remove();
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        int index = key%100;
        return arr[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */