//Time Complexity: O(1)

class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> ms = new Stack<Integer>();
    int min;

      public MinStack() {
      min=Integer.MAX_VALUE;
      ms.push(min);

      }

      public void push(int val) {
        if(min>=val){
            min=val;
        }
          ms.push(min);
           s.push(val);

      }

      public void pop() {
        s.pop();
        ms.pop();
      min=ms.peek();
      }

      public int top() {
          return s.peek();
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