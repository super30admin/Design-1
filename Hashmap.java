// Time Complexity : O(n)+ for all cases
// Space Complexity : ~O(n) for all cases
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understood from the class, but coded the get and put on my own.remove was easy in this method as i didn't have to change any pointers.
//Had to do it another time using LinkedList to understand in a broader way


// Your code here along with comments explaining your approach

class MyHashMap {
    
    //Using the chaining approach, I am declaring array of Linked list nodes here to store at each index of array
    ListNode[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[1000000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //index to insert the key at is found using hashFunction
        int index = hashFunction(key);
        //We need to find if there is any element at that index in the array
        ListNode curr = find(index,key);
        //if there no element at that index or if there is no element/node with this "key", we insert a new node with given key and value;
        if(curr.next==null){
            curr.next = new ListNode(key,value);
        }
        // if there is a node with same value, then we simply update the value using curr.next;
        else{
            curr.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunction(key);
        ListNode curr = nodes[index];
        //At that index, we traverse until there is a null element or if there is a node with given key
        while(curr!=null){
            if(curr.key==key){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode curr = nodes[index];
        //At that index, we traverse until there is a null element or if there is a node with given key, if node is found we make the value of that equal to -1;
        while(curr!=null){
            if(curr.key==key){
                curr.key=-1;
            }
            curr = curr.next;
        }
    }
    
    private ListNode find(int key, int index){
        //At the given index, we see if there is a element oand insert a dummy node with -1,-1
        if(nodes[index]==null){
            return nodes[index] = new ListNode(-1,-1);
        }
        ListNode curr = nodes[index];
        //if node is present at that index, we traverse until we found next element as not null or next element with given key
        while(curr.next!=null && curr.next.key!=key){
            curr=curr.next;
        }
        // this could either be curr.next==null or curr.next.key=key;
        return curr;    
    }
    
    private int hashFunction(int key){
        //hash function to get the index;
        return key%nodes.length;
    }   
    
    //ListNode object
    private static class ListNode{
        int key, val;
        ListNode next;
        
        ListNode(int key,int val){
            this.key=key;
            this.val=val;
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
