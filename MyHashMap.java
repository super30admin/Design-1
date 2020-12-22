// Time Complexity : The time complexities for put, get and remove operations is O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    LinkedList<Node>[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {

        map = new LinkedList[1000]; // An array of length 1000 which stores a Linked List each of length 1000

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int index = key % map.length; // Array index is determined

        LinkedList<Node> list = map[index];

        // creates a new Linked List if its the first element in the list
        if(list == null){
            map[index] = new LinkedList<Node>();
            map[index].add(new Node(key,value));
            return;
        }

        // Iterates through the List to store the element
        for(int i=0;i<list.size();i++){

            // If the key is already present, it replaces the current value with the new value
            if(list.get(i).key == key){
                list.get(i).value = value;
                return;
            }
        }

        // If the key is not present, a new Node is created and added
        list.add(new Node(key,value));

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int index = key % map.length; // Array index is determined

        LinkedList<Node> list = map[index];

        // returns -1 if the list is empty
        if(list == null){
            return -1;
        }

        // Iterates through the List to retrieve the value
        for(int i=0;i<list.size();i++){

            // If the key is found, its value is returned
            if(list.get(i).key == key){
                return list.get(i).value;
            }
        }

        // If the key is not found, -1 is returned
        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int index = key % map.length; // Array index is determined

        LinkedList<Node> list = map[index];

        // returned if the list is empty
        if(list == null){
            return;
        }

        // Iterates through the List to remove the value
        for(int i=0;i<list.size();i++){

            // If the key is found, the (key,value) pair is removed
            if(list.get(i).key == key){
                list.remove(i);
            }
        }

    }
}

// Node class which stores the key and value
public class Node{

    int key;
    int value;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */