"""
Solution 1: Stack is LIFO. 
Maintain 2 stacks-orignal and minStack. 
Push new elements to original stack. If new element being pushed is <= last element pushed in minStack or minStack is empty, push it to minStack as well. 
Pop element from original stack. If popped element is the last element pushed to minStack, pop it from minStack as well.
Top is the last element pushed to original stack.
Min is the last element pushed to minStack.

Solution 2:
Maintain one stack. Initialize min variable to Inf.
If new element <= min variable, push prev min to stack, update min variable and push new element to stack. If new element > min, just push new element.
If popped element = min variable, do one more pop as it will be the previous min and update it to min variable.
Top is the last element pushed to original stack.
Min is the value of min variable.
Here, space complexity is O(n) but better than Solution 1. Worst case is when min keeps on changing as you will have to push the old min to stack.

Edge cases:
1. same value being pushed and gets popped.
2. Both stacks are empty.
3. negative values are being pushed.

Time Complexity:
push: O(1)
pop: O(1)
top: O(1)
getMin: O(1)
Space Complexity: O(2n) = O(n)
"""

class MinStack():
  def __init__(self):
    self.stack = []
    self.minStack = [] #keep track of all minimums so that when the current minimum is popped from the stacks, we know the previous minimum.
    
  
  def push(self, val):
    if len(self.minStack) == 0: #verify operation is not performed on empty stack and handle it.
      self.minStack.append(val)
    elif val <= self.minStack[-1]: #if same min value is pushed again, you will still push it to minStack so that pop operation for one occurence of value will not affect the min status. You don't have to check if the val is present by comparing the actual values. You only care if it is the last element pushed.
      self.minStack.append(val)
    self.stack.append(val)
    
    
  def pop(self):
    if len(self.stack) != 0: #verify operation is not performed on empty stack and handle it.
      val = self.stack.pop()
      if val == self.minStack[-1]: #You don't have to check if the val is present by comparing the actual values. You only care if it is the last element pushed.
        self.minStack.pop()
      
      
  def top(self):
    return self.stack[-1] if len(self.stack) != 0 else '-1' #verify operation is not performed on empty stack and handle it. You don't have to check if the val is present by comparing the actual values. You only care if it is the last element pushed.
  
  
  def getMin(self):
    return self.minStack[-1] if len(self.minStack) != 0 else '-1' #verify operation is not performed on empty stack and handle it. You don't have to check if the val is present by comparing the actual values. You only care if it is the last element pushed.
  
  
myStack = MinStack()
myStack.push(0)
myStack.push(1)
myStack.push(0)
myStack.pop()
print(myStack.top())
print(myStack.getMin())