// Time Complexity :O(1) in each operation
// Space Complexity :O(2n) worst case
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :
//  - Stack stack = new Stack(); why is this not functioning at line 14
//  - Alternatively tried to create an object of MinStack and tried to compile throws an error



// Your code here along with comments explaining your approach
class MinStack {
  int min = Integer.MAX_VALUE;
  // Stack stack = new Stack(); why is this not functioning because not instatiating object of stack
  Stack<Integer> st = new Stack<>();

    public MinStack() {

      // st.push(10);
      // st.push(4);
      // st.push(13);
      // st.push(12);
      // st.push(3);

    }

    public void push(int x) {
          if(min>=x){
            st.push(min); //error cannot find the symbol on the line because entered wrong value
            min=x;
          }
          st.push(x);
    }

    public void pop() {
      int out = st.pop();
      if(out==min){
        min=st.pop();
      }

    }

    public int top() {
      return st.peek();
    }

    public int getMin() {
      return min;
    }

    // public static void main(String[] args){
    //   // MinStack(); wrong way to call the constructor need to instantiate
    //   // MinStack st = new MinStack();
    //   // st.push(10);
    //   // st.push(4);
    //   // st.push(13);
    //   // st.push(12);
    //   // st.push(3);
    //
    // }
}
