#Time Complexity : O(1)
#Space Complexity: O(n) where n is the number of elements
#The code ran successfully on leetcode
#I faced no problem while coding this


class Node:
    def __init__(self, val):
       self.val = val
       self.next = None

class MinStack(object):

    def __init__(self):
        #we are initialising the head to none
        self.head=None
        self.head_min=None
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if self.head==None or self.head_min==None:
            #Here we are going to insert first value into stack, and we are storing the address into head  
            self.head=Node(val)
            #here we are going to maintain other stack for minimum elements
            self.head_min=Node(val)          
             
        else:
            #If we already have data in stack
            #We are creating a new node 
            new_node=Node(val) 
            #We are placing the address value present in head into new node created
            new_node.next=self.head
            #We are updating head value with new value 
            self.head=new_node
            #If the new value is less than or equal to the val, we will insert into the minimum vlaue stack
            if(self.head_min.val>=val):
                new_node_min=Node(val)
                new_node_min.next=self.head_min
                self.head_min=new_node_min
            
        

    def pop(self):
        """
        :rtype: None
        """
        if self.head==None:
            #If the stack is empty none will be retruned
            return None 
        else:
            #We are creating a temp to store the value of head
            temp=self.head
            if(temp.val==self.head_min.val):
                temp_min=self.head_min
                self.head_min=self.head_min.next
                temp_min.next=None
            #We are updating the head value to the new address
            self.head=self.head.next
            #We are making the address value of the temp to none
            temp.next=None
            return temp.val
        

    def top(self):
        """
        :rtype: int
        """
        #returns the top value of the stack
        return self.head.val
        

    def getMin(self):
        """
        :rtype: int
        """
        #Here we are going to return the top value of the stack that contains minimum values
        if(self.head_min!=None):
            return self.head_min.val
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()