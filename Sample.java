// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//Approach :- MinStack will use Stack to person O(1) operation of push   // and pop. For min element, if new element is smaller than min element 
// push prev min element to stack and then new min element and update min
// variable. While removing check if the element being removed is min. If // yes, then pop twice and update min with second popped element.

MinStack.java


class MinStack {
    
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        if(val>min)
            minStack.push(val);
        else{
            minStack.push(min);
            minStack.push(val);
            min = val;
        }
    }
    
    public void pop() {
        if(minStack.pop()==min){
            min = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
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





Design HashSet :- (Using Double-Hashing)

/*Approach :- Create a boolean 2D array. Pick primary bucket size or hash * function as square root of dataSize to equally distributed the keys.   * Initialise secondary array when needed to minimize storage space. Use  * Secondary function as division for uniqueness. bucketItem+1 for edge                *case. 
*/

class MyHashSet {

    boolean[][] array;
    int bucket;
    int bucketItem;
    
    public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        array = new boolean[bucket][];
    }
    
    public void add(int key) {
        int insertBucket = key%bucket;
        int insertBucketItem = key/bucketItem;
        if(array[insertBucket]==null){
            if(insertBucket==0)
                array[insertBucket] = new boolean[bucketItem+1];
            else
                array[insertBucket] = new boolean[bucketItem];
        }
        
        array[insertBucket][insertBucketItem] = true;
    }
    
    public void remove(int key) {
        int removeBucket = key%bucket;
        if(array[removeBucket]==null)
            return;
        int removeBucketItem = key/bucketItem;
        array[removeBucket][removeBucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        if(array[key%bucketItem]!=null)
            return array[key%bucket][key/bucketItem];
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
