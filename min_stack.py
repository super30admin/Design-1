"""
Approach:
Implement stack using list.
Create 2 stacks - one regular for push, pop
Second stack will track incoming value and maintain min out of top of stack and incoming value

Time Complexity:
push, pop, top, getMin: O(1)

Space Complexity:
O(n) since we store extra list for min

"""

class MinStack:
    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

        if self.minstack:
            min_val = min(val, self.minstack[-1])
            self.minstack.append(min_val)
            return

        self.minstack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]

def main():
    minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    print("Top value before pop: ", minStack.top())
    print("Min value before pop: ", minStack.getMin())

    minStack.pop()
    print("Top value after pop: ", minStack.top())
    print("Min value after pop: ", minStack.getMin())


if __name__ == "__main__":
    main()