
class MinStack:
    '''
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

    You must implement a solution with O(1) time complexity for each function.

    Example 1:
        Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

        Output
        [null,null,null,null,-3,null,0,-2]

        Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2

    Solution
        1. Keep two separate stacks, main stack and min stack
           For each new item pushed to main stack, compute a running min which is the min of all numbers from bottom to top of main stack. The running min is computed by "curr_min". "curr_min" is initialized to
           infinity.

           For each new item pushed to the stack, "curr_min" is computed as,
                curr_min = min(curr_min, new item)
           Push new item to main stack
           Push curr_min to min stack

           For each pop,
           Pop from main stack
           Pop from min stack

           Example:
                push(-2), push(0), push(-3)
                    mainStack  = [-2, 0, -3]
                    minStack = [-2, -2, -3]
                    getMin = -3 (minStack[-1])
                pop()
                    mainStack = [-2, 0]
                    minStack = [-2, -2]
                    top mainStack = 0
                    getMin = -2 (minStack[-1])

           Time: O(1), Space: O(N)
    '''
    def __init__(self):
        '''
            init stack

            Time: O(1), Space: O(1)
        '''
        self.main_stack = []
        self.min = float('inf')
        self.min_stack = [self.min]
        self.length = 0

    def push(self, val: int) -> None:
        '''
            push item to stack

            Time: O(1), Space: O(1)
        '''
        self.main_stack.append(val)
        self.min  = min(self.min, val)
        self.min_stack.append(self.min)
        self.length += 1
        print(f"push {val}: main stack = {self.main_stack}, min stack = {self.min_stack}, stack len = {self.length}")


    def pop(self) -> None:
        '''
            pop item from stack

            Time: O(1), Space: O(1)
        '''
        if self.length > 0:
            val = self.main_stack.pop()
            self.min_stack.pop()
            self.min = self.min_stack[-1]
            self.length -= 1
            print(f"popped {val}: main stack = {self.main_stack}, min stack = {self.min_stack}, stack len = {self.length}")

        else:
            print(f"Cannot pop, Empty stack")


    def top(self) -> int:
        '''
            top item to stack

            Time: O(1), Space: O(1)
        '''
        val = None
        if self.length > 0:
          val = self.main_stack[-1]
        print(f"top: main stack = {val}")
        return val

    def getMin(self) -> int:
        '''
            get min value of stack

            Time: O(1), Space: O(1)
        '''
        print(f"getMin(): {self.min}")
        return self.min

def run_min_stack():
    print(f"\n --- MinStack --- ")
    minStack = MinStack()
    # minStack.push(-2)
    # minStack.push(0)
    # minStack.push(-3)
    # minStack.getMin() # return -3
    # minStack.pop()
    # minStack.top()    # return 0
    # minStack.getMin() # return -2
    # minStack.pop()
    # minStack.getMin() # return -2

    minStack.push(5)
    minStack.getMin() # 5
    minStack.push(9)
    minStack.getMin() # 5
    minStack.push(4)
    minStack.getMin() # 4
    minStack.pop()
    minStack.getMin() # 5
    minStack.push(12)
    minStack.pop()
    minStack.getMin() # 5
    minStack.push(3)
    minStack.getMin() # 3
    minStack.pop()
    minStack.getMin() # 5
    minStack.pop()
    minStack.getMin() # 5
    minStack.pop()
    minStack.getMin() # inf

run_min_stack()