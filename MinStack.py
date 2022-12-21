# Time Complexity :
# Push, pop, top and getMin - O(1)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
# I missed the point that if the original minimum is removed, the self.min has to be updated

class MinStack:
    def __init__(self):
        self.data = []
        self.min = (2 ** 31) + 2

    def push(self, val: int) -> None:
        #Check if new element is lower than min, then make it min and store
        if val < self.min:
            self.min = val

        #Storing the minimum up until now
        self.data.append((val,self.min))

    def pop(self) -> None:
        value = self.data[-1]
        self.data = self.data[:-1]
        if len(self.data) == 0 :
            #If the list is empty, there is no minimum anymore
            self.min = (2**31) + 2
        else :
            #when an element is removed, the self.min has to be updated to current min
            self.min = self.data[-1][1]
        return value[0]

    def top(self) -> int:
        return self.data[-1][0]

    def getMin(self) -> int:
        return self.data[-1][1]
