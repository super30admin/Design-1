
//Design HasMap(https://leetcode.com/problems/design-hashmap/)
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


//Solved using double hash function
class MyHashMap {

    int keybuckets = 1000;
    int bucketvalues = 1001;
    int[][] storage;
    public MyHashMap() {
        storage = new int[keybuckets][bucketvalues];
        for(int i=0;i<=keybuckets-1;i++){
            for(int j=0;j<=keybuckets-1;j++){
                storage[i][j]=-1;
            }
        }
    }
    private int keybucket(int key){
        return key%keybuckets;
    }
    private int bucketvalue(int key){
        return key/bucketvalues;
    }
    public void put(int key, int value) {
        int keybucket = keybucket(key);
        int bucketvalue = bucketvalue(key);
       
            storage [keybucket][bucketvalue] = value;
        
    }
    
    public int get(int key) {
        int keybucket = keybucket(key);
        int bucketvalue = bucketvalue(key);
       
        return storage [keybucket][bucketvalue];
        
    }
    
    public void remove(int key) {
        int keybucket = keybucket(key);
        int bucketvalue = bucketvalue(key);
        storage [keybucket][bucketvalue] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */










//Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Solved using two stack

class MinStack {
Stack<Integer> stk;
Stack<Integer> minstack;
    public MinStack() {
        stk = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        if(minstack.isEmpty()==true || val<=minstack.peek()){
            minstack.push(val);
        }
        stk.push(val);
    }
    
    public void pop() {
        if(stk.peek().equals(minstack.peek())){
            minstack.pop();
        }stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
