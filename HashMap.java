//With Linear Chaning
//TC: Auxilary TC Size of the linked List, here 100 nodes can be at max to the Linked List so O(1);
//SC: O(1) 10^4 soze given auxilary LinkedList length will be space Complexity;
//If running in Leetcode: Yes, for most of the use-cases;

class MyHashMap {

    class Node{
        int key, value;
        Node next;
       public Node(int key, int value){
           this.key=key;
           this.value=value;
       }
   }
    
    Node[] nodes; 
    //array of Node class naming nodes as a reference for our Node Classes();
    int buckets;
    
    private int getHash(int key){
        return key%buckets;
    }
    
    private Node find(Node node, int key){
        Node prev=node;
        Node curr=node.next;
        if(curr!=null && prev.next.key!=key)
            //&& opertaion is imp as it checks if curr.val is null first and then                   //checks if the value we need is found or not;
        {
           prev=curr;
            curr=curr.next;
        }  
        return prev;
    }
    
    public MyHashMap() {
        buckets=10000;
        nodes=new Node[buckets];
        //Each of Type Node class with key, value, next;
        //Array of all the Node class Array each who's type is of class Node;
    }
    
    public void put(int key, int value) {
        int bucket=getHash(key);
        if(nodes[bucket]==null){
             nodes[bucket]=new Node(-1,-1);
            //so you have to create a key and a value since node is null no key or                  value will be existing here;
            // nodes[bucket].key=-1; 
            // nodes[bucket].value=-1;
            // nodes[bucket].next=null;
        }
            Node prev=find(nodes[bucket],key);
            if(prev.next==null){
                prev.next=new Node(key,value);
            }else{
                prev.next.value=value;
            }   
    }
    
    public int get(int key) {
        int bucket=getHash(key);
        if(nodes[bucket]==null){
            return -1;
        }
        Node prev=find(nodes[bucket],key);
        if(prev.next==null){
            return -1;
        }
        //System.out.println(prev.next.value);
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket=getHash(key);
        if(nodes[bucket]==null){
            return;
        }
        Node prev=find(nodes[bucket],key);
        if(prev.next==null){
            return;
        }
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
