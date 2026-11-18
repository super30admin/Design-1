// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// I am considering a 2D array to implement hashset.A row of size 1000 stores mod values of key , for each key we check does a array exist in that arr[mod] if not we create one and calculates div value and store in sub array.For 1M number since the 0th array is already full, we handle seperete to create 1001 size for 0 th index.
class MyHashSet {
    int rowSize;
    int colSize;
    
    boolean[][] arr;

    public MyHashSet() {
        this.rowSize=1000;
        this.colSize=1000;
        
        this.arr=new boolean[rowSize][];
    }
    
    public void add(int key) {
        int rem=key % rowSize;
        if(arr[rem]==null){
            if(rem==0){
                arr[rem]=new boolean[colSize+1];
            }
            else{
                arr[rem]=new boolean[colSize];
            }
            
        }
        int quo=key/colSize;
        arr[rem][quo]=true;
    }
    
    public void remove(int key) {
        int rem=key % rowSize;
        if(arr[rem]==null){
            return ;
        }
        int quo=key/ colSize;
        arr[rem][quo]=false;
    }
    
    public boolean contains(int key) {
        int rem=key % rowSize;
        if(arr[rem]==null){
            return false;
        }
        int quo=key/ colSize;
        return arr[rem][quo];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// MIN STACK:

// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// I am considering two stacks one to maintain values other one to maintain min values,on every push we add value in to stack and check if
// it is less than minstack.peek() if yes we push new value in minstcak, while pop on each pop we check if pop value is minstack.peek() if yes 
// we do minstack.pop() so that on removal of min val , min stcak min value also gets removed and nex min stays at peek.

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        this.stack=new Stack<>();
        this.minstack=new Stack<>();
        minstack.push(Integer.MAX_VALUE);
    }
    
    
    public void push(int value) {
        stack.push(value);
        if(value<=minstack.peek()){
            minstack.push(value);
        }
    }
    
    public void pop() {
        int val=stack.pop();
        if(val==minstack.peek()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
