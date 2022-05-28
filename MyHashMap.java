// Time Complexity : O(1) for put(), get() and remove()
// Space Complexity : O(n) for the array of nodes, O(m) for the Linked List
// Did this code successfully run on Leetcode : Yes

public class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    Node nodes[];

    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    public int hash(int key)
    {
        return key%10000;
    }
    
    private Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }
        
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = key%10000;
        if(nodes[index] == null)
            return -1;
        if(find(nodes[index],key).next == null)
            return -1;
        else
            return find(nodes[index],key).next.val;
    }
    
    public void remove(int key) {
        int index = key%10000;
        if(nodes[index] == null)
            return;
        Node prev = find(nodes[index],key);
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;            
    }    

    public static void main(String[] args)
    {
        MyHashMap mhm = new MyHashMap();
        mhm.put(1, 100);
        mhm.put(1, 200);
        mhm.put(1,300);
        System.out.println(mhm.get(5));
        System.out.println(mhm.get(3));
        mhm.remove(3);
    }
}
