//Time Complexity: O(1) for all operations
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes
/* Did not understand why we are pushing the min element in the constructor itself.
what if we push it in the push function whenever we are pushing value to the actual stack.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    //maintaining two stacks
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.minStack.push(this.min);
    }

    public void push(int val) {
        // push the value to original stack
        //push the min value to minStack after comparing
        this.stack.push(val);
        if (val < this.min){
            this.min = val;
            this.minStack.push(this.min);

        } else { // here we are maintaining min value for each and every stack value
            this.minStack.push(this.minStack.peek()); // if min value doesnt change just push the top val
        }
    }

    public void pop() {
        //if you are poping from original stack pop from min stack as well
        this.stack.pop();
        this.minStack.pop();
        this.min = this.minStack.peek(); // after poping top element will be the new min
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
    public static void main(String args[]) {
        //        Reading input
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        input1 = input1.replaceAll("[\\[\\]\"]", "");
        String[] operations = input1.split(",\\s*");
        sc.nextLine();
        String valuesLine = sc.nextLine();

        valuesLine = valuesLine.substring(1, valuesLine.length() - 1);

        String[] parts = valuesLine.split("],\\s*\\[");

        List<List<Integer>> values = new ArrayList<>();

        for (String part : parts) {
            part = part.replaceAll("[\\[\\]]", "");
            List<Integer> nums = new ArrayList<>();

            if (!part.isEmpty()) {
                for (String num : part.split(",")) {
                    nums.add(Integer.parseInt(num.trim()));
                }
            }

            values.add(nums);

        }

        MinStack ms = new MinStack();
        for (int i = 0; i<operations.length;i++) {
            switch (operations[i]){
                case "push":
                    ms.push(values.get(i).get(0));
                    break;
                case "pop":
                    ms.pop();
                    break;
                case "top":
                    ms.top();
                    break;
                case "getMin":
                    ms.getMin();
                    break;
            }
        }
        System.out.println(values);
    }
}
