// Time Complexity : PUSH:O(1) POP=0(1) TOP=O(1) GETMIN=0(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// ************************************************************** ListNode Approach ****************************************************************************************
class MinStack {

    /** initialize your data structure here. */
    ListNode root;
    public MinStack() {
        root=null;
    }
    
    public void push(int val) {
        ListNode newNode=new ListNode(val);
        if(root==null){
            root=newNode;
            root.min=val;
            root=newNode;
        }
        else{
            newNode.next=root;
            newNode.min=Math.min(root.min,val);
            newNode.next=root;
            root=newNode;
        }
    }
    
    public void pop() {
        root=root.next;
    }
    
    public int top() {
        return root.data;
    }
    
    public int getMin() {
        return root.min;
    }
}
class ListNode{
    int data;
    int min;
    ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
        this.min=Integer.MAX_VALUE;
    }
}
// ************************************************************** Single StackMethod ****************************************************************************************
// class MinStack {

//     /** initialize your data structure here. */
//     int min;
//     Stack<Integer> minStack;
//     public MinStack() {
//         minStack= new Stack<Integer>();
//         min=Integer.MAX_VALUE;
//     }
    
//     public void push(int val) {
//         if(minStack.size()==0){
//             minStack.add(min);
//             minStack.add(val);
//             min=val;
//             return;
//         }
//         if(min>=val){
//             minStack.add(min);
//             min=val;
//         }
//         minStack.add(val);
//     }
    
//     public void pop() {
//         if(minStack.peek()==min){
//             minStack.pop();
//             min=minStack.pop();
//         }
//         else
//             minStack.pop();
//     }
    
//     public int top() {
//         return minStack.peek();
//     }
    
//     public int getMin() {
//         return min;
//     }
// }