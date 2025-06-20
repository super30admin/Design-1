"""
# Time Complexity :
Push - O(1)
Pop - O(1)
Top - O(1)
GetMin - O(1)

# Space Complexity : O(N), where N is the number of elements in the stack

# Did this code successfully run on Leetcode :
Yes

# Any problem you faced while coding this :

- No

"""

#Explanation (within 3 lines) - Made use of a stack with a pair of elements, one which tells us the current
# top of the stack, and the second which tells us the min element in the stack at that point

class MinStack:

    def __init__(self):
        self.stack = deque() #using in-built deque as stack for code clarity, and guaranteed O(1) ops, vs. list which is amortized O(1)
        

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val, val)) #initially element itself is min
        else:
            newMin = min(val, self.stack[-1][1]) #else check pair at top of stack to compare for min value
            self.stack.append((val, newMin)) #append a new pair - the new element and the new min value

    def pop(self) -> None:
        self.stack.pop() #popping out does not affect us since the new top holds the correct min value

    def top(self) -> int:
        return self.stack[-1][0] #0th index of top holds the top element of the stack
        

    def getMin(self) -> int:
        return self.stack[-1][1] #1th index of top holds the min element of the stack


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
