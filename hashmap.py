'''
Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''
class Node:
    def __init__(self, key, val):
        self.val = val
        self.key = key
        self.next = None

class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.hashmap = [Node(-1,-1) for _ in range(self.buckets)]

    def getBucket(self, key):
        return key // 1000

    
    def find(self, head, key):
        curr = head
        while curr.next and curr.next.key != key:
            curr = curr.next

        return curr
        
    def put(self, key: int, value: int) -> None:
        head = self.hashmap[self.getBucket(key)]
        curr = self.find(head, key)
        curr.next = Node(key, value)
            

    def get(self, key: int) -> int:
        pass

    def remove(self, key: int) -> None:
        pass
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)