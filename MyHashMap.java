
/* Time Complexity : find : O(length of list), put O(length of list), get: O(length of list) remove (length of list)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No

*/
class MyHashMap {
    Node[] storage;
    int buckets;
    class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public MyHashMap() {
    buckets = 1000;
    storage = new Node[buckets];       
    }
    
    public Node findNode(Node node, int key){
        Node prev = node;
        Node cur = node.next;
        while(cur != null && prev.next.key != key){
            prev = cur;
            cur  = cur.next;
        }
        return prev;
    }
    
    int getbucket(int val){
        return val % buckets;
    }

    // int bucketItems(val){
    //     retrun val/bucketItems;
    // }
    
    public void put(int key, int value) {
        int getbucket = getbucket(key);
        if(storage[getbucket] == null){
            storage[getbucket] = new Node(-1,-1); 
        }
        Node prev = findNode(storage[getbucket], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int getbucket = getbucket(key);
        if(storage[getbucket] == null){
            storage[getbucket] = new Node(-1,-1); 
        }
        Node prev = findNode(storage[getbucket], key);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int getbucket = getbucket(key);
        if(storage[getbucket] == null){
            storage[getbucket] = new Node(-1,-1); 
        }
        Node prev = findNode(storage[getbucket], key);
        if(prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
        
    }
}
