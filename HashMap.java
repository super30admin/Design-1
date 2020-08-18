// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this: Getting the time complexity. Actually I am not sure
//                                          if it is O(n) for most of the operation?


// Your code here along with comments explaining your approach

class ListNode{
    int key, val;
    ListNode next;

    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap{
    ListNode[] nodes = null;

    public MyHashMap() {
        new ListNode[10000];
    }

    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val; 
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.val = value;
        } 
    }

     public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }

    private int getIndex(int key){
        return Integer.hashCode(key) % nodes.length; 
    }

    private ListNode findElement(int index, int key) {
        if(nodes[index] == null){
            nodes[index] = new ListNode(-1,-1);
            return nodes[index];
        }
        ListNode prev = nodes[index];
        while(prev.next != null && prev.next.key != key ){
            prev = prev.next;
        }
        return prev;
    }

}
