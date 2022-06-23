// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
class MinStack {

    long minimum;
    Stack<Long> userstack;

    public MinStack(){
        userstack=new Stack<>();
    }

    public void push(int val) {
        if (userstack.isEmpty()){
            userstack.push(0L);
            minimum=val;
        }else{
            userstack.push(val-minimum);//
            if (val<minimum) {
                minimum = val;
            }
        }
    }

    public void pop() {
        if (userstack.isEmpty()) return;

        long popedValue=userstack.pop();

        if (popedValue<0) {
            minimum = minimum - popedValue;//If negative, increase the min value
        }
    }

    public int top() {
        long upperValue=userstack.peek();
        if (upperValue>0){
            return (int)(upperValue+minimum);
        }else{
            return (int)(minimum);
        }
    }

    public int getMin() {
        return (int)minimum;
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