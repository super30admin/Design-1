class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    public int index(int key){
        return key % nodes.length;
    }
    
    public Node find(Node head, int key){
        Node prev=null;
        Node curr=head;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index]==null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
        
    }
    

    public int get(int key) {
        int index = index(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int index=index(key);
        if(nodes[index]==null){
            return;
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null){
            return;
        }
        else{
            prev.next=prev.next.next;
        }
    }
}