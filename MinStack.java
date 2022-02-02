public class MinStack()
{

}












//public class MinStack {
//    int top ;
//    int minValueTop;
//    static final int MAX=1000;
//    // List minStack = new ArrayList<Integer>();
//    // List minValueStack = new ArrayList<Integer>();/**/
//    int minStack[] = new int[MAX];
//    int minValueStack[] = new int[MAX];
//    int minValue;
//    public MinStack() {
//        int top=-1;
//        int minValueTop =-1;
//    }
//
//
//    public void push(int val) {
//        if (top >= MAX-1)
//        {
//            System.out.println("Stack Overflow");
//        }
//        else{
//            top= top+1;
//            minStack[top] = val;
//
//            if (minValueStack[minValueTop] > val)
//            {
//                minValueTop = minValueTop+1;
//                minValueStack[minValueTop] = val;
//            }
//        }
//    }
//
//    public void pop() {
//        if (top < -1)
//        {
//            System.out.println("Stack underflow");
//
//        }
//        else{
//            int valuePopped = minStack[top];
//            top = top-1;
//            if(minValueStack[minValueTop] == valuePopped)
//            {
//                minValueTop = minValueTop-1;
//            }
//        }
//    }
//
//    public int top() {
//        return minStack[top];
//    }
//
//    public int getMin() {
//
//        int min =  minValueStack[minValueTop];
//        return min;
//    }
//
//
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */