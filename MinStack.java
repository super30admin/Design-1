// Time Complexity : O(n)  Insertion: O(1) Deletion: O(n) ArrayList Sort: O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
    Stack<Integer> s;
    List<Integer> l;
	
	// list is kept for sorting purpose to get minimum value
    public MinStack() {
        s = new Stack<>();
        l = new ArrayList<>();
    }
    
    public void push(int x) {
        s.add(x);
        l.add(x);
    }
    public void pop() {
        l.remove(s.peek());
        s.pop();
        // System.out.println(l);
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        List<Integer> p = l;
        p.sort(null);
        return p.get(0);
    }
}
