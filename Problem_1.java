class MyHashMap {
    ListNode head;
    ListNode tail;

    /** Initialize your data structure here. */
    class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int x,int y){
            key=x;
            val=y;
        }
    }

    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode p=head,pre=null,add=new ListNode(key,value);
        if(p==null)
            head=add;
        else{
            while(p!=null)
            {
                pre=p;
                if(p.key==key){
                    p.val=value;
                    return;
                }
                p=p.next;
            }
            pre.next=add;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode p=head;
        while(p!=null){
            if(p.key==key) return p.val;
            p=p.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode p=head,del=null,pre=null;
        if(p==null) return;
        while(p!=null){
            if(p.key==key) {
                del=p;
                break;
            }
            pre=p;
            p=p.next;
        }
        if(del==null) return;
        if(pre==null) head=del.next;
        else
            pre.next=del.next;
    }
}

/*** Your MyHashMap object will be instantiated and called as such:

        * MyHashMap obj = new MyHashMap();

        * obj.put(key,value);

        * int param_2 = obj.get(key);

        * obj.remove(key);
 * */