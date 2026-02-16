#Design MinStack

# I'm using 2 stack approach, where 1st stack is saving all the items, while the 2nd is saving only 
# if the new item is smaller than the last minimum item. Then during the pop we check if the removed item
# from the stack of all items is same as the min, then remove the last elemnt from 2nd stacka and set the minValue
# to be the top value from the 2nd array. This gives is O(1) time complexity for all operations and O(n) space complexity

class MinStack:

    def __init__(self):
        self.allItems = []
        self.minOrderedItems = []
        self.minItem = None

    def push(self, val: int) -> None:
        self.allItems.append(val)
        if self.minItem == None or self.minItem >= val:
            self.minItem = val
            self.minOrderedItems.append(val)
        # elif self.minItem >= val :
        #     self.minItem = val
        #     self.minOrderedItems.append(val)
        # else:
        #     return

    def pop(self) -> None:
        poppedItem = self.allItems.pop()
        if poppedItem == self.minItem:
            self.minOrderedItems.pop()
        if len(self.minOrderedItems) > 0:
            self.minItem = self.minOrderedItems[-1]
        else:
            self.minItem = None    

    def top(self) -> int:
        return self.allItems[-1]

    def getMin(self) -> int:
        return self.minItem

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()