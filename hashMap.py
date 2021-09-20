'''
// Time Complexity : O(1) 
// Space Complexity : O(m + k) where "m" is the size of array "k" is the size of linked list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
We create a hash function that will help us map our key on the intitial
bucket or data array, once we have that we will use linked list to perform 
operation and return them in constant time. 
'''

class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key=key
        self.val=val
        self.next=next

class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data=[ListNode() for i in range(0,1000) ]
    
    def genHash(self,key):
        return key % 1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashCode=self.genHash(key)
        head=self.data[hashCode]
        while head.next:
            if head.next.key==key:
                head.next.val=value
                return
            head=head.next
        head.next=ListNode(key,value)
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashCode=self.genHash(key)
        head=self.data[hashCode]
        while head.next:
            if head.next.key==key:
                return head.next.val
            head=head.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashCode=self.genHash(key)
        head=self.data[hashCode]
        while head.next:
            if head.next.key==key:
                head.next.val=-1
            head=head.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)