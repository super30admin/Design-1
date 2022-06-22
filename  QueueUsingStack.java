//Time complexity- O(1)
//Space Complexity- O(N)
//Successfully ran on leetcode
//The problem was fairly simple but had some edge cases that had to be throughly analysed.

import java.util.Stack;

class MyQueue {

 Stack<Integer> in;
 Stack<Integer> out;
public MyQueue() {
  in= new Stack<>();
  out = new Stack<>(); 
}
public void push(int x) {
 in.push(x);
}
public int pop() {
 peek();
return  out.pop();
}


public int peek() {
 if(out.isEmpty()){
     while(!in.isEmpty()){
         out.push(in.pop());
     }
 }
return out.peek();
}


public boolean empty() {
 if(out.isEmpty() && in.isEmpty()){
     return true; 
 }
 else return false;
}
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/