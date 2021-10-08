// Time Complexity : Best Case Insertion,Deletion,Search :O(1) - Constant time complexity
//                   Worst case : O(N) where N is the number of enteries if we get the same hashkey for all nodes and end up creating a big Linked List
// Space Complexity :O(N) where N is the number of enteries.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Null Pointer Exception in find method as used Curr.next instaed of Curr

class MyHashMap {

    //Creating a Node class for Linked List
    class Node{
        int key;
        int value;
        Node next;
        // Constructor mapping
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    //Declare a new Node
    Node[] hashMap;

    //Initialize the new Node with 10^4 as this is our constraint that we can maximum hit 10^4 calls
    public MyHashMap() {
        hashMap = new Node[10000];
    }

    //Creating our hashkey using a method below
    private int index(int key){
        return (Integer.hashCode(key))%10000;
    }

    //Helper method find to reduce redundancy in our code
    private Node find(int key){
        int hashKey = index(key);
// Creating head , prev and curr Node for iterating operations.
        Node head = hashMap[hashKey];
        Node prev = head; //pointer to keep track
        Node curr = head; //pointer to move forward

// Iterate till the end of the node in search of key
        while(curr!=null && curr.key!=key){
            //Key is not found and we traversed till the end
            prev = curr;
            curr = curr.next;
        }
        //key found so we return the node which is prev
        return prev;
    }
    public void put(int key, int value) {
        // generate hash key
        int hashKey = index(key);
        // compare hashkey and if null, return Node at -1,-1
        if(hashMap[hashKey] == null)
        {
            hashMap[hashKey] = new Node(-1,-1);
        }

        //find if the node with given key exists
        Node ptr = find(key);

        //Not found
        if(ptr.next == null){
            Node newEntry = new Node(key,value);
            ptr.next = newEntry;
        }
        //Found
        else{
            ptr.next.value = value;
        }
    }

    public int get(int key) {
        // generate hash key
        int hashKey = index(key);
        //find if the node with given key exists
        Node ptr = find(key);
       // compare hashkey and if it is null, return -1
        if(hashMap[hashKey] == null){
            return -1;
        }
        //Node Found
        if(ptr.next != null){
            return ptr.next.value;
        }
        //Node Not Found
        else{
            return -1;
        }
    }

    public void remove(int key) {
        // generate hash key
        int hashKey = index(key);
        //find if the node with given key exists
        Node ptr = find(key);
        // compare hashkey and if it is null, return
        if(hashMap[hashKey] == null){
            return;
        }

        //Node found - so point to next node to delete the Node
        if(ptr.next != null){
            ptr.next = ptr.next.next;
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