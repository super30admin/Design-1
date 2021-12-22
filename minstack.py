'''
Time Complexity: 

push - O(1)
pop - O(1)
top - O(1)
min - O(1)

Space Complexity:

O(N)

Ran on Leetcode : yes
'''

class Node(object):
    def __init__(self, val):
        self.val = val
        self.next = None
        self.min_next = None

class MinStack(object):

    def __init__(self):
        self.stop = None
        self.min = None

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if not self.stop:
            self.stop = Node(val)
            self.min = self.stop
            return
        newnode = Node(val)
        if val <= self.min.val:
            nextmin = Node(self.min.val)
            nextmin.next = self.stop
            self.stop = newnode
            self.stop.next = nextmin
            self.min = newnode
        else:
            newnode.next = self.stop
            self.stop = newnode


    def pop(self):
        """
        :rtype: None
        """
        if not self.stop:
            return
        if self.stop.val == self.min.val:
            self.min = self.stop.next
            if self.min:
                self.stop = self.min.next
            else:
                self.stop = None
        else:
            self.stop = self.stop.next
            
    def top(self):
        """
        :rtype: int
        """
        return self.stop.val if self.stop else -1
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min.val if self.min else -1
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()