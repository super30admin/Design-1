// Time Complexity : O(1) ; Worst case time complexity is O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class MyHashSet {

    //LinkedList is used to store elements that has same hash value
    class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            next = null;
        }
    }
    
    //Max Array Size
    int size = 1000;
    Node[] arr;
    //counter is used to keep track of number of elements
    int counter;
    public MyHashSet() {
        arr = new Node[size];
        counter = 0;
    }
    
    public void add(int key) {
        //First find hash value for the key
        int index = hashFunction(key);
        Node node = new Node(key);
        //If there is a linkedlist already in arr then make current node as head and link existing nodes to it
         if(arr[index] != null) {
            Node head = arr[index];
            node.next = head;    
        }
        arr[index] = node;
        counter++;
    }
    
    public void remove(int key) {
        //First check if arr contains key or not
        if(contains(key)){
            int index = hashFunction(key);
            Node cur = arr[index];
            Node prev = null;
            //Traverse the list till you find the node that contains the key
            while(cur != null) {
                if(cur.key == key) {
                    counter--;
                    //Remove that particular node form the list
                    if(cur == arr[index]) {
                        arr[index] = cur.next;
                    } else {
                        prev.next = cur.next;
                    }   
                }
                prev = cur;
                cur = cur.next;
        }
        }
    }
    
    public boolean contains(int key) {
        int index = hashFunction(key);
        Node head = arr[index];
        //Traverse through the list if key exists in the linkedlist
        while(head != null){
            if(head.key == key)
                return true;
            head = head.next;
        }
        return false;
    }
    
    public int hashFunction(int key){
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */