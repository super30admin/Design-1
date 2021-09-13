/**************************************** DESIGN HASHMAP ****************************************/
// Time Complexity : O(1) for get, put, and remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//Collision is handled via chaining - LinkedList

class MyHashMap {
    LinkedList<Entry>[] map;
        public static int size = 769;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    /** value will always be non-negative. */
    /* We calculate the bucket. Once we have the bucket, if it's not null, we initialise a linkedlist in that bucket
    and put the key value pair. If the bucket contains the key, we replace the existing value of that key with the new value and
     if it's not present, we simply add the pair to the bucket.*/
    public void put(int key, int value) {
        int bucket = key % size; 
            if(map[bucket] == null) {
                map[bucket] = new LinkedList<Entry>();
                map[bucket].add(new Entry(key, value));
            }
            else {
                for(Entry entry : map[bucket]){
                    if(entry.key == key){
                        entry.val = value;
                        return;
                    }
                }
                map[bucket].add(new Entry(key, value));
            }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    /* We calculate the bucket. For every entry, we check if the key exists. If yes, we simply return the value 
    associated with the key and of the key is not present we return -1.*/
    public int get(int key) {
        int bucket = key % size;
            LinkedList<Entry> entries = map[bucket];
            if(entries == null) return -1;
            for(Entry entry : entries) {
                if(entry.key == key) return entry.val;
            }
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    /* We calculate the bucket. For every entry, we check if the key exists. If yes, we store the enrty in a entry object. If the
    object is null, we simply return. If it's not null,it means the key exists. We use the remove method to remove the key*/
    public void remove(int key) {
        int bucket = key % size;
            Entry a = null;
            if(map[bucket] == null) return;
            else {
                for(Entry entry : map[bucket]){
                    if(entry.key == key) {
                        a = entry;
                    }
                }
                if(a == null) return;
                map[bucket].remove(a);
            }
    }
}
class Entry{
    public int key; // public to use it directly in the hashmap
    public int val;
    public Entry(int key,int val){
        this.key = key;
        this.val = val;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


 /**************************************** MIN STACK ****************************************/
// Time Complexity : O(1)
// Space Complexity : O(2n) -> O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

class MinStack {
    /** initialize your data structure here. */
    /* We take 2 stacks. The first will perform all the stack operations and the second one is used to keep
    a track of the minimum value. This approach will require extra space. */
    Stack<Integer> stack = new Stack();
    Stack<Integer> min_value = new Stack();
    
    /* If the min_value stack is empty or the current value is less than equal to the top element of the min_value stack,
    we push the new minimum value to the min_value stack*/
    public void push(int val) {
        if(min_value.isEmpty() || val <= min_value.peek()){ 
            min_value.push(val);
        }
        stack.push(val);
    }
    
    /* If the top value of stack and min_value stack is the same, then we need to pop the element from the min_value 
    stack as well. */
    public void pop() {
        if(stack.peek().equals(min_value.peek())){
            min_value.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_value.peek();
    }
}

