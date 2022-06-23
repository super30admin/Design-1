//Paypal interview 
//Time complexity and space complexity = O(1)
class MyHashMap {
    class Node{
    int key;
    int value;
    Node next;
        //Initaializing the key and value using constructor
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
    Node[] nodes;//need to have an array i.e. to initalize the primary array nodes
    int buckets;//initalize buckets
    //Time complexity = O(1)
    private int getBucket(int key){
        //return Integer.hashCode(key) % buckets;
        return key % buckets;//To find primary key value by MOD operation
    }
    //Time complexity = O(1)
    private Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        //To search their must be current is not null and current key not equal to key
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    //Time complexity = O(1)
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    //Time complexity = O(1)
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index]==null){
            //From Linked List in the range from starting index value to ending index value
            nodes[index] = new Node(-1,-1);
        }
        Node prev =find(nodes[index],key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        } else{
            prev.next.value = value;
        }
        
    }
    //Time complexity = O(1)
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){
            return-1;
        } 
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }
    //time complexity = O(1)
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){
            return;
        }
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */