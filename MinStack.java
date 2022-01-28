//o(2(n)) space
// o(1) time
//add min and val in same stack, if min is current popped then remove the next element and make it min

import java.util.Stack;
class MinStack{
    Stack<Integer> s;
    int min = Integer.MAX_VALUE;

    public MinStack() {
      s = new Stack<>();
      min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
          s.push(min);
          min = val;
        }
        s.push(val);
      }



    public void pop() {
      int temp = s.pop();
      if(temp == min){
        min = s.pop();
      }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
      return min;
    }
  }
