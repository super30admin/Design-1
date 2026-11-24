// Time Complexity: O(1) amortized for push, O(1) strictly for other operations
// Space Complexity: O(N) where N is the size of the stack
// Approach: Two arraylists work in parallel, one keeps track of all the operations
//          and one just maintains the minimum key at time of every operation. 

class MinStack {

    private final List<Integer> stack;
    private final List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int value) {
        stack.add(value);
        
        if (minStack.isEmpty() || value <= minStack.get(minStack.size() - 1)) {
            minStack.add(value);
        }
    }
    
    public void pop() {
        
        int removed = stack.remove(stack.size() - 1);
        
        if (removed == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
