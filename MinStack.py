# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not really, found this one to be easier than HashMap, I used code from previous assignment




#using a linked list allows us to do all operations in constant time, we only need access to head
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.min = 0

class MinStack:


    def __init__(self):
        self.start_node = None

        """
        initialize your data structure here.
        """


    def push(self, x: int):
        #keeping track of min value every time a node is added allows us to get min value in O(1) runttime

        if self.start_node == None:
            self.start_node = Node(x)
            self.start_node.min = x
        else:
            prev_min = self.start_node.min
            new_head = Node(x)
            new_head.next = self.start_node
            self.start_node = new_head


            self.start_node.min = min(prev_min, x)



    #O(1) runtime
    def pop(self):
        if(self.start_node != None and self.start_node.next != None):      #if more than one node in stack
            remove = self.start_node
            self.start_node = self.start_node.next
            remove.next = None

            remove.data
        elif(self.start_node != None and self.next == None):    #if only one node in stack
            self.start_node = None

        else:
            None




    def top(self):
        self.start_node.data


    def getMin(self):
        if self.start_node == None:
            -1
        else:
            self.start_node.min



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

#edited
