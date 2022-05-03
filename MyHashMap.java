// Time Complexity : With a perfect hashing function the average time complexity is O(1) for get, put and remove
// Space Complexity : O(1) but constructor space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Problem 1
class MyHashMap {
    
    //Define a node
    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    //Container to store the values
    Node[] storage;
    int firstHashing;
    
    public MyHashMap() {
        this.firstHashing=10000;
        this.storage=new Node[firstHashing];
    }
    
    public int hashing(int key){
        return key%firstHashing;
    }
    
    public void put(int key, int value) {
        if(storage[hashing(key)]==null){
            //Create a dummy node in the beginning to handle remove functionality when there is only one node in a particular hash index and there won't be any prev node
            storage[hashing(key)]=new Node(-1, -1);
        }
        Node prev=findPrevNode(key, storage[hashing(key)]);
        if(prev.next==null)
            prev.next=new Node(key, value);
        else
            prev.next.val=value;
    }
    
    public int get(int key) {
        if(storage[hashing(key)]==null){
            return -1;
        }
        Node prev=findPrevNode(key, storage[hashing(key)]);
        if(prev.next==null)
            return -1;
        else
            return prev.next.val;
    }
    
    public void remove(int key) {
        if(storage[hashing(key)]==null){
            return;
        }
        Node prev=findPrevNode(key, storage[hashing(key)]);
        if(prev.next==null)
            return;
        else
            prev.next=prev.next.next;
    }
    //common function to find prev node since all get, put and remove methods needs to traverse the linked list
    public Node findPrevNode(int key, Node node){
        Node prev=storage[hashing(key)];
        while(node!=null){
            if(node.key==key){
                return prev;
            }
            else{
                prev=node;
                node=node.next;
            }
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
