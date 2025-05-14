//T.C: O(1)
//S.c: O(1)

//Approach: here i am implementing it using a stack and a var to keep track of min. 
//For push operations, each time the incoming key is < min then i will push the min as well as the key so that the min is tracked on each push in case of change in min.
//For pop operations, each time if the top elemnt is min then i will pop twice and update the min with the later pop as in push we pushed the min before inserting the key.
//For top, i am using the built-in peek().
//for getMin, as we are keeping track of min so i will just return min.


class MinStack {
Stack<Integer> minS;
int min;


    public MinStack() {
        this.minS = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min >= val){
            minS.push(min);
            min = val;
        }
        minS.push(val);
    }
    
    public void pop() {
        if(minS.peek() == min){
            minS.pop();
            min = minS.pop();
            return;
        }
        minS.pop();
    }
    
    public int top() {
        return minS.peek();
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
