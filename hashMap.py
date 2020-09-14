## Time Complexity : O(c) for put, get, remove where c is size of linked list chain
## Space Complexity : O(10000)
## Did this code successfully run on Leetcode : Yes

## Any problem you faced while coding this : No. Need to know if there is a better way. 



class ListNode:
    def __init__(self, key=None, value = None, next = None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.total_keys = 10000
        self.curr = [None]*self.total_keys
        
        
    def getKeyfromHashFunction(self, key: int):
        return key % self.total_keys


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashed_key = self.getKeyfromHashFunction(key)
        if self.curr[hashed_key] is None:
            node = ListNode(key,value)
            node.next = self.curr[hashed_key]
            self.curr[hashed_key] = node
        else:
            temp = self.curr[hashed_key]
            while temp:
                if temp.key == key:
                    temp.value = value
                    return
                temp = temp.next
            node = ListNode(key, value)
            node.next = self.curr[hashed_key]
            self.curr[hashed_key] = node

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed_key = self.getKeyfromHashFunction(key)
        if self.curr[hashed_key] is None:
            return -1
        else:
            temp = self.curr[hashed_key]
            while temp:
                if temp.key == key:
                    return temp.value
                temp = temp.next
            return -1



    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed_key = self.getKeyfromHashFunction(key)
        if self.curr[hashed_key] is None:
            return
        else:
            temp = self.curr[hashed_key]
            while temp:
                if temp.key == key:
                    temp.value = -1
                    temp.key = -1
                    break
                temp = temp.next
            return            


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)