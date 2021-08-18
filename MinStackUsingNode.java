//Time complexity: O(1)
//Space complexity: O(1)
class MinStackUsingNode {

    Node last;

    //create a node to maintain the next pointer, minimum value and value to push.
    static class Node {
        int val, currentMin;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    MinStackUsingNode() {

    }
   
    public void push(int val) {
        Node newNode = new Node(val);
        //if this is the first element to be pushed, the currentMin will the valuue to be pushed.
        if(last == null) {
            newNode.currentMin = val;
        }
        //else we will compare the element to be inserted with the currentMin.
        else{
            newNode.currentMin = Math.min(last.currentMin, val);
        }
        //push newNode to the end
        newNode.next = last;
        last = newNode;
    }
   
    public void pop() {
        last = last.next;
    }
   
    public int top() {  
        return last.val;
    }
   
    public int getMin() {
        return last.currentMin;
    }
    
}