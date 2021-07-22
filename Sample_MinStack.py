# Time Complexity : PUSH:O(1) POP=0(1) TOP=O(1) GETMIN=0(1)
# Space Complexity : O(N)
#Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class ListNode:
    def __init__(self,value,min,next=None):
        self.value=value
        self.min=min
        self.next=next
    
class MinStack:

#
# Time Complexity 
# Push:O(1)
# Pop:O(1)
# Top:O(1)
# getMin: O(1)
    
#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.head=None

#     def push(self, val: int) -> None:
#         if self.head==None:
#             self.head=ListNode(val,val,None)
#             return
#         newNode=ListNode(val,min(self.head.min,val))
#         newNode.next=self.head
#         self.head=newNode

#     def pop(self) -> None:
#         self.head=self.head.next
#         return
            
#     def top(self) -> int:
#         return self.head.value

#     def getMin(self) -> int:
#         return self.head.min

#
# Time Complexity 
# Push:O(1)
# Pop:O(1)
# Top:O(1)
# getMin: O(1)
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min=float('inf')
    def push(self, val: int) -> None:
        if val<= self.min:
            self.stack.append(self.min)
            self.min=val
            self.stack.append(val)
            return
        if val >self.min:
            self.stack.append(val)
            return
        
    def pop(self) -> None:
        if self.stack[-1]==self.getMin():
            self.stack.pop()
            self.min=self.stack.pop()
            return
        self.stack.pop()
        print(self.stack)
            
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        # print(stack)
        return self.min