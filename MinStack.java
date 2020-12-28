Time complexity: O(1)
Space complexity: O(n)

Space complexity: O(N)class MinStack {

   Stack <Integer> st = new Stack<>();

   Stack <Integer> minStack = new Stack<>();

   int min = Integer.MAX_VALUE;

   /** initialize your data structure here. */

   public MinStack() {

       minStack.push(min); // push default minimum

   }

   public void push(int x) {

       st.push(x);

       if(x < min) {

           min = x;  // update minimum if you find any

       }

       minStack.push(min);

   }

   public void pop() {

       st.pop(); // pop on both the stacks

       minStack.pop();

       min = minStack.peek();

   }

   public int top() {

       return st.peek();  //top element

   }

   public int getMin() {

       return min; //return min value

   }

}