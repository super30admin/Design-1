"""
Time Complexity: 
push: O(1)
pop: O(1)
top: O(1)
getMin: O(1)
getMax: O(1) 
checkAndPopMin: O(1)
checkAndPopMax: O(1)
checkAndPushToMin: O(1)
checkAndPushToMax: O(1)

Space Complexity:
Stack Space: O(n)
Min Stack Space: O(n)
Max Stack Space: O(n)

Approach:
 we maintain a primary stack array to store the elements into the stack now this 
 primary snack acts like a normal stack, 
 but we also have an auxiliary stack along with this. 
 This auxiliary stack helps us in maintaining or tracking the minimum element. 
 We push elements to this auxiliary stack only when the incoming element is lesser
 than the already existing minimum element present in the auxiliary stack 
 and we pop out the elements from this auxiliary stack. 
 Only when the element that is getting popped from the main stack is equal to the element that is already present 
 and the top most of this auxiliary stack by this we can achieve all the operations in constant time.
 
 PS: Also did the same approach for the maximum element.

"""


class MinStack:
    
    def __init__(self):
        self.min_stack = []
        self.stack = []
        self.max_stack = []


    def push(self, val: int) -> None:
        self.stack.append(val)
        self.checkAndPushToMax(val)
        self.checkAndPushToMin(val)
       
        # update the min_stack

    def pop(self) -> None:
        element = self.stack.pop()
        self.checkAndPopMax(element)
        self.checkAndPopMin(element)
        return element
       

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if len(self.min_stack)==0:
            return int(sys.maxsize)
        return self.min_stack[-1][0]

    def getMax(self) -> int:
        if not self.max_stack:
            return -2**31
        return self.max_stack[-1][0]

    def checkAndPopMin(self, element)-> None:
        if len(self.min_stack)>0:
            min_element, count = self.min_stack[-1]
            if min_element == element:
                if count>1: 
                    self.min_stack[-1][1]-=1 
                else:
                    self.min_stack.pop()

    def checkAndPopMax(self, element)-> None:
        if len(self.max_stack)>0:
            max_element, count = self.max_stack[-1]
            if max_element == element:
                if count > 1: 
                    self.max_stack[-1][1]-=1 
                else:
                    self.max_stack.pop()
    
    def checkAndPushToMin(self, val)->None:
        if len(self.min_stack)==0 or val < self.min_stack[-1][0] :
            self.min_stack.append([val, 1])
        elif val == self.min_stack[-1][0]:
            self.min_stack[-1][1]+=1


    def checkAndPushToMax(self, val)->None:
        if len(self.max_stack)==0 or val > self.max_stack[-1][0] :
            self.max_stack.append([val, 1])
        elif val == self.max_stack[-1][0]:
            self.max_stack[-1][1]+=1


