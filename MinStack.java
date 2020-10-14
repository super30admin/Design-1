import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : How to start
public class MinStack {


        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> miniStack = new Stack<>();

        public void push(int num){
            mainStack.push(num);
            if(miniStack.isEmpty() || num <= miniStack.peek()){
                miniStack.push(num);
            }
        }

        public void pop(){
            if(mainStack.peek().equals(miniStack.peek())){
                miniStack.pop();
            }
            mainStack.pop();
        }

        public int top(){
            return mainStack.peek();
        }

        public int getMin(){
            return miniStack.peek();
        }


}
