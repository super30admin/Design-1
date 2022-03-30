// Time Complexity Hashmap: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :I used the same technique Raj sir told for hashset in the class
// Time Complexity Minstack: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I used the same technique Raj sir told  in the class


// Your code here along with comments explaining your approach
//
//class MyHashMap {
//
//    int keybuckets = 1000;
//    int bucketvalues = 1001;
//    int[][] storage;
//    public MyHashMap() {
//        storage = new int[keybuckets][bucketvalues];
//        for(int i=0;i<=keybuckets-1;i++){
//            for(int j=0;j<=keybuckets-1;j++){
//                storage[i][j]=-1;
//            }
//        }
//    }
//    private int keybucket(int key){
//        return key%keybuckets;
//    }
//    private int bucketvalue(int key){
//        return key/bucketvalues;
//    }
//    public void put(int key, int value) {
//        int keybucket = keybucket(key);
//        int bucketvalue = bucketvalue(key);
//
//        storage [keybucket][bucketvalue] = value;
//
//    }
//
//    public int get(int key) {
//        int keybucket = keybucket(key);
//        int bucketvalue = bucketvalue(key);
//
//        return storage [keybucket][bucketvalue];
//
//    }
//
//    public void remove(int key) {
//        int keybucket = keybucket(key);
//        int bucketvalue = bucketvalue(key);
//        storage [keybucket][bucketvalue] = -1;
//    }
//}
//
///**
// * Your MyHashMap object will be instantiated and called as such:
// * MyHashMap obj = new MyHashMap();
// * obj.put(key,value);
// * int param_2 = obj.get(key);
// * obj.remove(key);
// */
//=================================================================
//
//class MinStack {
//    Stack<Integer> stk = new Stack<>();
//    Stack<Integer> minstack = new Stack<>();
//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//        if(minstack.isEmpty()==true || val<=minstack.peek()){
//            minstack.push(val);
//        }
//        stk.push(val);
//    }
//
//    public void pop() {
//        if(stk.peek().equals(minstack.peek())){
//            minstack.pop();
//        }stk.pop();
//    }
//
//    public int top() {
//        return stk.peek();
//    }
//
//    public int getMin() {
//        return minstack.peek();
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
