# constant time operation for get, put, remove
class Node:
  def __init__(self, key = 0, val = 0, next = None):
    self.key = key
    self.val = val
    self.next = next

class MyHashMap:
  def __init__(self):
    self.size = 10000
    self.l = [None for i in range(self.size)]

  def hash1(self,key):
    return key % self.size

  def find(self, head, key):
    prev = self.l[head]
    curr = prev.next
    while(curr != None and curr.key != key):
        prev = prev.next
        curr = curr.next
    return prev

  def put(self, key: int, value: int) -> None:
    h1 = self.hash1(key)
    if(not self.l[h1]):
        head = Node(-1,-1)
        self.l[h1] = head
        head.next = Node(key, value)
    else:
        f = self.find(h1,key)
        if(not f.next):
            f.next = Node(key, value)
        else:
            f.next.val = value


  def get(self, key: int) -> int:
    h1 = self.hash1(key)
    if(not self.l[h1]):
        return -1
    else:
        f = self.find(h1,key)
        if(not f.next):
            return -1
        else:
            return f.next.val

  def remove(self, key: int) -> None:
    h1 = self.hash1(key)
    if(not self.l[h1]):
        return
    else:
        f = self.find(h1, key) 
        if( not f.next):
            return
        else:
            f.next = f.next.next



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
