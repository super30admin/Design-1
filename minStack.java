// Time Complexity : O(1)
// Space Complexity :O(n) n-size of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not able to think about how to maintain minmum value(I took help)


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    List<Integer>list;

    /** initialize your data structure here. */
    
    
   /* public MinStack() {
       list=new ArrayList<>(); 
    }
    
    public void push(int x) {
        list.add(x);
        
    }
    
    public void pop() {
        list.remove(list.size()-1);
        
    }
    
    public int top() {
        return list.get(list.size()-1);
        
    }
    
    public int getMin() {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(list);
        return minHeap.remove();
        
        
    }*/
    private Node head;
    
    
    public void push(int val) {
        if(head==null){
            head=new Node(val, val,null);
        }else{
            head=new Node(val, Math.min(val,head.min),head);
        }
        
    }
    
    public void pop() {
        head=head.next;
        
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
        
    }
    
    private class Node{
        int val;
        int min;
        Node next;
        Node(int val, int min, Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
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
