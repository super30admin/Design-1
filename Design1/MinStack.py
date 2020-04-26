#Time Complexity: O(1) for getMin
#Space Complexity: O(n)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:

#TWO STACKS IMPLEMENTATION
class MinStack:
    '''
    main idea: we will create two stack , one with the data, and the second with the minimum until now.
    At each step we check if the new number is our new min, if not we just push old min in the minstack.
    Every time we pop from the min stack, we get the minimum up until what's left in the stack

    '''

    def __init__(self):
        self.stack=[]
        self.min=float('inf')
        self.minstack=[self.min]
        # so when there's no item in stack, the minimum that we return is inf



    def push(self, x: int) -> None:
        self.min=min(x,self.min)
        self.stack.append(x)
        self.minstack.append(self.min)


    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.min=self.minstack[-1] #very important to reset the minimum, or else next time we push it will compare with a minimum that might be gone!!!

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]
