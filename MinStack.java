import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack{
	//Approach: 1. Am maintaining a min variable which will keep track of the min element of the stack. 
	//2. While pushing an element on to the stack, I compare it with the min element, if new element is lesser than min, 
	//I will push the old min element to stack and then update the min with new element. Then I will also push new element to stack. 
	//3. This way I will keep a track of old min elements when I have to pop the min element. 
	//4. So, while popping, I will again compare with min, if they are equal then i will pop the element and then pop again to update the min variable.
	
	
	Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x <= min )
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(min == stack.peek())
        {
            stack.pop();
            min = stack.pop();
        }else
        {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

class MinStack2 {

	//Approach: Here I maintain a list of integers on every stack node, to contain the min element and the element itself.
    List<Integer> list = new ArrayList<Integer>();
    Stack<List<Integer>> stack = null;

    /** initialize your data structure here. */
    public MinStack2() {
        stack= new Stack<List<Integer>>();
    }
    
    //Approach: 
    public void push(int x) {
        if(!stack.isEmpty())
        {
            List<Integer> list = stack.peek();
            int min = x < list.get(1) ? x: list.get(1);
            List<Integer> node = new ArrayList<Integer>();
            node.add(x);node.add(min);
            stack.push(node);
        }
        else
        {
            List<Integer> node = new ArrayList<Integer>();
            node.add(x);node.add(x);
            stack.push(node);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty())
        {
            stack.pop();
        }
    }
    
    public int top() {
        List<Integer> list = null;
        if(!stack.isEmpty())
        {
          list = stack.peek();
        }
        return list.get(0);
    }
    
    public int getMin() {
        List<Integer> list = null;
        if(!stack.isEmpty())
        {
          list = stack.peek();
        }
        return list.get(1);
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//For MinStack class
//Time Complexity : O(1), for all operations 
//Space Complexity : O(n), worst case we might have to push every element twice if all the elements are minimum than the old one.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
