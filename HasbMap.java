// Time Complexity : Has a complexity of O(1) on average but since I'm using a linkedlist to avoid collision the traversal it's a little more
// Space Complexity : O(n) where n is the number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    class HashNode {
        int key;
        int value;
        HashNode next;
        HashNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    //Created a array of size 1000 instad of 1000000 to save space,
    //This can go even lower than 1000, I tried with 100 but was slower than with 1000 due to collisions
    int size = 1000;

    //Made the array type of Object so I can key value using Linkedlist to support collision
    LinkedList<HashNode>[] hashArray = new LinkedList[size];
    
    //Fill initial array to null to indicate there's no LinkedList
    public MyHashMap() {
        Arrays.fill(hashArray, null);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //Get index address to put the element
        int index = key % size;
        if(hashArray[index] == null) {
            hashArray[index] = new LinkedList<HashNode>();
        }
        
        //If a some number already exisit then this number is colliding
        if (get(key) != -1) {
            ListIterator<HashNode> itr = hashArray[index].listIterator();
            while(itr.hasNext()) {
                HashNode v = itr.next();
                //If same key exists overwrite the old one
                if (v.key == key) {
                    v.value = value;
                    return;
                }
            }
        }
        //Add a new node in the LinkedList with key value object of type HashNode
        hashArray[index].add(new HashNode(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % size;
        //The index is empty
        if (hashArray[index] == null) return -1;

        ListIterator<HashNode> itr = hashArray[index].listIterator();
        while(itr.hasNext()) {
            HashNode v = itr.next();
            //If the key exisit in the LinkedList then return the value
            if (v.key == key) return v.value;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % size;

        if (hashArray[index] == null) return;

        ListIterator<HashNode> itr = hashArray[index].listIterator();

        while(itr.hasNext()) {
            HashNode v = itr.next();
            if (v.key == key) itr.remove();
        }
    }
}
