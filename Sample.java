// Time Complexity :for all the operations the Time complexity is O(1)
// Space Complexity :O(10^6) in worst case.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage=new boolean[buckets][];
        
    }
    public int getKey1(int val){
        return val%1000;
    }
    public int getKey2(int val){
        return val/1000;
    }
    
    public void add(int key) {
        int bucket=getKey1(key);
        int bucketItem=getKey2(key);
       
        if(storage[bucket]==null){
            if(bucket==0){
            storage[bucket]=new boolean[bucketItems+1]; 
        }
            else{
            storage[bucket]=new boolean[bucketItems];
           }
        }
         storage[bucket][bucketItem]=true;
        }
    
    public void remove(int key) {
        int bucket=getKey1(key);
        int bucketItem=getKey2(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=getKey1(key);
        int bucketItem=getKey2(key);
        if(storage[bucket]!=null){
        return storage[bucket][bucketItem];
        }
        return false;
        
    }
}




// Time Complexity :for all the operations the Time complexity is O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : .


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack;
    int min;;
    

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
             stack.push(min);
              min=val;
            
        }
        stack.push(val);
        }
    
    public void pop() {
        if(stack.peek()==min){
            stack.pop();
            min=stack.pop();
        }
        else{
        stack.pop();
        }
        
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
        
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
