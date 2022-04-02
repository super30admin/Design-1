#Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : no
# Any problem you faced while coding this :
class Node:

        def __init__(self,key,value,next=None):
            self.key = key
            self.value = value
            self.next = next

class MyHashMap:

    
    def __init__(self):
        self.buckets = 10000
        self.nodes = [None] * self.buckets

    def put(self, key: int, value: int) -> None:
        
        index = key % self.buckets
        if self.nodes[index] == None:
            self.nodes[index] == Node(key,value)
        else:
            curr = self.nodes[index]
            while curr:
                if curr.key == key:
                    curr.value = value
                elif curr.next:
                    curr = curr.next
                else:
                    curr.next = Node(key,value)
                    return

    def get(self, key: int) -> int:
        index = key % self.buckets
        curr = self.nodes[index]

        while curr:
            if curr.key == key:
                return curr.val
            else:
                curr = curr.next
        return -1



    def remove(self, key: int) -> None:
        index = key % self.buckets
        if self.nodes[index] == None:
            return
        elif self.nodes[index].key == key:
            self.nodes[index] = self.nodes[index].next
        else:
            fast,slow = self.nodes[index].next,self.nodes[index]
            while fast:
                if fast.key == key:
                    slow.next = fast.next
                    return
                else:
                    slow,fast = slow.next,fast.next
             


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)