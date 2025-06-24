//Time Complexity: O(1)
//Space Complexity: O(2n) ~ O(n)

//Successfully Submitted on LeetCode

// Using two stacks to solve this question, one stack to store the values and another minStack to store the value of min at each each value of stack. So we keep a min which stores the value of min, update in by checking val while pushing a value to stack, later push min to minStack, to keep track of min. While popping pop stack and min stack and updating min value with minStack.peek()

//Space Complexity: less than O(2n) ~ O(n)
//Rather than using two stack we can use only stack but keep track of min, so whenever min is getting updated we push old min value along with val. So whenever we pop, we should check if the pop value is equals to min then we pop the next value too and update it as min.

import java.util.Stack;

// public class _155_Min_Stack {

//   Stack<Integer> stack;
//   Stack<Integer> minStack;
//   int min = Integer.MAX_VALUE;

//   public _155_Min_Stack() {
//     stack = new Stack<>();
//     minStack = new Stack<>();
//     minStack.push(min);
//   }

//   public void push(int val) {
//     min = Math.min(val, min);
//     stack.push(val);
//     stack.push(min);
//   }

//   public void pop() {
//     stack.pop();
//     minStack.pop();
//     min = getMin();
//   }

//   public int top() {
//     return stack.peek();
//   }

//   public int getMin() {
//     return minStack.peek();
//   }
// }

public class _155_Min_Stack {

  Stack<Integer> stack;
  int min;

  public _155_Min_Stack() {
    this.stack = new Stack<>();
    this.min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    if (val <= this.min) {
      this.stack.push(this.min);
      this.min = val;
    }
    this.stack.push(val);
  }

  public void pop() {
    if (this.stack.pop() == this.min) {
      this.min = this.stack.pop();
    }
  }

  public int top() {
    return this.stack.peek();
  }

  public int getMin() {
    return this.min;
  }
}
