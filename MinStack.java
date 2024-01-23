import java.util.ArrayList;
import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The run time was 222ms


// Your code here along with comments explaining your approach: 
// 1.	Initialized the ArrayList where I stored the elements of MinStack.
// 2.	To implement the push function of MinStack, I used add function. Similarly, remove function of ArrayList for pop.
// 3.	When the ArryaList is not empty, I will remove the top element. Otherwise I will return -1. To implement this I used if condition, get function to retrieve the top element which is the ‘n-1’th element and set function to map it to the remove function.
// 4.	To get the minimum value, I used Math Library from which I used min function. First, I initialized the min variable that I have created. Then I used for loop to compare value present in the set with the minimum value. When the loop catches a minimum value, it will return in min variable, otherwise it will return -1.


public class MinStack {
    private ArrayList <Integer> set;
    public MinStack() {
        set = new ArrayList<>();
    }

    public void push(int val) {
        set.add(val);
    }

    public void pop() {
        if (!set.isEmpty()) {
            set.remove(set.size() - 1);
        }
    }

    public int top() {
        if (!set.isEmpty()) {
            return set.get(set.size() - 1);
        }
        return -1;
    }

    public int getMin() {
        if (!set.isEmpty()) {
            int min = set.get(0);
            for (int value : set) {
                min = Math.min(min, value);
            }
            return min;
        }
        return -1;
    }
}
