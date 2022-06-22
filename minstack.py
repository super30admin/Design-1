 # Time Complexity : O(1) for all functions
 # Space Complexity : O(n)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : None

class MinStack:
    # initialising empty two stacks
    def __init__(self):
        self.stack = [] # Main Stack
        self.min_stack = [] # Stack to track minimum

    # Function to push elements into two stacks
    def push(self,val):
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    # Function to remove top elements from two stacks
    def pop(self):
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        return self.stack.pop()

    # Function to display top element from the stack
    def top(self):
        return self.stack[-1]

    # Function to get the minimum element from the given inputs
    def getMin(self):
        return self.min_stack[-1]

    def print_stack(self):
        print(self.stack)
        print(self.min_stack)

a_stack = MinStack()
while True:
    #Give input as string if getting an EOF error. Give input like "push 10" or "pop"
    print('push <value>')
    print('pop')
    print('top')
    print('getMin')
    print('print')
    print('quit')
    do = input('What would you like to do? ').split()
    #Give input as string if getting an EOF error. Give input like "push 10" or "pop"
    operation = do[0].strip().lower()
    if operation == 'push':
        a_stack.push(int(do[1]))
    elif operation == 'pop':
        popped = a_stack.pop()
        if popped is None:
            print('Stack is empty.')
        else:
            print('Popped value: ', int(popped))
    elif operation == 'top':
        print(f"The top element is: {a_stack.top()}")
    elif operation == 'getMin':
        print(f"The Minimum element of the stack is: {a_stack.getMin()}")
    elif operation == 'print':
        a_stack.print_stack()
    elif operation == 'quit':
        break
