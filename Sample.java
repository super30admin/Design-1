// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

1. HashMap
//Time complexity  is O(1)   (since it always searches at most 1000 nodes is fixed  otherwise o(n) )
//Space complexity is O(1) (since it always searches at most 1000 nodes is fixed )
//successfully ran on leetcode
//no problems faced
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }

    }
    private int noOfbuckets;
    private Node buckets[];

    /** Initialize your data structure here. */
    public MyHashMap() {
        noOfbuckets=1000;
        buckets=new Node[noOfbuckets];

    }
//hash function mapping the backets
    public int getIndex(int key){
        return key%noOfbuckets;
    }

    //Checking whether the key already prasent or not if so returning previous node
    public Node getPrevNode(int key){
        int index=getIndex(key);
        Node prev=buckets[index];
        Node cur=buckets[index].next;
        while(cur!=null&&cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key);
        if(buckets[index]==null){
            buckets[index]=new Node(-1,-1);
        }
        Node prev=getPrevNode(key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }else{
            prev.next.val=value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        if(buckets[index]==null)
            return -1;
        Node prev=getPrevNode(key);
        if(prev.next==null){
            return -1;
        }else{
            return prev.next.val;
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getIndex(key);
        if(buckets[index]==null)
            return;
        Node prev=getPrevNode(key);
        if(prev.next==null){
            return;
        }else{
            prev.next=prev.next.next;
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


2. Min Stack
//space complexity O(n) where n is the no. of elements
//Time complexity is O(1) for all the operations push,pop(),top and getMin()
//This code ran successfully on leetcode
//No issues faced;

class MinStack {

    Stack<Integer>stk;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        min=Integer.MAX_VALUE;
        stk=new Stack<>();
    }

    public void push(int x) {
        if(min>=x){
            stk.push(min);
            min=x;
        }
        stk.push(x);

    }

    public void pop() {
        if(stk.pop()==min){
            min=stk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */