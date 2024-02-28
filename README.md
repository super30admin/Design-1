Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)
Used array of boolean arrays as the underlying datastructure to implement 'double hashing'. Used 2 hash functions for computing the storage index of each key. Set the size of array of boolean arrays to 1000 which is the square root of the upper limit of the input range, ie, 10^6 


## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
Used 2 stacks - one regular stack and one minStack to keep track of minimum values seen so far. Only add a new element to the minStack if the new value is either less than or equal to the top value on minStack, ie, minimum value seen so far. This way, we always have minimum value seen so far at the top of the minStack. While popping from stack, also pop if corresponding value is present in minStack.