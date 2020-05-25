// Time Complexity : O(n) n= number of key val pairs
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
public class MyHashMap {
    Node[] nodes = new Node[10000];
    class Node{
        int key, val;
        Node next;
        Node(int k,int v){
            key=k;
            val=v;
            next=null;
        }
    }

     /** Initialize your data structure here. */
     public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = getHash(key);
        if(nodes[h]==null){
            nodes[h]=new Node(-1,-1); // creating a placeholder
        }
        Node prev=findNode(nodes[h], key);
        if(prev.next==null){
            prev.next=new Node(key,value) //add it
        } else {
            prev.next.val=value; //update value if the key exists
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h=getHash(key);
        if(nodes[h]==null) return -1;
        Node prev=findNode(nodes[h],key); //returns a pointer to the previous of the node needed
        if(prev.next==null) return -1;
        else return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h=getHash(key);
        if(nodes[h]==null) return;
        Node prev=findNode(nodes[h], key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
    }

    private int getHash(int key){
        return Integer.hashCode(key)%nodes.length;
    }

    private Node findNode(Node head,int key){
        Node prev=null, cur=head;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
}