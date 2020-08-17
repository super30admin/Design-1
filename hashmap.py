
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, initially did not understand the approach and felt little confusion but later tried with an example and understood 


// Your code here along with comments explaining your approach: used hashmap chaining approach 


class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None 

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.hashmap = [None]*1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % 1000
        
        if self.hashmap[index]==None:
            self.hashmap[index] = ListNode(key, value)
        
        else:
            curr = self.hashmap[index]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                if curr.next == None:
                    break
                curr = curr.next
            curr.next = ListNode(key, value)
    
    
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % 1000
        curr = self.hashmap[index]
        
        while curr:
            if curr.key == key:
                return curr.value
            else:
                curr = curr.next
                
        return -1
    
    
    

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % 1000
        curr = prev = self.hashmap[index]
        
        if not curr:
            return
        
        if curr.key == key:
            self.hashmap[index] = curr.next
            
            
        else:
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next
