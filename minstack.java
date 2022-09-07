//Time Complexity:O(1)
//Space Complexity:O(1) - Using a pair instead of Minstack


class Pair{
    int value;
    int min;
    
    public Pair(int a ,int b){
        this.value=a;
        this.min=b;
    }
}


public class minstack {

    int min=Integer.MAX_VALUE;
    Stack<Pair> st;
    public MinStack() {
        st=new Stack();
    }
    
    public void push(int val) {
        
        Pair p = new Pair(val, Math.min(min,val));
        min=p.min;
        st.push(p);
    }
    
    public void pop() {
        st.pop();
        if(st.isEmpty()){
            min=Integer.MAX_VALUE;
        }else{
            min=st.peek().min;
        }
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}