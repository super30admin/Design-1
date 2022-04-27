
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//created a class with min variable and then kept hold of it
class MinStack {
    Stack head;
    static class Stack{
        int data;
        int min;
        Stack next;
        Stack(int data){
            this.data=data;
            this.next=null;
        }
    }
   

    public MinStack() {
        
        
    }
    
    public void push(int val) {
        if(head==null){
            head=new Stack(val);
            head.min=val;
                return;
        }
        
        Stack temp=new Stack(val);
        if(val<head.min)
            temp.min=val;
        else
            temp.min=head.min;
        temp.next=head;
        head=temp;

    }
    
    public void pop() {
        head=head.next;
       
    }
    
    public int top() {
       return head.data;
        
    }
    
    public int getMin() {

        return head.min;
            
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