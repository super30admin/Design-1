
/*Approach: Internally hashmap is implemented as array of linkedlist,
 take a key, apply hashfunction and find bucket no. If more than one key maps with the same bucket number
 then to resolve the collision I have creted array of LinkedList */

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes,I struggled bit in edge cases

/**
 *Design a HashMap without using any built-in hash table libraries. To be specific, your design should
 * include these functions: Follow up: How would you handle collisions in HashMap?
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
//To handle the collisions I have created LinkedList
class MyHashMap {
    ListNode[] map;

    class ListNode{
        int key,val;
        ListNode next;
        public ListNode(int k,int v){
            key=k;
            val=v;
            next=null;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        map=new ListNode[10000];
    }

    //Time Complexity:o(n) where n is size of linkedlist for the given bucket
    //space complexity:o(1)
    /**
     * put the Entry(key,value) in map if key noe exists in the map else just repalce the value with new value
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        int bucketNo=getBucketNo(key);
        ListNode newNode=new ListNode(key,value);
        ListNode head=map[bucketNo];

        //If the list in the current backet is empty
        if(head==null){
            map[bucketNo]=newNode;
            return;
        }
        //if the first node key matches with the given key then update only value
        if(head.key==key){
            head.val=value;
            return;
        }

        ListNode prev=serachNode(head,key);
        //key is previously not exist in map so add new node(key,val) at end of list
        if(prev.next==null){
            prev.next=newNode;
        }else{
            //key is already exists in map so update value
            prev.next.val=value;
        }

    }

    //Time Complexity:o(n) where n is size of linkedlist for the given bucket
    //space complexity:o(1)
    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     * @param key
     * @return
     */
    public int get(int key) {
        int bucketNo=getBucketNo(key);
        ListNode head=map[bucketNo];

        //If the list in that bucket is empty
        if(head==null)
            return -1;

        //If the key exists at first node
        if(head.key==key)
            return head.val;

        ListNode prevNode=serachNode(head,key);
        if(prevNode.next!=null)
            return prevNode.next.val;
        else
            return -1;

    }

    //Time Complexity:o(n) where n is size of linkedlist for the given bucket(index)
    //space complexity:o(1)
    /**
     * Remove the key,value pair if key exists in the map
     * @param key key to be searched in map
     */
    public void remove(int key) {
        int bucketNo=getBucketNo(key);
        ListNode head=map[bucketNo];

        //If the list for given bucket is empty
        if(head==null)
            return;
        //if the key exists at the first node in the list
        if(head!=null && head.key==key) {
            map[bucketNo] = head.next;
            return;
        }

        ListNode prevNode=serachNode(head,key);
        //If key doesnt exists in the linkedlist
        if(prevNode.next==null)
            return;
        else
            prevNode.next=prevNode.next.next;

    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * This is the hash function which gives me the bucket number in the array for given key
     * @param key
     * @return integer bucket number(index of array)
     */
    private int getBucketNo(int key){
        return (key%map.length);

    }

    //Time Complexity:o(n) where n is size of linkedlist for the given bucket(index)
    //space complexity:o(1)
    /**
     * This method takes head of linkedlist and search for the node which has the given key and returns its sprevious node
     * @param head head of linkedlist
     * @param key key to be serched in linkedlist
     * @return ListNode previoues to the node which has key
     */
    private ListNode serachNode(ListNode head, int key){
        ListNode prev=null;
        while(head!=null && head.key !=key){
            prev=head;
            head=head.next;
        }
        return prev;

    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));// returns 1
        System.out.println(hashMap.get(1)); System.out.println(hashMap.get(3));          // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));           // returns -1 (not found)
    }
}
