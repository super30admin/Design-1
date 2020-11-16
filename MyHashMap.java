class MyHashMap {
    int SIZE;
    ListNode[] bucketMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.SIZE = 10000;
        this.bucketMap = new ListNode[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketNum = hashCode(key);
        if(bucketMap[bucketNum] == null){
            bucketMap[bucketNum] = new ListNode(-1,-1); // head of the collision chain.
        }
        ListNode node = findEndorNodeInCollisionChain(bucketMap[bucketNum],key,value);
        if(node != null){
          node.next = new ListNode(key,value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketNum = hashCode(key);
        ListNode head = bucketMap[bucketNum];
        ListNode temp = head;
        while(temp!=null && temp.key != key){
            temp = temp.next;
        }
        if(temp == null){
            return -1;
        }else{
            return temp.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketNum = hashCode(key);
        ListNode head = bucketMap[bucketNum];
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null && temp.key != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            return;
        }else{
            prev.next = temp.next;
        }
    }

    public int hashCode(int key){
        return key % SIZE;
    }

    public ListNode findEndorNodeInCollisionChain(ListNode head,int key,int value){
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null && temp.key != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
         return prev;
        }else{
           temp.val = value;
        }
        return null;
    }
}

class ListNode{

    int key;
    int val;
    ListNode next;

    public ListNode(int key, int val){
         this.key = key;
         this.val = val;
    }


}

