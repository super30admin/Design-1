// # Design-1 ## Problem 1:(https://leetcode.com/problems/design-hashset/)
// Time Complexity : O(n) in worst case and O(1) in best case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach

class MyHashSet {
    private final int max_value = 1000000;
    private final int size = 100;
    private List<List<Integer>> list;
    //Initializing the data structure
    public MyHashSet() {
        list = new ArrayList<>();
        for(int i=0; i<size; i++){
            list.add(null);
        }
    }
    
    public void add(int key) {
        //Map value to the bucket it goes to
        int mapValue = key % size;
        //Get the mapValue - where the key needs to go
        List<Integer> newList = list.get(mapValue);
        if(newList == null){
            //creating the new linked list and adding
            List<Integer> insertedList = new LinkedList<>();
            insertedList.add(key);
            list.set(mapValue, insertedList);
        }else{
            if(!newList.contains(key)){
                newList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        //to check where is the bucket where the value will be stored
        int mapValue = key % size;
        List<Integer> newList = list.get(mapValue);
        if(newList != null){
            newList.remove(Integer.valueOf(key));
        }
    }
    
    //Returns true if set contains the specified element
    public boolean contains(int key) {
        int mapValue = key % size;
        List<Integer> newList = list.get(mapValue);
        return newList != null && newList.contains(key);
    }
}

//## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class MinStack {
    
    Stack<Integer> s1 = new Stack();
    //to store the minimum value
    Stack<Integer> s2 = new Stack();
    //Initializes the data structure
    public MinStack() {
        
    }
    
    //pushes the element val into the stack
    public void push(int val) {
        //val is less than current minimum value in s2 stack
        if(s2.isEmpty() || val <= s2.peek()){
            s2.push(val);
        }
        s1.push(val);
        
    }
    
    //pop the element from the top of stack
    public void pop() {
        if(s1.peek().equals(s2.peek())){
            s2.pop();
        }
        s1.pop();
    }
    
    //get the top element
    public int top() {
        return s1.peek();
    }
    
    //retrives minimum element
    public int getMin() {
        return s2.peek();
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