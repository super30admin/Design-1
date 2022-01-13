class MyHashMap {
    class Node{
      int key;
    int value;
        Node next;
    public Node(int key, int value){
        this.key= key;
        this.value = value;
        }  
    }
    Node[] nodes;
    int buckets= 10000;
    public MyHashMap() {
         nodes = new Node [buckets];
    }
    
    private int index(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find(int key, Node node){
        Node prev= null;
        Node curr = node;
        while(curr != null && curr.key != key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] ==null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(key, nodes[index]);
        if (prev.next== null){
            prev.next = new Node (key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index= index(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
       int index= index(key);
        if(nodes[index]==null){
            return ;
        }
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return ;
        prev.next= prev.next.next;
    }
}
