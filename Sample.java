// Time Complexity : Design a HashSet
/*
 * Add Element: O(1)
 * Remove Element: O(1)
 * Contains Element: O(1)
 */
// Space Complexity : Since we are using an array of size 1000001 , it will take auxiliary space of O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Explanation: Design a HashSet
 * I created an array of size 1000001 , since in the constraints it was given the values of keys lies between 0 to 1000000. And filled the arrays with -1.
 * For Add Element: In the array , I used key as Index and stored the key.
 * For Remove Element: I used key as Index , and place -1 there.
 * Contains Element : I am checking whether the array[key] is not equal to -1, if it is equal to -1 then it does not contain element otherwise it does.
 */

 // Time Complexity : Min Stack
/*
 * Push Element: O(1)
 * Pop Element: O(1)
 * top Element: O(1)
 * getMin()  : O(1)
 */
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Explanation: Min Stack
 * Created a Global variable(minEle), when pushing any element to stack we check whether the element is less than minEle , then we push corrupted value into the stack (2*x - minEle) and update the minEle.
 * Pop Operation : checking if previous min is greater than or equal to the popped element then we update the (minEle = 2*minEle - poppedElement)
 * getMin() : return minEle
 * peek() : checking if top is less than or equal to minEle , then in that case return the minEle otherwise return the top element
 */

