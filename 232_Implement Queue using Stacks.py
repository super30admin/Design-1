"""
Leetcode - https://leetcode.com/problems/implement-queue-using-stacks/submissions/ [Submitted]
TC - see below, SC - O(2N)
Challange - Do peek and push without flipping the stack each time to reduce time complexity

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.


Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
"""

'''
Idea - It doesn't matter how you store the data, the below operations however should give real results.
We store the data in stack format in inStack (LIFO) and in queue format (FIFO) in outStack, and while popping, 
we use outStack. When the outStack is empty, we flip elements from inStack to outStack.
'''
class MyQueue:

    def __init__(self):
        # both stack and stackQueue are stacks
        self.inStack, self.outStack = [], []

    # TC - O(1)
    def push(self, x: int) -> None:
        self.inStack.append(x)

    # TC - O(N)
    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    # TC - O(N)
    def peek(self) -> int:
        iS = self.inStack
        oS = self.outStack
        if not oS:
            while iS:
                oS.append(iS.pop())

        return oS[-1]

    # TC - O(1)
    def empty(self) -> bool:
        return not self.inStack and not self.outStack



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(1)
# obj.push(2)
# obj.pop()
# obj.peek()
# obj.empty()