//Problem 1:(https://leetcode.com/problems/design-hashset/)   HashSet

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: The range of hashset is from 0 to 1000000 so we take bucket as the size of primary array and bucketItems as the size of nested array. We have set the size of the primary array as 1000 by taking a square root of the given range. We create a nested array only when there is a collision. 



class MyHashSet {
    boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage=new boolean[buckets][];        
    }

    private int hash1(int key)
    {
        return key%1000;
    }

    private int hash2(int key)
    {
        return key/1000;
    }
    
    public void add(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null)
        {
            if(bucket==0)
            {
                storage[bucket]=new boolean [bucketItems+1];
            }
            else
            {
                storage[bucket]=new boolean [bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];       
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




  // Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach : We check if the element coming out of stack is the current minimum, if it is then we update min with the previous minimum. We keep previous minimum as it is until a new minimum is found




class MinStack {
    Stack <Integer> st;
    int min;
    public MinStack() {
        this.st=new Stack<>();
        this.min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min>=val){
            st.push(min);
            min=val;
        }
        st.push(val);
    }
    
    public void pop() {
        if (st.pop()==min){
            min=st.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
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

