# Here we develop a min_stack


# 1 --> save the min as we populate the stack



class Stack:

    def __init__(self):
        self.stack=[]

    def push(self, data):
        for i in data:
            self._push(i)

    def _push(self,data):
        if len(self.stack)==0:
            # (data, min)
            self.stack.append((data,data))
        else:
            self.stack.append((data, min(self.stack[-1][1], data)))
    
    def getMin(self):
        return self.stack[-1][1]

    def pop(self):
        self.stack.pop()
        

    def top(self):
        return self.stack[-1][0]

    def print_stack(self):
        print("index (data , min)")
        for i , v in enumerate(self.stack):
            print(i,v, end=" ")
            print()



## way 2  --> Use 2 stacks one to keep val and other to keep the min
# no need to store min on every step
# we can avoid it--> store only new values

class Stack2:
    def __init__(self):
        self.stack=[]
        self.min_stack=[]

    def push(self, data):
        for i in data:
            self._push(i)
    
    def _push (self, data):
        # add data to stack
        self.stack.append(data)


        if not self.min_stack or data<=self.min_stack[-1]:
            self.min_stack.append(data)
        
    def top(self):
        return self.stack[-1]
    
    def pop(self):
        val=self.stack.pop()
        # check if the min stack's top value is equal to val .
        # if equal pop else go ahead
        if self.min_stack==val:
            self.min_stack.pop()

        
    def getMin(self):
        return self.min_stack[-1]
    
    def print_stack(self):
        print(self.stack)
        print(self.min_stack)
    



if __name__ == "__main__":
    S=Stack2()
    S.push([3,4,5,6,7,8,2,4,3,1])
    S.print_stack()

