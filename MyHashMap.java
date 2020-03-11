// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had already done this program on Leetocde before, so basically none


// Your code here along with comments explaining your approach

class MyHashMap {

	// Array of ListNodes
    ListNode[] nodes= new ListNode[100000];
    
    class ListNode{
        int key, val;
        ListNode next;
        
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    // Function index to generate hashCode of input key
    int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    /* If there is no ListNode already present in the ListNode array for given key,  create one
    / if there exists one, check if there are any node attached, if there is not, craete one for given key and value, else simply replace */
    public void put(int key, int value) {
        int i = index(key);
        if(nodes[i] == null){
            nodes[i] = new ListNode(-1,-1);
        }
        
        ListNode prev = find(nodes[i], key);
        
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }    
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    /* Find an index for given key. Check if there exists a ListNode for given index, if no, return -1
       If yes, find for particular key in the ListNode array. If there exists a ListNode for given key, return it's value or return -1 */
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null){
            return -1;
        }
        
        ListNode node = find(nodes[i], key);
        return (node.next == null ? -1 : node.next.val);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    /* Find an index for given key. check in the ListNode array if for given index, there exists any node.
    	If it does, check for the key. if the node with same key is found, delete it. else return*/
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null){
            return;
        }
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    /*Finds a node in given ListNode array of node buckets for given key. First, get the node bucket to search for.
    	Then in that bucket, search for the key. If found, return the ListNode, else return null*/
    public ListNode find(ListNode bucket, int key){
        ListNode node = bucket;
        ListNode prev = null;
        while(node!=null && node.key!=key){
            prev = node;
            node = node.next;
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