# 706. Design HashMap

class ListNode:
    def __init__(self, key, val):
        self.pair = (key, val)
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000;
        self.hashmap = [None]*self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.size
        
        if self.hashmap[index] == None:
            self.hashmap[index] = ListNode(key, value)
        else:
            curr = self.hashmap[index]
            while True:
                if curr.pair[0] == key:
                    curr.pair = (key, value) #update
                    return
                if curr.next == None: 
                    break
                curr = curr.next
            curr.next = ListNode(key, value)
        


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key%self.size
        
        curr = self.hashmap[index]
        
        while curr:
            if curr.pair[0]==key:
                return curr.pair[1]
            else:
                curr = curr.next
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key%self.size
        curr = prev= self.hashmap[index]
        
        if not curr:
            return
        if curr.pair[0] == key:
            self.hashmap[index] = curr.next
        else:
            curr= curr.next
            while curr:
                if curr.pair[0]==key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev= curr.next, prev.next

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)