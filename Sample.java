// Your code here along with comments explaining your approach

//****DESIGN HASHSET USING DOUBLE HASHING****
//Time complexity:o(1);
//space complexity:o(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


class MyHashMap {
    
    private boolean [][] storage;
    int buckets;
    int bucketlists;

    public MyHashMap() {
        buckets=1000;
        bucketlists=1000;
      //Not inititalizing the secondary array here itself to save the space;
        storage=new boolean[buckets][];
        
    }
    //Hashfunction for primary array
    public int bucket(int key) {
        return key%buckets;
        }
    //Hashfunction for secondary array
    public int bucketlist(int key) {
        return key/bucketlists;    
    }
    
    public void add(int key){
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
        //check if whether there is a reference of secondary array to the current bucket;
        if(storage[bucket]==null){
            //edge case of last element so for 0th index of bucket creating a secondary array of +1 size;
            if(bucket==0)
            {
                storage[bucket]=new boolean [bucketlists+1];
            }
            else{
                storage[bucket]=new boolean [bucketlists];
            }
        }
        storage[bucket][bucketlist]=true;
        
    }
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketlist]=false;
        
        
    }
    
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
      //if already the bucketlist is not initialized it is for sure that item doesnt exists.
        if(storage[bucket]==null)  return false;
        return storage[bucket][bucketlist];
        
        
        
    }
}



//****DESIGN A MINSTACK****
//Time Complexity:o(1);
//Space Complexity:o(n);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO
class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        min=Integer.MAX_VALUE;
        stack =new Stack<>();
        
    }
    
    public void push(int val) {
        if(val<=min)
        {
            stack.push(min);
            min=val;
        }
        stack.push(val);
        
    }
    
    public void pop() {
        if(min==stack.pop())
        {
            min=stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
        
    }
}
