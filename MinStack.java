// Time Complexity : O(1) for each operation
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

import java.util.Stack;

public class MinStack{// made a structure for 
    class MinCount
    {
        int min;
        int count;
        MinCount(int min, int count)
        {
            this.min = min;
            this.count = count;
        }
    }
//using 2 stacks one to keep a count and one to carry actual items
    Stack<Integer> items = new Stack<>();
    Stack<MinCount> count = new Stack<>();
    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void push(int item) {
        items.push(item);// inserting an element to items stack
        if(!count.isEmpty()){
            if(item <  count.peek().min)// if element inserted is minimum then previous one insert to count stack
            {
                count.push(new MinCount(item,1));
            }
            else if(item == count.peek().min)//if minimum element is inserted again increase count
            {
                count.peek().count++;
            }
        }
        else{
            count.push(new MinCount(item, 1));//if count is empty insert new record
        }
    }
    public void pop() {
        if(this.isEmpty())
        {
            System.out.println("Cannot pop() stack is empty");
        }
        int poppedElement = items.pop();
        if(poppedElement == count.peek().min){// if item popped is minimum
            count.peek().count--;//decrement its count
            if(count.peek().count == 0)//if after decrementing it becomes zero pop it out of count stack
            {
                count.pop();
            }
        }

    }
    public int top() {
        return items.peek();// top item from items stack
    }
    public int getMin() {
        if(this.isEmpty()){
            System.out.println("Cannot pop if stack is empty");
        }
        return count.peek().min;// will be min variable of top item in the count stack
    }

    public static void main(String args[])
    {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(1);

        int param_1 = obj.getMin();
        System.out.println(param_1);

        obj.pop();

        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
       
    }

}