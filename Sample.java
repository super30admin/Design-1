// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Deciding between using two separate arrays or in-built Stack utilities


// Your code here along with comments explaining your approach

//I have created two stacks, the main "stack" and "minStack".
//On each push operation element is pushed onto stack
//Once the element is pushed onto main stack, next we compare the current value with the top of the minStack and only push if the current value is less than the top of the minStack.
//On each pop operation, we compare top of the minStack with the top of main stack. If top value of the main stack is equal to top of minStack then we pop from minStack as well
//top() and getMin() return the value from top of main stack and minStack respectively 