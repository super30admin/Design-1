class MinStack:

    def __init__(self):
        self.stack = []               #we are using two stacks stack and minstack.
        self.minstack = []              #in stack we store all values. in minstack we store min value
        self.min = int(sys.maxsize)


    def push(self, val: int) -> None:    #TC - O(1)  #SC:O(1)
        self.stack.append(val)          #pushing the value into the stack. if the val is less than min. assigning val to min then appending min on to minstack also.
        if val <= self.min:
            self.min = val

        self.minstack.append(self.min)

    def pop(self) -> None:                          #TC - O(1)  #SC:O(1)
        self.stack.pop()                                     #popping the value in stack and minstack only if the len of minstack is greater than 0.
        self.minstack.pop()
        if len(self.minstack) > 0:
            self.min = self.minstack[-1]
        else:
            self.min = int(sys.maxsize)  

    def top(self) -> int:                          #TC - O(1)  #SC:O(1)    ,, 
        return self.stack[-1]


    def getMin(self) -> int:
        return self.min