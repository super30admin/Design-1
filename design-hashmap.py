# Time Complexity : put: O(n), get: O(n), remove: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Faced problems while coding it in python. Also, not sure about the time and space complexities of this code. Instructor 
# taught it in java, tried to code similar approach in python.



class MyHashMap(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nodes = [ListNode(-1,-1) for i in range(10000)]

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.get_index(key)
        prev = self.find_element(index, key)
        if prev.next is None:
            prev.next = ListNode(key, value)
        else:
            prev.next.val = value
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = self.get_index(key)
        prev = self.find_element(index, key)
        if prev.next is not None:
            return prev.next.val
        else: return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = self.get_index(key)
        prev = self.find_element(index, key)
        if prev.next is not None:
            prev.next = prev.next.next
    
    def get_index(self, key):
        return hash(key)%10000
    
    def find_element(self, index, key):
        prev = self.nodes[index]

        while prev.next is not None and prev.next.key != key:
            prev = prev.next
            
        return prev
        
class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
