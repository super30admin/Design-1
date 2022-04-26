'''
LeetCode Link: https://leetcode.com/problems/min-stack/
'''
class MinStack:

    def __init__(self):
        self.stackList = []
        self.length = 0
        
        # Insert the currentMin and return the lastIndex as the min
        self.minList = []
        self.minLength = 0

    def push(self, val: int) -> None:
        self.stackList.append(val)
        self.length+=1
        
        # For minList
        if self.minLength == 0:
            # No element in the list
            self.minList.append(val)
            self.minLength+=1
        
        else:
            # Compare with recently appended value
            if self.minList[self.minLength-1] >= val:
                # Append val into minList
                self.minList.append(val)
                self.minLength+=1
        
    def pop(self) -> None:
        
        if self.length > 0:
            val = self.stackList.pop()
            self.length-=1
        
            # For minList
            if self.minList[self.minLength-1] == val:
                # Pop from the minList as well
                self.minList.pop()
                self.minLength-=1
            
    def top(self) -> int:
        return self.stackList[self.length-1]

    def getMin(self) -> int:
        
        '''
        # We will perform quick-sort and return stackList[0]
        
        # Pass th copy of stackList
        arr = self.stackList[0:]
        
        return self.quickSort(arr,0,self.length-1)
        '''
        if self.minLength > 0:
            return self.minList[self.minLength-1]
        
    '''
    # LOMUTO Approach
    def quickSort(self,arr,low,high):
        
        # Boundary Case
        if high < low:
            return arr
        
        # Step 1: Perform Partition
        pivotIndex = self.partition(arr,low,high)
        
        # Step 2: Quick Sort on the lhs
        lhs = self.quickSort(arr,low,pivotIndex-1)
        
        # Step 3: Quick Sort on the rhs
        rhs = self.quickSort(arr,pivotIndex+1,high)
        
        # Return arr[0]
        return arr[0]
        
    def partition(self,arr,low,high):
        
        # For region R2
        j = low
        
        # For region R1
        i = j-1
        
        # Iterate the arr
        while j != high:
            
            if arr[j] < arr[high]:
                
                # Swap i+1 and j
                arr[i+1],arr[j] = arr[j], arr[i+1]
                
                # Increase i
                i+=1
            
            # For else case, we will increase the jth and continue
            j+=1
            continue
        
        # Swap i+1 and high once the iteration is done
        arr[i+1],arr[high] = arr[high], arr[i+1]
        
        return i+1
    '''
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)

print('Current stack is:\t',minStack.stackList)
print('Mimimum integer in stack is:\t',minStack.getMin())
print('Current stack is:\t',minStack.stackList)
print('Top of stack is:\t',minStack.top())
print('Lenght of stack is:\t',minStack.length)

'''
minStack.pop()
minStack.pop()
minStack.pop()
minStack.pop()

print('Current stack is:\t',minStack.stackList)
'''


