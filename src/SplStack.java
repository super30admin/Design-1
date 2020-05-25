import java.util.Stack;

/**
 * Implementation of SplStack using Stack
 */
public class SplStack {
    Stack<Integer> stk;
    int min_ele,size,capacity;

    SplStack(){
        stk = new Stack<Integer>();
        min_ele = Integer.MAX_VALUE;
        capacity = 16;
        size = 0;
    }

    /**
     * returning min ele in the stack at current point of time
     * @return min ele
     */
    public int getMin(){
        return min_ele;
    }

    /**
     * chk is the stk is full, if so return false else add the ele using std stack push method and increase the size
     * @param ele
     * @return boolean
     */
    public boolean push(int ele){
        if(isFull())
            return false;
        if(ele < min_ele)
            min_ele = ele;
        stk.push(ele);
        size++;
        return true;
    }

    /**
     * chk if the stack is empty, if so return false i.e., nothing to pop else pop the recent element inputed and if that is min_ele then find the min ele again amongst the available elements
     * @return boolean
     */
    public int pop(){
        if(isEmpty())
            return -1;
        int pop_ele = stk.pop();
        size--;
        if(pop_ele == min_ele)
            min_ele = searchMin();
        return pop_ele;
    }

    /**
     * find the min ele amongst the current elements in the stack.
     * @return min ele
     */
    public int searchMin(){
        int min = Integer.MAX_VALUE;
        int size = stk.size();
        for(int i=0;i<size;i++)
        {
            if(stk.get(i) < min)
                min = stk.get(i);
        }
        return min;
    }

    /**
     * chk if the stack is empty
     * @return boolean
     */
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    /**
     * chk if the stk is full
     * @return
     */
    public boolean isFull(){
        if(size == capacity)
            return true;
        return false;
    }
    public static void main(String[] args){
        SplStack stack = new SplStack();
        System.out.println(stack.getMin());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.push(100)+" "+stack.push(20));
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
