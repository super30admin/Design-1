
// Time Complexity: for each of push, pop, min, top time complexity is O(1)
//Space Complexity: O(n)
class MinStack {

    /** initialize your data structure here. */

    Element head;
    Element tail;

    public MinStack() {
        head=null;
        tail=null;
    }

    public void push(int val) {
        Element e=new Element(val);

        if(head==null)
        {
            head=e;
            tail=e;
            e.min=val;
        }
        else
        {
            if(tail.min< val)
                e.min= tail.min;
            tail.next=e;
            e.prev=tail;
            tail=tail.next;
        }

    }

    public void pop() {

        if( head!= null)
        {
            // assign tail to its previous pointer
            tail=tail.prev;

            // tail ==null means that the stack is empty ..so in that case we have just removed the only element present in stack.
            // Hence head pointer should be null

            if(tail!=null)
                tail.next=null;
            else
            {
                head=null;
            }
        }
    }

    public int top() {
        if(head==null)
            return -1;
        return tail.value;
    }

    public int getMin() {
        if(head==null)
            return -1;

        return tail.min;
    }
}
class Element{
    int value;
    Element next;
    Element prev;
    int min;

    public Element(int value)
    {
        this.value=value;
        next=null;
        prev=null;
        min=value;
    }
}
