class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.hashmap = [0]*1000

    def hashcode(self, key):
        return key%1000
    
    def _find(self, key):
        index = self.hashcode(key)
        
        # Index has a node value
        if self.hashmap[index] != 0:
            head = self.hashmap[index]
            while head.next:
                if head.next.key == key:
                    return head
                head = head.next
            return head
        # Index is empty
        else:
            return None

    def put(self, key: int, value: int) -> None:
        index = self.hashcode(key)
        ptr = self._find(key)
        
        new_node = Node(key, value)
        
        if ptr is None:
            self.hashmap[index] = Node(-1,-1)
            self.hashmap[index].next = new_node
        else:
            if ptr.next is None:
                ptr.next = new_node
            else:
                ptr.next.val = value

    def get(self, key: int) -> int:
        ptr = self._find(key)
        
        if ptr is None or ptr.next is None:
            print(ptr)
            return -1
        else:
            return ptr.next.val

    def remove(self, key: int) -> None:
        index = self.hashcode(key)
        ptr = self._find(key)
        
        if ptr is None:
            return
        elif ptr.key == -1:
            self.hashmap[index] = 0
        else:
            ptr = ptr.next


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,1)
print(obj.get(2))
obj.remove(2)
print(obj.get(2))