// Time Complexity : O(1) for add,pop,peek
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Approach 1:
class MinStack {
    
    private Stack<Integer> s; //Stack for storing the values
    private Stack<Integer> ms; // Stack for storing the min values
    private int min; 
    
    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<>(); //initialise the stack
        ms= new Stack<>(); //initialise the stack
        min= Integer.MAX_VALUE; //initialise the min to Infinity
        ms.add(min); // add the min to the min stack 
    }
    
    public void push(int val) {
        min= Math.min(min,val); // get the current min by comparing it with the value to be added
        s.push(val); //push the value into the stack
        ms.push(min); // push the value to the min stack 
        
    }
    
    public void pop() {
        s.pop(); //pop from the stack 
        ms.pop(); //pop from the min stack 
        min=ms.peek(); //set the current min to the next min in the min stack 
    }
    
    public int top() {
        return s.peek(); // get the top value from the stack 
    }
    
    public int getMin() {
        return min; // return the current min 
    }
}

// /**
//  * Your MinStack object will be instantiated and called as such:
//  * MinStack obj = new MinStack();
//  * obj.push(val);
//  * obj.pop();
//  * int param_3 = obj.top();
//  * int param_4 = obj.getMin();
//  */

// Time Complexity : O(1) for add,pop,peek
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

// Approach 2:
class MinStack {
    
    private Stack<Integer> s; //one stack only 
    private int min; // min 
    
    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<>(); // initialise the stack 
        min= Integer.MAX_VALUE; // set the min to Infinity initially 
    }
    
    public void push(int val) {
        
        if(val<=min) // if value to be added is less than equal to the min
        {
            s.push(min); //then we push the current min into the stack 
            min=val; // change the min to the current value
            // we push twice in this case
            // so when we pop the min, we have the next min with us already 
        }
        s.push(val);  // then push the value

    }
    
    public void pop() {
        int p= s.pop(); // pop the value
        if(p==min) // if the value was min 
        {
            min= s.pop(); // then we pop again and set the min to the previous min stored beneath it 
        }  
    }
    
    public int top() {
        return s.peek(); // get the top element 
    }
    
    public int getMin() {
        return min; // return the current min 
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


// Time Complexity : O(1) for add, remove and contain
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    private boolean[][] storage;  // initialise a boolean 2D array
    int buckets;                 // primary array elements
    int bucketItems;            // secondary array elements
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage= new boolean[1000][]; // initialise the array with only the primary array for now
        buckets=1000; //since the constraints given is 10^6, sqrt(10^6) gives us 1000. 
        bucketItems=1000; // since the constraints given is 10^6, sqrt(10^6) gives us 1000.
        // we will have 1000*1000 elements
    }
    
    /*
     The first hashing function
     It returns the modulo of the key with 1000
    */
    private int hash1(int key){
        return key%1000;
    }
    
    /*
     The Second hashing function
     It returns the quotient when dividing the key with 1000
    */
    private int hash2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int i1=hash1(key); // calculate the primary index of the given key
        int i2=hash2(key); // calculate the secondary index of the given key
     
        // if the primary index is null or empty, then we will create a secondary array at this step 
        if(storage[i1]==null)
        { 
        if(i1==0) //Additional space to prevent out of bound exception, since hashing of 0 will be 1000 and we will need extra space for that
        {
            storage[i1]= new boolean[bucketItems+1];
        }
        else{
            storage[i1]= new boolean[bucketItems];
        }   
        }
        storage[i1][i2]=true; // changing the value in the storage array to true to signify that the element is now added
        
    }
    
    public void remove(int key) {
        int buckets=hash1(key); // First hashing 
        int bucketItems=hash2(key); // Second hashing 
        if(storage[buckets]==null){ // If no element was present return
            return;} 
         storage[buckets][bucketItems]=false; // else change that value to false to signify remove
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int buckets=hash1(key); // First hashing
         int bucketItems=hash2(key); // Second hashing
         if(storage[buckets]==null){return false;} //If no element was present return
         return storage[buckets][bucketItems]; // else return true if the set contains the  element or false if it does not contain the element 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */