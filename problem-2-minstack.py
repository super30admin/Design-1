## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

# For this problem created two empty stacks. staklist to store all the values and min_list to keep a track and store minimum value in the stack. push and pop operations are performed on both the stacks. top performed on only stacklist and getMin performed on the min_list. Time complexity O(1)


class MinStack:

    def __init__(self):
        # intialised stack to add elements
        self.stacklist = []
        # initialised stack to add min elements
        self.min_list = []

    # method to push the element onto the stack
    def push(self, val: int) -> None:
        # append the value in the stacklist
        self.stacklist.append(val)
        
        # to check whether min_list contains anything
        if self.min_list:
            # add the min_list's last value into the variable
            min = self.min_list[-1]
            # check new value is less than existing min if yes replace existing with new value
            if val < min:
                min = val
        # if min_list is empty then make new value as min
        else:
            min = val
        # append the value in teh min_list
        self.min_list.append(min)


    # method to remove the element from the stack
    def pop(self) -> None:
        # remove from the stacklist
        self.stacklist.pop()
        # remove from the minlist
        self.min_list.pop()

    # method to get top element of the stack
    def top(self) -> int:
        # to check if stacklist is not empty return top value
        if self.stacklist:
            return self.stacklist[-1]
        return None

    # method to get the min from the stack
    def getMin(self) -> int:
        # check if the min_list is not empty return the top value
        if self.min_list:
            return self.min_list[-1]
        return None
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(3)
# obj.push(-2)
# obj.push(-1)
# param_3 = obj.top()
# print(param_3)
# param_4 = obj.getMin()
# print(param_4)
