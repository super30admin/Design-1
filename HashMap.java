//Time complexity: O(N/K) where N is number of possible keys and K is number of buckets declared (9973 in this case)
//Space complexity: O(K+M) where K is pre-defined buckets(9973) and M is number of unique key,value pairs inserted 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Got 2 different solutions one with space optimized and the other with time optimized. Didnot optimize to O(1) time complexity for access

// Your code here along with comments explaining your approach
/*
Used array of linkedlists to design hash map. Hash code would be integer%bucket length. 
*/
class MyHashMap {

    final ListNode[] map = new ListNode[9973];
    
    /** value will always be non-negative. */
    public void put(int key, int value) {

       // Calculate Hash 
       int i = this.calcHash(key);
       // If null, create dummy head
       if(map[i] == null) 
           map[i] = new ListNode(-1, -1);
       // Get link to the node whose next is either null or matches current key
        ListNode prev = find(map[i], key);

        //If null, insert next
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        // If not null, replace val with the value
        else
            prev.next.val = value;       
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int i = calcHash(key);

        //Key not found
        if(map[i] == null)
            return -1;

        // Get link to the node
        ListNode node = find(map[i],key);

        //If null, return -1, else return val
        return node.next == null?-1: node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         int i = calcHash(key);
         if(map[i] == null)
            return;

         // Get link to node, remove link between curr and next
         ListNode prev = find(map[i],key);
         if(prev.next != null) 
             prev.next = prev.next.next;
    }
    
    int calcHash(int key) {
        // Returns uncomplicated primitive integer value% array length
        return Integer.hashCode(key)%map.length;
    }
    
    ListNode find(ListNode node,int key) {
        ListNode prev = null;

        /*
        Loop until key is found or node is null 
        Return node which has next to be "required node"
        */
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    static class ListNode {
        ListNode next;
        int key, val;
    
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

// Second approach (Because permitted values are [0,1000000]), allocated array of size 1000001
class MyHashMap {

    /** Initialize your data structure here. */
    int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */