/*
Time Complexity: O(n)
Space Complexity: O(1)
It ran on leetcode
Didnt face any issue while writing the code
*/

class MyQueue {
    
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    public MyQueue() {
        
    }

    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
             s2.push(s1.pop());
        }
    return s2.pop(); 
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}