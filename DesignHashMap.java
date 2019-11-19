/*
The put, get and the remove methods time complexity is O(1).

Here, the idea is to have an array of certain length. When we have a key and value, we compute the hashcode of the key. Find the
position of the hashvalue in array and place there. But, what if we have multiple keys with same hashcode. For that we create a linked
list from that position of array where if the hashcode is same we append the new value to the end of the list.

Yes, the solution passed all the test cases in leetcode.
 */
class MyHashMap {

    Node[] arr;
    int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[100000];
        size = 100000;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashvalue = key%size;
        Node root = arr[hashvalue];
        if(root==null){
            arr[hashvalue] = new Node(key,value);
        }
        else{
            Node prev = null;
            while(root!=null){
                if(root.key == key){
                    root.value = value;
                    return;
                }
                prev = root;
                root = root.next;
            }
            prev.next = new Node(key,value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashvalue = key%size;
        Node root = arr[hashvalue];

        while(root!=null){
            if(root.key == key){
                return root.value;
            }
            root = root.next;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashvalue = key%size;
        Node root = arr[hashvalue];
        if(root==null || (root.key==key && root.next == null)){
            arr[hashvalue] = null;
            return;
        }
        Node prev = root;
        root = root.next;
        while(root!=null){
            if(root.key == key){
                prev.next = root.next;
                return;
            }
            prev = root;
            root = root.next;
        }
    }
}

class Node{
    int key;
    int value;
    Node next;

    Node(int key,int value){
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