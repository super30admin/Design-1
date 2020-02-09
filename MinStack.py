#// Did this code successfully run on Leetcode :Yes
#// Any problem you faced while coding this :None


#// Your code here along with comments explaining your approach
#we have implemented MinStack to retrive the minimum element in the stack.
#we have taken two stacks list1 and minstack.one to store all the elements and to store the minimum value of the stack.
#Then when push method is implemented , we insert the element in the stack list1 but then we compare the element with previous element in #the minstack and if it is less then we push the min element to the minstack.
#pop method to delete the top element from both list1 and minstack . 


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.list1=[]
        self.minstack=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        #O(1) time complexity and O(n) for space complexity
        if len(self.list1)==0:
            self.minstack.append(x)
        else:
            if self.minstack[-1]<=x:
                self.minstack.append(self.minstack[-1])
            else:
                self.minstack.append(x)
        self.list1.append(x)
        

    def pop(self):
        """
        :rtype: None
        """
        #O(1) time complexity and space complexity
        self.list1.pop()
        self.minstack.pop()

    def top(self):
        """
        :rtype: int
        """
        #O(1) time complexity and space complexity
        return self.list1[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        #O(1) time complexity and space complexity
        return self.minstack[-1]
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()