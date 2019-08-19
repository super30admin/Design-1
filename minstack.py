class MinStack(object):

    def __init__(self):
        self.s = []

    def push(self,x):
        cur_min = self.getMin()
        if cur_min == None or x < cur_min:
            cur_min = x
        self.s.append((x,cur_min))

    def pop(self):
        self.s.pop()

    def top(self):
        if not self.s:
            return None
        return self.s[-1][0]

    def getMin(self):
        if not self.s:
            return None
        return self.s[-1][1]


# driver code
Test = MinStack()
Test.push(5)
Test.push(3)
Test.push(-1)
Test.push(0)
Test.push(9)
Test.pop()
print Test.top()
print Test.getMin()

# Explanation
""" 
The approach is to use one array and tuples inside the array to store each element 
of the inputed and also store the min value in the array till the point. At each 
push operation we are checking if the pushed element is less than the cur_min till
the point, if yes then update cur_min and append the element and the cur_min else 
append the element with the unchanged cur_min value.
 """



