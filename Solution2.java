Design HashMap
M is size of bucket which is constant
N is size of input data in each bucket; Worst case is all operations go into single bucket; Avg case is O(1)
T: O(M+N), Amortized time: O(1)
S: O(MN), Amortized time: O(1)
class MyHashMap {

    class ListNode{
        int val;
        int key;
        ListNode next;

        ListNode(int key,int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }

    ListNode[] bucket;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new ListNode[1000000];
    }

    public int findIndex(int key){
        return key % bucket.length;
    }

    public ListNode findElement(int key){
        int index = findIndex(key);

        if(bucket[index]==null){
            bucket[index] = new ListNode(-1,-1);;

            return bucket[index];
        }else{
            ListNode prev = bucket[index];

            while(prev.next!=null && prev.next.key!=key){
                prev = prev.next;
            }

            return prev;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        ListNode prev = findElement(key);

        if(prev.next!=null){ //element exist, just update val
            prev.next.val = value;
        }else{ //not present
            prev.next = new ListNode(key,value);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode prev = findElement(key);

        if(prev.next==null)
            return -1;
        else
            return prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode prev = findElement(key);

        if(prev.next!=null)
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