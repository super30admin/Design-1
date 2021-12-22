// Time Complexity :
//      push = O(1)
//      pop = O(1)
//      top = O(1)
//      getMin = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
class MinStack {
    Node head;
    class Node{
        int data;
        Node next;
        int min ;
        Node(int d)
        {
            data = d;
        }
    }

    public MinStack() {
        head = null;
    }

//     public void print()
//     {
//         Node n = head;
//         while(n!=null)
//         {
//             System.out.print(" "+n.data+" ");
//             n=n.next;
//         }
//     }

    public void push(int val) {
        Node q = new Node(val);

        if(head==null)
        {
            q.next = null;
            head = q;
            q.min = val;
        }
        else{
            q.next = head;
            q.min = Math.min(head.min, val);
            head = q;
        }
        // print();
    }

    public void pop() {
        head = head.next;
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