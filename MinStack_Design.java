//T.C: here everything is O(1) - push , pop, min
//S.C: (2(n)) ==> O(n)

class MinStack {
    Stack<Integer> mainSt;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        mainSt = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE; // adding to min initially
        minSt.add(min); 
        
    }
    
    public void push(int val) {
         mainSt.push(val);
        if(val < minSt.peek()){ // check val with the min value 
            minSt.push(val);
            min = val; // update min value
        } else {
            minSt.push(min);
        }
         
    }
    
    public void pop() {
         mainSt.pop();
         minSt.pop();
         min = minSt.peek(); // update the min value
    }
    
    public int top() {
        return mainSt.peek();
    }
    
    public int getMin() {
         return minSt.peek();
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