
'''

Time Complexity : O(1) since all operations are constant time opertaions
Space Complexity : We are declaring two linked lists hence space complexity is O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced


'''


class Node():
    def __init__(self,num):

        self.num = num
        self.next = None           # defining class for Node

class MinStack:

    def __init__(self):
        self.stack = None
        self.min_stack = None       # initialising two stacks, one the actual stack and other one is min stack

        min = Node(float('inf'))
        min.next = self.min_stack       # Making the first entry of min stack equal to + infinity
        self.min_stack = min


    def push(self, val: int) -> None:
        new_node = Node(val)
        new_node.next = self.stack
        self.stack = new_node

        if val < self.min_stack.num:
            min = Node(val)
            min.next = self.min_stack
            self.min_stack = min                    # Pushing entries into both stacks simultaneously

        else:
            min = Node(self.min_stack.num)
            min.next = self.min_stack
            self.min_stack = min


    def pop(self) -> None:
        if self.stack is not None:
            self.stack = self.stack.next                # Popping entries simultaneously
        self.min_stack = self.min_stack.next

    def top(self) -> int:
        return self.stack.num


    def getMin(self) -> int:
        return self.min_stack.num



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()