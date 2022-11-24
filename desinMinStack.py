#Time Complexity : O(1) for push, pop, top and getMin
#Space Complexity : O(n) since we are using tuples
#Did this code successfully run on Leetcode : Yes it ran successfully
#Any problem you faced while coding this : No issues faced


#Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        self.array = []                                             #using array data structure
        self.min = 0                                                #setting min val

    def push(self, val: int) -> None:
        if self.array:                                              #if array is not empty we push the tuple (a,b) where a is val given directly
            self.array.append((val, min(val,self.array[-1][1])))    #and b is minimum value existing in the list
        else:
            self.array.append((val, val))                           #if array is empty initially then tuple contains (a,a) which is initial value

    def pop(self) -> None:
        self.array.pop()                                            #using array pop operation

    def top(self) -> int:
        return self.array[-1][0]                                    #retrieve top by using array[-1][0] as 0th index in tuple is having the element

    def getMin(self) -> int:
        return self.array[-1][1]                                    #retrieve min by using array[-1][1] as 1st index in tuple is having min val


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()