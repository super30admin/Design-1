'''
https://leetcode.com/problems/min-stack/

Time Complexity :
O(1) for all operations

Space Complexity :
O(n)

Did this code successfully run on Leetcode :

Yes

Conceptual Approach:

Have each element keep track of the last known min element when it was pushed. When it's popped make sure to update
the last known min element!

Edge Cases:

- Popping the min element - taking this to the extreme imagine we pop all the min elements one after another until the stack is empty

Hence we need to keep track of all the elements from min to max as we push values - but obviously we can't use something like a heap as every operation
needs to be constant. This gives us the hint that we will somehow need to use an array to have this constant time complexity.

- Are duplicate elements allowed?

Yeah, it seems that way

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- -2^31 <= val <= 2^31 - 1
All integer values will be valid

- Methods pop, top and getMin operations will always be called on non-empty stacks.
So I don't have to worry about handling this edge case essentially

- At most 3 * 10^4 calls will be made to push, pop, top, and getMin.

This means we will essentially have an absolute maximum of 30,000 elements on our stack which we can design for and technically have constant space

- Every operation must be implement O(1) times -> The only what I can do this is by sacrificing space complexity somehow

Any problem you faced while coding this:

At first it was very difficult how to do this without maintaining a full list of all the minimums in order
but once you gain the insight that if you keep a running track of the lowest_value, and store node values instead
of just integer values this problem becomes very achievable
'''
from dataclasses import dataclass

@dataclass
class Node:
    value: int
    last_known_lowest_element: 'Node'

class MinStack:

    def __init__(self):
        self.lowest_element = None
        self.values = []

    # time: O(1)
    def push(self, value: int) -> None:
        new_element = Node(value, self.lowest_element)
        # If this is lower than the new lowest element we update the new lowest_element
        if self.lowest_element == None or value <= self.lowest_element.value:
            self.lowest_element = new_element

        self.values.append(new_element)

    # Time O(1)
    def pop(self) -> None:
        top_of_stack = self.values.pop()
        self.lowest_element = top_of_stack.last_known_lowest_element

    # time: O(1)
    def top(self) -> int:
        return self.values[-1].value

    # Time: O(1)
    def getMin(self) -> int:
        return self.lowest_element.value