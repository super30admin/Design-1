public class MinStack {

    //Time Complexity=O(1) for all functionalities
    //Space Complexity=O(n)
    private class LinkedList <T>{
        T data;
        LinkedList next;

        public LinkedList(){

        }

        public LinkedList(T data){
            this.data=data;
        }
    }

    private LinkedList<Integer> st;
    private LinkedList<Integer> minstack;
    int min;
    public MinStack() {
        st=new LinkedList();
        min=Integer.MAX_VALUE;
        minstack= new LinkedList(min);
    }

    public void push(int val) {
        min=Math.min(val,min);
        LinkedList<Integer> newNode=new LinkedList(val);
        newNode.next=st;
        st=newNode;
        LinkedList<Integer> newNode1=new LinkedList(min);
        newNode1.next=minstack;
        minstack=newNode1;
    }

    public void pop() {
        st=st.next;
        minstack=minstack.next;
        min=minstack.data;
    }

    public int top() {
        return st.data;
    }

    public int getMin() {
        return min;
    }
}
