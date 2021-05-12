class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min_stack = []
        

    def push(self,x):
        self.stack.append(x)
        if len(self.min_stack) == 0:
            self.min_stack.append(x)
        else:
            self.min_stack.append(min(x,self.min_stack[-1]))
        """
        :type x: int
        :rtype: None
        """
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.min_stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]

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



