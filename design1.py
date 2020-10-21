
# 1.use two stacks
# 2.one stack to store values and one to store min values
# 3.use global minimum values to keep tarck.

# push,pop,top and get_min time complexity-O(1)


class MinStack:

    def __init__(self):
        
        self.instack  = [ ]
        self.minstack = [ ]
        
        self.minvalue= float('inf')
        self.minstack.append(self.minvalue)
        
    def push(self, x: int) -> None:
        
        self.instack.append(x)
        self.minvalue=min(self.minvalue,x)
        self.minstack.append(self.minvalue)
        

    def pop(self) -> None:
        self.minstack.pop()
        self.minvalue=self.minstack[-1]
        return self.instack.pop()

    def top(self) -> int:
        return self.instack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x),r
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

#Not perfect will update this
class Hashmap():
    
    #initialise the variables. declaring two lists to hold keys and its values
    def __init__(self):
        self.size=10000
        self.keys =[None]*self.size
        self.values=[None]*self.size
        
    def hash_generator(self,newKey):
        return newKey%self.size
    
    
    def put(self,newKey,newValue):
        
        hash_value=self.hash_generator(newKey)
        if newKey in self.keys:
            self.values[hash_value]=newValue
        else:
            self.keys[hash_value]=newKey
            self.values[hash_value]=newValue
#         print(self.keys,self.values)
    
    
    def get(self,newKey):
        if newKey in self.keys:
            return self.values[self.hash_generator(newKey)]
        else:
            return -1
            
        
    def remove(self,newKey):
        if newKey in self.keys:
            hash_value=self.hash_generator(newKey)
            self.keys[hash_value]=None
            self.values[hash_value]=None
            