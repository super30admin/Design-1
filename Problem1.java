class MyHashMap {

    /** Initialize your data structure here. */
ListNode[] nodes = new ListNode[1000];

    public MyHashMap() {
        // Do Nothing
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode cur = findElement(index, key);
        if(cur.next == null){
            cur.next = new ListNode(key,value);
        } else{
            cur.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode cur = findElement(index, key);
        return cur.next == null ? -1 : cur.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode cur = findElement(index, key);
        if(cur.next != null){
            ListNode temp = cur.next.next;
            cur.next = null;
            cur.next = temp;
            // cur.next = cur.next.next;
        }
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key)%1000;
    }
    
    private ListNode findElement(int index, int key){
        if(nodes[index] == null){
            return nodes[index] = new ListNode(-1,-1);
        } else{
            ListNode cur = nodes[index];
            while(cur.next !=null && cur.next.key!=key){
                cur = cur.next;
            }
            return cur;
        }
    }
    
    //ListNode Class    
    class ListNode{
        int key;
        int val;
        ListNode next;
    
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
            // this.next = null;
        }
    }
}

//Driver CLass
class Main { 
    public static void main(String args[]) 
    { 
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);          
        hashMap.put(2, 2);         
        
        int getOp = hashMap.get(1);            // returns 1
        System.out.println("Get Method of hashMap invoked:" + getOp);
        
        getOp = hashMap.get(3);            // returns -1 (not found)
        System.out.println("Get Method of hashMap invoked:" + getOp);
        
        hashMap.put(2, 1);          // update the existing value
        
        getOp = hashMap.get(2);            // returns 1 
        System.out.println("Get Method of hashMap invoked:" + getOp);
        
        hashMap.remove(2);          // remove the mapping for 2
        
        getOp = hashMap.get(2);            // returns -1 (not found) 
        System.out.println("Get Method of hashMap invoked:" + getOp);
    } 
} 
