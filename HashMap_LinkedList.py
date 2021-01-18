#// Time Complexity :O(1) best case and O(n^1/2) worst case
#// Space Complexity :O(n) worst case
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no
class Node:
    def __init__(self,key):
        self.key=key
        self.value=None
        self.next=None
        


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000
        self.hashmap=[Node(-1) for i in range(self.size)]
        
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        flag=True
        
        head=self.hashmap[key%1000]
        current=head.next
        while(current!=None):
            if(current.key==key):
                current.value=value
                flag=False
                break
            current=current.next
        if(flag):
            current=Node(key)
            current.value=value
            current.next=head.next
            head.next=current
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        head=self.hashmap[key%1000]
        current=head.next
        while(current!=None):
            if(current.key==key):
                return current.value
                break
            current=current.next
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        head=self.hashmap[key%1000]
        current=head.next
        prev=head
        while(current!=None):
            if(current.key==key):
                prev.next=current.next
                break
            current=current.next
            prev=prev.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)