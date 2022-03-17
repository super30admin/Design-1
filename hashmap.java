// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] nodes;
    private int buckets; 
    
    public MyHashMap() {
        buckets = 10000 ;
        nodes = new Node[buckets];
            
    }

    private int hash(int key){
        return key%buckets;
    }
    public Node find(Node head,int key){
        //dummy node to handle first node case
        Node prev =  null;
        Node curr = head;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if(nodes[index] == null){
            nodes[index] =  new Node(-1,-1); // dummy node creation
        }
        Node prev = find(nodes[index],key);
        //prev at end of LL
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{ //prev not in the end
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if(nodes[index] == null) return -1;
        Node prev = find(nodes[index],key);
        if(prev.next == null )return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(nodes[index] == null) return;
        Node prev = find(nodes[index],key);
        if(prev.next == null )return;
        prev.next = prev.next.next;
    }

    public static void main(String args[]) 
    { 
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        int param_2 = obj.get(1);
        obj.remove(1);
        System.out.println("get index of 1" + param_2);
    }
}