class MyHashMap {
    
    class Node{
        
        int key,val;
        Node next;
        
        Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    int buckets;;
    Node[] nodes;

    public MyHashMap() {
        
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    //Time Complexity : O(1)
    public int getHash(int key)
    {
        return Integer.hashCode(key)%buckets;
    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        
        while(curr!=null && curr.key!=key)
        {
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void put(int key, int value) {
        
        int index = getHash(key);
        if(nodes[index]==null)
        {
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(nodes[index],key);
        
        if(prev.next == null)
        {
            prev.next = new Node(key,value);
        }
        else
        {
            prev.next.val = value;
        }
    }
    
    //Time Complexity: O(n)
    //Space Complexity:O(1)
    public int get(int key) {
        
        int index = getHash(key);
        if(nodes[index]==null)
        {
            return -1;
        }
        
        Node prev = find(nodes[index],key);
        
        if(prev.next==null)
        {
            return -1;
        }
        
        return prev.next.val;
        
    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void remove(int key) {
    
        int index = getHash(key);
        if(nodes[index] == null)
        {
            return;
        }
        
        Node prev = find(nodes[index],key);
        
        if(prev.next==null)
        {
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