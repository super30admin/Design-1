# // Time Complexity : O(1) for all functions
# // Space Complexity: O(N) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, for my initial approach(Given at the end) I overcomplicated things and ended up using a heap and a dictionary to
#                                              track of values and thier counts. In the end the space complexity was O(N) + O(N) + O(N).
#                                              It worked but the solutions o leetcode were much more elegent. Tried the question again after going through
#                                              the solution.                                             


# // Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        # Array to keep of the elements and another to keep track of the minimum element till then and its count
        self.array = []        
        self.min_tracker = []
        
    def push(self, x: int) -> None:
        self.array.append(x)
        
        # If x is less than or equal to the current min value, update the count or add the value into the stack
        if len(self.min_tracker) == 0 or self.min_tracker[-1][0] >= x:
            if len(self.min_tracker) > 0 and x == self.min_tracker[-1][0]:
                value, count = self.min_tracker[-1]
                self.min_tracker[-1] = (value, count + 1)
                
            else:
                self.min_tracker.append((x, 1))
            
        
    def pop(self) -> None:
        val = self.array.pop()
        
        if self.min_tracker[-1][0] == val:
            value, count = self.min_tracker[-1]
            count -= 1
            if count == 0:
                val = self.min_tracker.pop()
            else:
                self.min_tracker[-1] = (value, count)

        

    def top(self) -> int:
        return self.array[-1]

    def getMin(self) -> int:
        
        return self.min_tracker[-1][0]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Initial Approach:
# import heapq
# class MinStack:

#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.min_array = []
#         self.array = []
        
#         self.count_dict = {}
        
#     def push(self, x: int) -> None:
#         heapq.heappush(self.min_array, x)
#         self.array.append(x)
        
#         if x not in self.count_dict:
#             self.count_dict[x] = 1
#         else:
#             self.count_dict[x] += 1
            
#     def pop(self) -> None:
#         val = self.array.pop()
   
#         self.count_dict[val] -= 1
#         if self.count_dict[val] == 0:
#             del self.count_dict[val]

#     def top(self) -> int:
#         return self.array[-1]

#     def getMin(self) -> int:
        
#         while self.min_array[0] not in self.count_dict:
#             heapq.heappop(self.min_array)
        
#         return self.min_array[0]