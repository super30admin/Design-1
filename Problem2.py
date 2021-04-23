# design min stack
class MinStack():
    def __init__(self):
        self.mystack = []
        self.minstack = []

    def push(self,val):
      if len(self.mystack) ==0:
          self.mystack.append(val)
          self.minstack.append(val)
      else:
          ele = self.mystack[-1]
          ele1 = self.minstack[-1]
          self.mystack.append(val)
          if ele > val:
              self.minstack.append(val)
          else:
              self.minstack.append(ele1)

    def pop(self):
        if len(self.mystack)!= 0:
            self.minstack.pop()
            self.mystack.pop()
           
       
    
    def top(self):
        if len(self.mystack)!= 0:
            ele = self.mystack[-1]
            return ele
        return -1


    def getMin(self):
        min_ele = self.minstack[-1]
        return min_ele


obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())

