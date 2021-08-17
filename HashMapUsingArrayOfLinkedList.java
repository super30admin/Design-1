//Time complexity: O(1), Worst case O(n)
//Space complexity: O(1)
class HashMapUsingArrayOfLinkedList
{
    Node[] nodes;
    /** Initialize your data structure here. */
    public HashMapUsingArrayOfLinkedList() {
        nodes = new Node[100000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        Node node = find(index, key);

        if(node.next == null) {
            node.next = new Node(key, value);
        }
        else {
            node.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //return the value as position key
    public int get(int key) {
        int index = getIndex(key);
        Node node = find(index, key);
        
        if(node.next == null) {
            return -1;
        }
        else {
            return node.next.value;
        }

    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    //store the element at position key as -1;
    public void remove(int key) {
        int index = getIndex(key);
        Node node = find(index, key);

        if(node.next != null) {
            node.next = node.next.next;
        }
    }

    //we will use the hasing function of key to generate a hashed key for our array.
    public int getIndex(int key) {
        return Integer.hashing(key)%nodes.length;
    }

    //We will find the element for a key.
    public Node find(int index, int key) {
        //If there is no value at the index position, we will create a new Node with key as -1 and value as -1;
        if(nodes[index] == null) {
            return nodes[index] = new Node(-1, -1);
        }

        Node node = nodes[index];
        //traverse through the array until the key matches and will return the node.
        while(node.next != null && node.next.key != key) {
            node = node.next;
        }
        return node;
    }

    public static void main(String args[]) {
        HashMapUsingArray myHashMap = new HashMapUsingArray();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}