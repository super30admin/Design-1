// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Approach:
 We use a single stack approach by keeping a min variable tracker and keeping the next minimum just
 beneath the popped value
 */


 import java.util.Stack;

 public class MinStack {
     int min;
     Stack<Integer> s;
     public MinStack() {
         s = new Stack<>();
         min = Integer.MAX_VALUE;
     }
 
     public void push(int val) {
         // check if value is less than min, push old min, update min and then push the value
         if (val <= min) {
             s.push(min); // this is so that our min always lies under the pushed value
             min = val;
         }
         s.push(val);
     }
 
     public void pop() {
         int poppedElement  = s.pop();
         if (poppedElement == min) {
             // pop again and set min to second popped element
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
 