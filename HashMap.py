class Node:
    def __init__(self, key=None, val=None, next=None):
        self.key = key
        self.val = val
        self.next = None
class MyHashMap:
    
    
    def __init__(self):
        self.nodes = [None for i in range(10000)]
    
    def find(self, head: Node, key: int) -> Node:
        prev = None
        curr = head
        while (curr is not None) and (curr.key != key):
            prev = curr
            curr = curr.next
        return prev
    def idx(self, key : int) -> int:
        return key % 10000

    def put(self, key: int, value: int) -> None:
        idx = self.idx(key)
        if self.nodes[idx] is None:
            self.nodes[idx] = Node(-1, -1)
        prev = self.find(self.nodes[idx], key)
        if prev.next is not None:
            prev.next.val = value
            
        else:
            prev.next = Node(key, value)
        

    def get(self, key: int) -> int:
        idx = self.idx(key)
        if self.nodes[idx] is None:
            return -1
          
        prev = self.find(self.nodes[idx], key)
        if prev.next is None:
            return -1
        return prev.next.val
        
        

    def remove(self, key: int) -> None:
        idx = self.idx(key)
        if self.nodes[idx] is None:
            return
        prev = self.find(self.nodes[idx], key)
        if prev.next is None:
            return 
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
