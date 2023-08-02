// Time Complexity : O(1)
// Space Complexity
// Did this code successfully run on Leetcode : yes
// Using two stack approach, one is to stack the all the element and other for minimum.
class MinStack{
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    MinStack(){
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE; //Considering the max value to start comparing min.
        this.minSt.push(min); 
    }

    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minSt.push(min);
    }

    public void pop() {
        st.pop();
        minSt.pop();
        this.min = minSt.peek(); // saving the minimnum. 
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }

}