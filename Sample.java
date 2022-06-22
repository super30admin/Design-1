// Time Complexity :
//     Push: O(N)
//     Pop: O(N)
//     Get: O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



// Initially create a node containing key, value and next
// Initialize the array of nodes with size of 10**4
// For push, find hash value of key using (key%size of array) and check the value of primary array at that index.
// If value at index (key%size) is null then Initialize a linked list with dummy value (-1, -1) 
// Then Insert value at the end of the list, if value already present find it's previous node and update the value to the current value
// For Pop, first find primary index. If value at that index is null then return;
// Else, We have to check in the linked list -> If we find any key in the linked list remove that using prev = prev.next.next else return
// For get, Similarlly like the above two first find the index if index value is null then return -1;
// Else check in the linked list, If we find key using find function return the associated value else return -1;
class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    int bucket;
    
    public MyHashMap() {
        bucket = 1000;
        nodes = new Node[bucket];
    }
    
     public int getBucket(int key) {
        return key%bucket;
    }
    
    public Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.key!=key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        } 
        
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            return -1;
        }
        
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            return;
        }
        
        Node prev = find(nodes[index], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
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
