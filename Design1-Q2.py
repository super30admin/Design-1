class SplStack:
    def __int__(self):
        self.stack=[]
        self.min=[]
        self.size=0
        self._top=-1
        self.maxsize=10


     def isEmpty(self):
         return self._top=-1

     def isFull(self):
         if self.size== self.maxsize :
             return True
         else:
             return False

    def push(self, x):
        if self.size==0:
          self.min.append(x)
        else:
            if x <= self.min[-1]:
                self.min.append(x)
        self.stack.append(x)
        self.size+=1

    def pop(self):
        temp=self.stack.pop()
        self.size-=1
        if temp==self.min[-1] :
          self.min.pop()

    def getMin(self):
        return self.min[-1]
