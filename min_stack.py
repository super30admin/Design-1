#Implementing with one stack(no auxiliary stack)
#Process
#initialize a empty stack , a variable assigned to positive infinity(minimum variable)
#compare every element with the minimum element,if its less than minimum element then store the minimum element until that point along wiht the new element and set minimum element to new element
#if new element is greater than min element,the minimum doesnt change so just store the new element.
#while popping- so if popped element is equal to minimum element remove that element and set next pooped element as min element(same as adding - just reverse)


class MinStack:

    def __init__(self):
        self.main_stack=[]
        self.min=float('inf')
        
        

    def push(self, val: int) -> None:
        '''O(1) Time complexity
           O(1) Space complexity'''
        
        if self.min>=val:
            self.main_stack.append(self.min)
            self.main_stack.append(val)
            self.min=val
        else:
            self.main_stack.append(val)
            
            
        

    def pop(self) -> None:
        '''O(1) Time complexity
           O(1) space complexity'''
        
        popped_element=self.main_stack[len(self.main_stack)-1]
        #print(popped_element)
        if self.main_stack.pop()==self.min:
            self.min=self.main_stack.pop()
        return popped_element
        
            
        

    def top(self) -> int:
        '''O(1) Time complexity
           O(1) space complexity'''
        return self.main_stack[len(self.main_stack)-1]
        

    def getMin(self) -> int:
        '''O(1) Time complexity
           O(1) space complexity'''
        return self.min
        