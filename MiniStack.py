# / Time Complexity : push O(1), pop O(1), top O(1), mini O(1)
# // Space Complexity : two stacks each stack size of O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no


class MinStack(object):
    # what's the primitive data sturture to use : array
    # array the append and the pop operation happen in the end O(1)
    # using dynamic array 

    def __init__(self):
        self.stack = []
        self.ministack =   []
        # two ways of storing the min value 
        # using a data member to keep track of the min value so, when min required it's O(1) but the edge condition is
        # when the min val is popped then the value is no longer he min value, so just a variable is not good enough, we can llose track ofthe min elemenst in the array
        # so keep one more stack to keep track of the minvalue of th stak 

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if not self.ministack:
            self.ministack.append(val) # so if the ministack is empty the first case, add the elemet
        else:
            self.ministack.append(min(val, self.ministack[-1])) # so for every push operation, we keep adding the min value in the minstack


    def pop(self):
        """
        :rtype: None
        """
        if self.stack: # stack not empty
            self.stack.pop() 
            self.ministack.pop() # also pop from ministack,which help in keeping history of min values of the stack


    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.ministack:
            return self.ministack[-1]

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()