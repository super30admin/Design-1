// time complexity = O(1)
// space complexity = O(n)
class MinStack {

    public class Element{
        int val;
        Element next;

        public Element(int val){
            this.val=val;
        }

    }
    public MinStack() {

    }

    Element top = null;
    int min;

    public void push(int val) {
        if(top==null) {
            min=val;
            Element temp = new Element(val);
            top = temp;
        } else {
            Element temp = new Element(val);
            min = Math.min(min,val);
            temp.next=top;
            top=temp;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        } else{
            Element temp = top.next;
            top=temp;
        }
    }

    public int top() {
        if (top == null) {
            return -1;}
        return top.val;
    }

    public int getMin() {
        if (top == null) {
            return -1;}
        return min;
    }
}
