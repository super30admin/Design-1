/*

    Time Complexity: O(1) for all operations
    Space Complexity: O(n)

*/



class MinStack {

    private class Pair{
        int val;
        int min;
        public Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int prevMin = stack.size()>0 ? stack.peek().min : Integer.MAX_VALUE;
        int min = Math.min(prevMin, val);
        stack.add(new Pair(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}