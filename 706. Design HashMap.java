class MyHashMap {
    static class ListNode {
        int key, val;
        ListNode next;        
        ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }    
    ListNode[] map;
    public MyHashMap() {
        map = new ListNode[10000];
    }
    ListNode search(int key){
        int hash = key%10000;
        ListNode x=map[hash];
        if(x==null) return null;
        while(x!=null && x.key!=key){
            x = x.next;
        }
        return x;
    }   

    public void put(int key, int value) {
        //map[key]=value+1;
        ListNode x = search(key);
        if(x!=null) x.val=value;
        else map[key%10000]=new ListNode(key,value,map[key%10000]);
    }
    
    public int get(int key) {
        // return map[key]-1;
        ListNode x=search(key);
        if(x==null) return -1;
        return x.val;
    }

    public void remove(int key) {
        int hash = key%10000;
        ListNode x=map[hash];
        if(x==null) return;
        if(x.key==key) map[hash]=map[hash].next;
        while(x.next!=null){
            if(x.next.key==key){
                x.next = x.next.next;
                return;
            } else {
                x = x.next;                
            }
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