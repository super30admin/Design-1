'''
MinStack:

push() & pop():-
In this approach, I considered 2 stacks:
1. st - in this stack a element is insterted for every push operation and removed for every pop operation
2. minSt - in this stack corresponding to every pop operation in st stack a min element is inserted,
           when pop operation is perfomed corresponding min element is popped as it already has the previous small elemnt stored in this stack

top():-
last inseted element of the st

getMin():-
last elemnt of minSt or min value
'''

class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.min = 2**31 -1
        self.minSt.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(self.min, val)
        self.st.append(val)
        self.minSt.append(self.min)

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.min = self.minSt[-1]

    def top(self) -> int:
        return self.st[-1]
        # return self.minSt[-1]

    def getMin(self) -> int:
        return self.min