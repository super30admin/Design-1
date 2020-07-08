//Problem 1 -  MyHashMap
// Time Complexity : O(1) in amortized case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//To design a hashmap, I will keep array of Nodes. To generate hash, I am using hashcode on key and bounding
// it by the maximum size of possible input. Each array index will contain a linked list. Whenever we need to store a key,
//we generate the hash value and store the input value at correct hash index. If there are conflicts in hash, we add the
// value to the linked list, storing both key and value as node in Linked list. To remove a value from hashmap, we first get the hash of the key,
//that acts as index. If the key is present at linkedList at that index, we return the value else -1;


//Problem 2 - MinStack
// Time Complexity : O(1) amortized case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem faced


// Your code here along with comments explaining your approach
// My approach is keeping minimum values in another stack, stack B. Whenever pushing new value in the stack, compare
// the top element at stack B.If the new element is less, push the element in both stack A and B. If the element is larger,
// push the element only in stack A. Whenever we are popping, again we will compare top of two stacks. If the element
// at stack is more than stack b, we will pop element from stack A only else, we will pop from both stacks.