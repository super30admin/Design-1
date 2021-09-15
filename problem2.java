// Time Complexity : o(n) for checking minimum in arraylist.
// Space Complexity :o(n) for for arraylist size as it is dynamic.
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : yes, minimum updation was the part that I struck almost.


// Your code here along with comments explaining your approach:- arraylist is created in which elements are pushed ,simultaneously minimum is traced in arraylist and updated after every push and pop.








import java.util.ArrayList;
class MinStack {

    /** initialize your data structure here. */
    ArrayList<Integer> l;
    int min;
    
    public MinStack() {
        min=Integer.MAX_VALUE;
        l= new ArrayList<Integer>();
        
    }
    
    public void push(int val) {
        l.add(val);
        scanMin();
     }
    
    public void pop() {
        l.remove(l.size()-1);
        scanMin();
        
        
    }
    
    public int top() {
    return l.get(l.size()-1);
         
        
    }
    
    public int getMin() {
    return min; }
    public void scanMin() {
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < l.size(); i++) {
			if (minVal > l.get(i)) {
				minVal = l.get(i);
			} 
		}

		this.min = minVal;
	}
}