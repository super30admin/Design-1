class MyHashMap {

    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
    }
    
    /** val will always be non-negative. */
    public void put(int key, int val) {
        int hash = getHash(key);
        if(nodes[hash]==null){
            nodes[hash]= new ListNode(-1,0);
        }
        ListNode prev=findelement(nodes[hash],key);
        if(prev.next==null){
            prev.next= new ListNode(key,val);
        }
        else{
            prev.next.val=val;
        }
    }
    
    /** Returns the val to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        if (nodes[hash]==null){
            return -1;
        }
        ListNode prev= findelement(nodes[hash],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified val key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash= getHash(key);
        if(nodes[hash]==null){
            return ;
        }
        ListNode prev = findelement(nodes[hash],key);
        if(prev.next==null){
            return ;
        }
        else{
            prev.next=prev.next.next;
        }
    }
    
    public int getHash(int key){
        return key % nodes.length;
    }
    public ListNode findelement(ListNode head, int key){
        ListNode Node= head, prev=null;
        while(Node!=null&&Node.key!=key){
            prev=Node;
            Node=Node.next;
        }
        return prev;
    }
}

class ListNode{
    public int key, val;
    public ListNode next;
    public ListNode(int k, int v){
        this.key = k;
        this.val = v;
    }
}