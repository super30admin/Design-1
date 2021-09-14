# Time Complexity : o(1)
# Space Complexity :
# Did this code successfully run on Leetcode : yes (faster than 96.36% of Python3 online submissions for Min Stack)
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# For returning minimum of the stack i maintained another stack named minData in which new element is appended only when the element is less than the previous element or previous element is appende
## example 
## stack ->    10 8 17 5 3 4 3 12
## minstack -> 10 8 8  5 3 3 3 3


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.__data = list()
        self.__minData = list()
        
    def push(self, val: int) -> None:
        self.__data.append(val)
        
        if self.__minData == []:
            self.__minData.append(val)
            return
            
        if self.__minData[-1] > val:
            self.__minData.append(val)
        else:
            self.__minData.append(self.__minData[-1])
            
        return

    def pop(self) -> None:
        if (len(self.__data) == 0):
            print("Empty Stack!")
            return
        
        self.__data.pop()
        self.__minData.pop()
        return
        

    def top(self) -> int:
        return self.__data[-1]
        

    def getMin(self) -> int:
        return self.__minData[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()