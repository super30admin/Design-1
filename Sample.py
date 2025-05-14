# Time Complexity : O(N / K)  n IS NJUMBER OF VALUES POSSIBLE AND K IS SIZE OF ARRAY WE CREATED 
# Space Complexity : O( N+K )
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : no


#my approach follows creating an array, with a hash=hing approach for storing elements and each array position has buckets( linkedlists to avoid collison)

class MyHashSet:

    def __init__(self):
        self.size = 769  
        self.bucketarray = [Bucket() for i in range (self.size)]  
    def createhash(self,key):
        return key % self.size

    def add(self, key: int) -> None:
        myhash = self.createhash(key)
        self.bucketarray[myhash].addnode(key)
    
        

    def remove(self, key: int) -> None:
        myhash = self.createhash(key)
        self.bucketarray[myhash].deletenode(key)

        

    def contains(self, key: int) -> bool:
        myhash = self.createhash(key)
        return self.bucketarray[myhash].contains(key)


class Node:
     def __init__(self,data):
         self.data = data 
         self.next = None

class Bucket:
    def __init__(self):
        self.head = Node(0)  
    def addnode(self,value):
        if self.contains(value) == False:
            newnode = Node(value)
            newnode.next = self.head.next
            self.head.next = newnode
            

    def deletenode(self,value):
        prev = self.head 
        curr = self.head.next 

        while curr!= None:
            if curr.data == value:
                prev.next = curr.next
                return 
            prev = curr
            curr = curr.next 

    def contains(self,value):
        curr = self.head.next
        while curr != None:
            if curr.data == value:
                return True
            curr = curr.next 
        return False 

# Time Complexity : O(1) for gettibg min
# Space Complexity : O(N) for stack
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : no


#my approach is i create a stack and push each element as a tuple keeping track of the current min at every point

class MinStack:

    def __init__(self):
        self.stack = []
       
        

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val, val))
        else:
            mymin = min(val, self.stack[-1][1])
            self.stack.append((val, mymin))

    def pop(self) -> None:
        
        if self.stack:
            self.stack.pop(-1)
        

    def top(self) -> int:
        myval = self.stack[-1]
        return myval[0]

        

    def getMin(self) -> int:
        return self.stack[-1][1]
        




        


        

