'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
Email       : pavan1011@gmail.com
S30 SlackID : RN32MAY2021
=================================
'''

'''
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
- void push(val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-2^31 <= val <= 2^31 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
'''

#-------------  
# Explanation:
#-------------
# Use two stacks. 
# One to store items (item_stack), one to store mins (min_stack).

# Naive approach: 
#   - Append new item to item_stack, 
#   - If new item is less than top of min_stack, push new item to min_stack
#   - Else push previous top of min_stack to min_stack again.
#   - For getMin(): get last item from min_stack
#   - For top(): get last item from item_stack
#   - For pop(): remove last item from item_stack and min_stack

# Better approach:
#   - Naive approach wastes space in min_stack pushing duplicate items
#   - Instead, if new item is less than top item of min_stack, 
#       push new item to min_stack along with counter [item=val, counter=1]
#   - If new item is equal to the top item of min_stack,
#       increment the counter at the top of the min_stack by 1
#   - For getMin(): get last item from min_stack
#   - For top(): get last item from item_stack
#   - For pop(): (1) If last item from item_stack == last item from min_stack,
#                    decrement counter at the top of min_stack by 1

#                (2) If counter at the top of min_stack becomes 0, remove last
#                    entry ([item, counter]) from min_stack

#                (3) Remove last item from item_stack

#-----------------
# Time Complexity: 
#-----------------
# O(1) for push(), pop(), getMin(), and top() operations

#------------------
# Space Complexity: 
#------------------
# O(n) since we use a list to store the stack

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 60 ms  (72.39 %ile)
# Space            : 17.7 MB (78.20 %ile)

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        #List to implement stack to hold items
        self.item_stack = []

        #List to implement stack to hold min of item_stack
        self.min_stack = []


    def push(self, val: int) -> None:
        """
        :type val: int
        :rtype: None
        """
        # If min_stack is empty, 
        if len(self.min_stack) == 0:
            # push new item to min_stack along with counter 
            # [item=val, counter=1]
            self.min_stack.append([val, 1])
        
        else:
            # If new item is less than current min
            # or the last item on min_stack, 
            # then push new item to min_stack with counter = 1
            if val < self.min_stack[-1][0]:
                self.min_stack.append([val, 1])
            
            # If new item is equal to current min, increment counter 
            # at the last entry of the min_stack
            else:
                if val == self.min_stack[-1][0]:
                    self.min_stack[-1][1] += 1

        # Push to item stack regardless of min calculation
        self.item_stack.append(val)

        #print(f'''Pushed: {self.item_stack[len(self.item_stack)-1]}''')
        #print(f'''  Min: {self.min_stack[len(self.min_stack)-1]}''')



    def pop(self) -> None:
        """
        :rtype: None
        """
        # Check if stack is non-empty 
        if len(self.item_stack) >= 1:
            #print(f'''Popping: {self.item_stack[-1]}''')
            
            popped_item = self.item_stack[-1]

            # If popped item is equal to the last item on min_stack,
            # decrement counter by 1. Otherwise do no thing to min_stack
            if self.min_stack[-1][0] == popped_item:
                self.min_stack[-1][1] -= 1
            
            # If last occurrence of previous min is popped,
            # i.e., if counter at the last entry on min_stack becomes 0,
            # pop the entry from min_stack
            if self.min_stack[-1][1] == 0:
                del self.min_stack[-1]
            
            # Remove last item from item_stack
            del self.item_stack[-1]
            
            #print(f'''  Min: {self.min_stack[-1][0]}''')


    def top(self) -> int:
        """
        :rtype: int
        """
        # If not empty, return last item from item_stack
        if len(self.item_stack) >= 1:
            top_item = self.item_stack[-1]
            return top_item
        
        # Else return some large negative number to indicate a failed read
        else:
            #print("Empty")
            return -(2**31-1)

    def getMin(self) -> int:
        """
        :rtype: int
        """

        # If not empty, return last item from min_stack
        if len(self.min_stack) >= 1:
            # min_item = self.min_stack[-1][0]
            #print(f'''Min:{min_item}''')
            return self.min_stack[-1][0]

        # Else return some large negative number to indicate a failed read
        # happens only when stack is empty
        else:
            #print("Empty")
            return -(2**31-1)

#     def printStack(self):
#         str_print = f'''Item Stack: {str(self.item_stack)} 
# Min Stack: {str(self.min_stack)} '''

#         print(str_print)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(-2)
# obj.push(0)
# obj.push(-3)


# param_3 = obj.top()
# print("Top:", param_3)
# obj.pop()


# command_list = ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
# arg_list = [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]

# obj = MinStack()
# command_list = command_list[1:]
# arg_list = arg_list[1:]
# output_list = []
# output_list.append([])


# for command, args in zip(command_list, arg_list):
#     print (command)
#     if len(args)>0:
#         for arg in args:
#             args = int(arg)
#             exec(f'''output = obj.{command}({args})''')
#             output_list.append([output])
#             break
#     else:
#         output_list.append([exec(f'''output = obj.{command}()''')])
#         output_list.append([output])
    
# print(output_list)
