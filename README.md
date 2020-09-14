# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
#Time Complexity: O(n)
#Space Complexity: O(n)
Here I used a simple array in java to design a hashmap. Here is the approach
1. We are already given a range of numbers, I initialized my array with the size of maximum range given and initilized the array with -1.
2. Consider array indexes as key and value at that particular value as hashmap value (Key:index, Value:value).
3. put(): Put the value at corresponding index key.
4. get(): get the value by accessing the index(key) of value. (return hashmap[key])
5. remove(): Just assign the value -1 to the corresponding index(key)(Since they have provided that if number is not present, return -1).

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
#Time Complexity: O(1)
#Space Complexity: O(n)
#Approach:
1. Created a subclass (Data Structure) Node with values int min, int val and Node next.
2. Created an Object named top of class Node.
3. Initialized top if its null with its corresponding given value, if not null, then created a new node with the value.
4. Every time when a new node is created, compared it with current min value, if it's smaller, updated the min value else just created the new node with respective value.
5. for pop(), just moved the top pointer to next value.
6. for top(), returned top value.
7. for getMin(), returned min value (top.min).




