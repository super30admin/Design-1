class MinStack:
    
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else: 
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
        

def demo():
    hs = MinStack()
    print("Pushing 3")
    hs.push(3)
    print("Current min:", hs.getMin())  # 3

    print("Pushing 5")
    hs.push(5)
    print("Current min:", hs.getMin())  # 3

    print("Pushing 2")
    hs.push(2)
    print("Current min:", hs.getMin())  # 2

    print("Popping")
    hs.pop()
    print("Current min:", hs.getMin())  # 3

    print("Top element:", hs.top())     # 5
    print("All done!")



if __name__ == "__main__":
    demo()

# Time Complexity:
# - push(): O(1)
# - pop(): O(1)
# - top(): O(1)
# - getMin(): O(1)

# Space Complexity: O(n), where n is the number of elements in the stack
# Did this code successfully run on Leetcode: Yes (Problem 155 - Min Stack)
# Any problem you faced while coding this: No. Brute force is using min(): min(stack) resulting in an TC: O(n)