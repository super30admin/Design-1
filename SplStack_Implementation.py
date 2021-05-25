class Node:
    def __init__(self, val):
        self.value = val
        self.next = None

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = None
        self.top1 = None
        
        

    def push(self, val: int) -> None:
        if self.top1 == None:
            self.top1 = Node(val)
            self.min = val
        elif val>=self.min: 
            newNode = Node(val)
            newNode.next = self.top1
            self.top1 = newNode
        else:
            newNode = Node(2*val-self.min)
            newNode.next = self.top1
            self.top1 = newNode
            self.min = val
            

    def pop(self) -> None:
        if self.top1 == None:
            print("Stack is empty")
        else:
            delNode = self.top1
            self.top1 = self.top1.next
            delNode.next = None
            if delNode.value>=self.min:
                print("Removed Ele is {}" .format(self.min))
            else:
                # print(self.min)
                self.min = (2*self.min)-(delNode.value)
     
        
    def top(self) -> int:
        if self.top1 == None:
            print("Stack is empty")
        else:
            if self.top1.value >= self.min:
                return self.top1.value
            else:
                return self.min
        

    def getMin(self) -> int:
        if self.top1 == None:
            print("Stack is empty")
        else:
            return self.min
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()