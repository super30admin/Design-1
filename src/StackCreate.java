// Operation:           push    pop     top     gtMin
// Time Complexity:     O(1)    O(1)    O(1)     O(1)
// Space Complexity:    O(n)    O(n)    O(n)     O(n)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement in Brute force approach

package src;

import java.util.Stack;

class minStack
{
    private int min ;
    private Stack<Integer> stk ;

    public minStack()
    {
        min = Integer.MAX_VALUE ;
        stk = new Stack<>() ;
    }

    public void push(int val) {
        if(min >= val)
        {
            stk.push(min) ;                                                     // Pushing extra value(current min)
            min = val ;
        }
        stk.push(val) ;                                                         // Pushing value
    }

    public void pop() {
        int temp = stk.pop() ;                                                  // Popping top element
        System.out.println("Popped item from main stack is " + temp);
        if(temp == min)                                                         // Popping extra value(old min) pushed earlier
            min = stk.pop() ;
    }

    public int top() {
        return stk.peek() ;                                                     // Getting top element
    }

    public int getMin() {
        return min ;                                                            // Getting minimum value
    }
    public void printStack()
    {
//        System.out.println("********** Printing Stack **********");
//        stk.forEach(
//                k -> {
//                    System.out.println(""+k);
//                }
//        );
        System.out.println(stk);                                                // Printing Stack elements
    }
}

public class StackCreate
{
    public static void main(String[] args) {
        minStack s = new minStack();
        s.push(2);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(3);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(0);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(1);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        System.out.println("Top Element is " + s.top());
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(1);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(5);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(1);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.push(2);
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
        s.pop();
        s.printStack();
        System.out.println("Min val: " + s.getMin());
    }
}

// ****************************** Brute Force approach ******************************
//class minStack
//{
//    static final int MAX = 10;
//    int top = -1 ;
//    int min = -1 ;
//    int arr[] = new int[MAX];
//    int minArr[] = new int[MAX];
//
//    public void push(int val) {
//        top++ ;
//        if(top > MAX)
//        {
//            System.out.println("Stack Overflow");
//            top-- ;
//        }
//        else
//        {
//            arr[top] = val ;
//            min++ ;
//            if(min == 0)
//                minArr[min] = val ;
//            else
//            if(val <= minArr[min - 1])
//                minArr[min] = val ;
//            else
//                min-- ;
//        }
//    }
//
//    public void pop() {
//        if(top < 0)
//            System.out.println("Stack Underflow");
//        else
//        {
//            System.out.println("Popped item from main stack is " + arr[top]);
//            if(minArr[min] == arr[top])
//            {
//                System.out.println("Popped item from minStack is "+minArr[min]);
//                min-- ;
//            }
//            top-- ;
//        }
//    }
//
//    public int top() {
//        if(top > -1)
//            return arr[top] ;
//        else
//            return -1 ;
//    }
//
//    public void printStack()
//    {
//        System.out.println("********** Printing arr **********");
//        for ( int i=0 ; i<=top ; i++ ) {
//            System.out.println(arr[i]);
//        }
//        System.out.println("********** Printing minArr **********");
//        for ( int i=0 ; i<=min ; i++ ) {
//            System.out.println(minArr[i]);
//        }
//    }
//
//    public int getMin() {
//        if(min > -1)
//            return minArr[min] ;
//        else
//            return -1 ;
//    }
//}
