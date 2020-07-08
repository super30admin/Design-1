# problem 1 : Design Hashmap (https://leetcode.com/problems/design-hashmap/)

# Time Complexity : O (N/K). Here N is number of possible keys and K is the bucket size (hashmap size chosen)
# Space Complexity : O( M + K). Here M is the number of unique keys present in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.hash = [None] * self.modulo

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """     
        index = self.getIndex(key)
        ele = self.getElement(index, key)
        if ele.next:
            ele.next.value = value
        else:
            ele.next = ListNode(key,value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.getIndex(key)
        ele = self.getElement(index, key)
        return ele.next.value if ele.next else -1
        
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.getIndex(key)
        ele = self.getElement(index, key)
        if ele.next:
            ele.next = ele.next.next


    def getIndex(self, key: int) -> int:
        return key % self.modulo
    
    def getElement(self, index:int, key:int) -> ListNode:
        ele = self.hash[index]
        if not ele:
            self.hash[index] = ListNode(-1,-1)
            return self.hash[index]
        while ele.next and ele.next.key != key:
            ele = ele.next
        return ele
            
        
class ListNode:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
            


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# problem 1 : Design MinStack (https://leetcode.com/problems/min-stack/)

# Time Complexity : O (1). Every operation requires only the top of stack
# Space Complexity : O(n). Storing each element along with the current minimum element
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# approach : instead of just adding the number to the stack, adding a pair of number and current minimum element.

# code
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []        

    def push(self, x: int) -> None:
        if not self.stack :
            self.stack.append((x,x))
            return 
        
        get_curr_min = self.stack[-1][1]
        self.stack.append((x,min(x,get_curr_min)))

    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1][0]
       

    def getMin(self) -> int:
        return self.stack[-1][1]
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
