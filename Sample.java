//time complexity = O(1)
//space complexity = O(1)
class MyHashSet {
  boolean a[];
  public MyHashSet() {
    a = new boolean[1000001];
  }

  public void add(int key) {
    a[key] = true;
  }

  public void remove(int key) {
    a[key] = false;
  }

  public boolean contains(int key) {
    return a[key];
  }
}

//time complexity = O(1)
//space complexity = O(1)
// take 2 stacks and one tracks the current stack value and other tracks the min seen till now
class MinStack {

  Stack<Integer> s, minStack;
  public MinStack() {
    s= new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    int min = s.isEmpty()?val:Math.min(val,minStack.peek());
    s.add(val);
    minStack.add(min);
  }

  public void pop() {
    s.pop();
    minStack.pop();
  }

  public int top() {
    return s.peek();
  }

  public int getMin() {
    return minStack.peek();
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
