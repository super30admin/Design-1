// Time Complexity : O(n) where n is the list of all possible values
// Space Complexity : O(m) where m is the number of buckets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    ListNode[] nodes;
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    public void put(int key, int value) {
        int index = hashing(key);
        ListNode prev = find(index,key);
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        else
            prev.next.val = value;
    }
    
    public int get(int key) {
        int index = hashing(key);
        if(nodes[index] == null)
            return -1;
        else{
            ListNode newNode = find(index,key);
            if(newNode.next == null)
                return -1;
            else
                return newNode.next.val;
        }
    }
    
    public void remove(int key) {
        int index = hashing(key);
        if(nodes[index] == null)
            return;
        else{
            ListNode prevNode = find(index,key);
            if(prevNode.next != null)
                prevNode.next = prevNode.next.next;                
        }
    }
    
    
    private ListNode find(int index,int key){
        if(nodes[index] == null)
            return nodes[index] = new ListNode(-1,-1);
        ListNode prev = nodes[index];
        while(prev.next !=null && prev.next.key != key)
            prev = prev.next;
        return prev;
    }
    
    
    private int hashing(int key){
        return key%nodes.length;
    }
    private static class ListNode{
        int key,val;
        ListNode next;
        ListNode(int key,int val){
            this.key = key;
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
