// Time Complexity : O(1)
// Space Complexity : O(n)
// executed successfully on Leetcode  - 706
class MyHashMap {


    class Node{
        int value;
        int key;
        Node next;
       public Node(int key,int value){
            this.key=key;
            this.value=value;
        }

    }
    int buckets;
    Node[] nodes;

    private int getKey(int key){
        return Integer.hashCode(key)%buckets;
    }
    private Node find(Node node,int key){
        Node prev=node;
        Node curr=prev.next;
        while(curr!=null&&prev.next.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public MyHashMap() {
        buckets=10000;
        nodes=new Node[buckets];
    }

    public void put(int key, int value) {
        int index=getKey(key);
        if(nodes[index]==null)
            nodes[index]=new Node(-1,-1);

        Node prev=find(nodes[index],key);
            if(prev.next==null)
                prev.next=new Node(key,value);
        else
            prev.next.value=value;

    }

    public int get(int key) {
        int index=getKey(key);
        if(nodes[index]==null)
            return -1;
        else{
             Node prev=find(nodes[index],key);
            if(prev.next==null)
                return -1;
            else
                return prev.next.value;
        }


    }

    public void remove(int key) {
        int index=getKey(key);
        if(nodes[index]==null)
            return;
        else{
             Node prev=find(nodes[index],key);
            if(prev.next==null)
                return;
            else
               prev.next=prev.next.next;
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
