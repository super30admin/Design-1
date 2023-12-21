// Problem 1: Design Hashset
// Time Complexity : add - O(1), remove - O(1), contains - O(1)
// Space Complexity :  O(N + M)
// where N is the number of buckets (this.bucket) and M is the number of elements in each bucket (this.bucketItem)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes in the add function I was not able to understand the condition
// if(arrayIndex == 0) {
//                storage[arrayIndex] = new boolean[subarrayIndex + 1];
//            }
//
// Your code here along with comments explaining your approach:
// Double hashing: We create a primary array of square root of the range,
// then create another boolean array for each entry in the primary array which stores a boolean value of a given number
// at a unique index determined by modulo and division functions

// Problem 2: MinStack
// Time Complexity : push - O(1), pop - O(1), peek - O(1), getmin - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// doubt - what is the peek() function internally?

// Your code here along with comments explaining your approach
// We've used 2 stacks, st stack to store the actual elements pushed into the stack.
// The minSt stack is used to keep track of the minimum element at the top of the stack at any given point.
