// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :i ca solve it using an array but trtied to solve using a linked list but facing an error.


// Your code here along with comments explaining your approach:

class Node:
    def __init__(self, data):
       self.data = data
       self.next = None
 
class Stack:
    def __init__(self):
      self.head = None
      self.tail = None
      self.length = 0

    def push(self, data):
      new_node = Node(data)
      if self.tail == None:
        self.tail = new_node
        self.head = self.tail
        self.length = 1
      else:
        self.head.next = new_node
        self.head = self.head.next
        self.length += 1  

    def pop(self):
      i = 1
      curr_node = self.tail
      while i != self.length-1:
        curr_node = curr_node.next
        i +=1
      popped_value = curr_node.next
      curr_node.next = None
      self.head = curr_node
      self.length -= 1
      return popped_value.data 

    def print(self):
      temp = self.tail
      while temp != None:
        print(temp.data , end = ' -> ')
        temp = temp.next
      print()   
        
    def getMin(self):
      i = 1
      curr_node = self.head
      min_result = curr_node.data

      while i != self.length:
        curr_node = curr_node.next
        min_result = min(curr_node.data, min_result)
      return min_result



s = Stack()
s.push(1)
s.push(2)
s.push(0)
s.push(4)
s.push(9)
s.print()
y = s.getMin()
print(y)
        
