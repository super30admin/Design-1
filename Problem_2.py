'''
Keep track of minimum element each time in the form on tuple (current_element, current_min)
check previous min and push the tuple on the stack
if stack is empty then the current element will also be the current minimum
'''

class MinStack:

    def __init__(self):
        self.st = []

    def push(self, val: int) -> None:
        if not self.st:
            self.st.append((val, val))
        else:
            _, curr_min = self.st[-1]
            self.st.append((val, min(val, curr_min)))

    def pop(self) -> None:
        if self.st:
            self.st.pop()

    def top(self) -> int:
        return self.st[-1][0]

    def getMin(self) -> int:
        return self.st[-1][1]
    

minst = MinStack()
minst.push(-2)
minst.push(0)
minst.push(-3)
print(minst.getMin())
minst.pop()
minst.top()
print(minst.getMin())
