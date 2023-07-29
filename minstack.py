#Time complexity:- O(1)
#Space Complexity:-O(n)

class MinStack:

    def __init__(self):
        #initialize variables for stack,minstack and min to the minimum value
        self.stack=[]
        self.minstack=[]
        self.min=int(sys.maxsize)
        self.minstack.append(self.min)
        

    def push(self, val: int) -> None:
        #value will be updated only if it is less than earlier min value, minstack and stack values are
        #updated irrespective of the if condition to maintain the equality between two stacks
        if val <=self.min:
            self.min = val
        self.minstack.append(self.min)
        self.stack.append(val)
        

    def pop(self) -> None:
        #minimum value will be updated only if last values of stack and minstack are same
        popped = self.stack.pop()
        self.minstack.pop()
        if popped==self.min:
            self.min=self.minstack[-1]

        

    def top(self) -> int:
        # retreiving the top value of the stack
        return self.stack[-1]
        