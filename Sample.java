//705-Design a hashset
// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :problem in finding space complexity.


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int primary_array, secondary_array;
    

    public MyHashSet() {
        primary_array=1000;
        secondary_array=1000;
        storage= new boolean[primary_array][];
        
    }
    
    //Hash function 1
    public int hash1(int key){
        return key%1000;
        
    }
    
    //Hash function 2
    public int hash2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        //use hash1
        int hash1=hash1(key);
        int hash2=hash2(key);
        if(storage[hash1]==null){
            if(hash1==0)
            {
                storage[hash1]= new boolean[secondary_array+1];
            }
            else
            {
                storage[hash1]=new boolean[secondary_array];
            }
        }
        storage[hash1][hash2]= true;
        
        
    }
    
    public boolean contains(int key) {
        //hash1, hash2
        int hash1=hash1(key);
        int hash2=hash2(key);
        if(storage[hash1]==null)
        {
            return false;
        }
        else
        {
            if(storage[hash1][hash2]==false)
            {
                return false;
            }
            else
            {
                //storage[hash1][hash2]=false;
                return true;
            }
        }
    }
    
    public void remove(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
        if(storage[hash1]!=null)
        {
             if(storage[hash1][hash2]==true)
             {
                  storage[hash1][hash2]=false;
             }
        }
        
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */





//155-Min Stack
// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinStack {
    int min;
    Stack<Integer> st;
    Stack<Integer> min_stack;

    public MinStack() {
        min= Integer.MAX_VALUE;
        st =new Stack<Integer>();
        min_stack=new Stack<Integer>();
        min_stack.push(min);
        
    }
    
    public void push(int val) {
        if(val<=min)
        {
            min=val;
        
        }
        st.push(val);
        min_stack.push(min);
        
        
    }
    
    public void pop() {
        st.pop();
        min_stack.pop();
        min=min_stack.peek();
        
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
