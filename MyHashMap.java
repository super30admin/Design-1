// Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
// Space complexity: O(n) - where n is the number of entries in HashMap 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    /** Initialize your data structure here. */
    public class Node{
        int val;
        int key;
        Node next;
        Node prev;
        Node(){}
        Node(int key, int val){this.key=key; this.val=val;} 
    }
    Node[] map;
    public MyHashMap() {
        map = new Node[1000];    
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=Integer.hashCode(key%1000);
        if(map[index]==null){
            map[index]= new Node(-1,-1);
        }
        Node curr=map[index];
        while(curr.next!=null && curr.next.key!=key){
            curr=curr.next;
        }
        if(curr.next==null){
            curr.next=new Node(key,value);
        }
        else{
            curr.next.val=value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=Integer.hashCode(key%1000);
        if(map[index]==null){
            return -1;
        }
        Node curr=map[index];
        while(curr.next!=null && curr.next.key!=key){
            System.out.println(curr.next.key);
            curr=curr.next;
        }
        if(curr.next!=null){
            return curr.next.val;
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=Integer.hashCode(key%1000);
        if(map[index]==null){
            return;
        }
        Node curr=map[index];
        while(curr.next!=null && curr.next.key!=key){
            curr=curr.next;
        }
        if(curr.next!=null){
            curr.next=curr.next.next;
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
