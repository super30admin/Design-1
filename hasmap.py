class Node:
    def __init__(self,key, value,next=None):
        self.value = value
        self.key=key
        self.next = next

class MyHashMap:

    def __init__(self):
        self.arr = []
        for _ in range(10000):
            self.arr.append(Node(None,None))
        

    def GetIndex(self,key):
        ind = key%10000
        prev = self.arr[ind]
        node = prev.next
        while node:
            if node.key==key:
                return True,prev
            node=node.next
            prev=prev.next
        return False,prev
    
    
    def put(self, key: int, value: int) -> None:
        entry_exist, prev = self.GetIndex(key)
        if entry_exist:
            prev.next.value=value
        else:
            prev.next = Node(key,value)
                
            
    def get(self, key: int) -> int:
        entry_exist, prev = self.GetIndex(key)
        if entry_exist:
            return prev.next.value
        else:
            return -1


    def remove(self, key: int) -> None:
        entry_exist, prev = self.GetIndex(key)
        
        if entry_exist:
            prev.next = prev.next.next
                
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)