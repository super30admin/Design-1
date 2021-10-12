# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Node:
  def __init__(self):
    self.key = -1
    self.value = -1
    self.next = None
        
class MyHashMap:

  def __init__(self):
    self.hash_map = []
    for i in range(0,10001):
      obj = Node()
      self.hash_map.append(obj)

  def put(self, key: int, value: int) -> None:
    hashIndex = hash(key) % 10000
    head = self.hash_map[hashIndex]
    print(hashIndex)
    prev = head
    curr = head
    while(curr.next != None and curr.key != key):
      prev = curr
      curr = curr.next
    if (curr.key == key):
      curr.value = value
    else:
      obj = Node()
      obj.key = key
      obj.value = value
      curr.next = obj
          
          

  def get(self, key: int) -> int:
    hashIndex = hash(key) % 10000
    head = self.hash_map[hashIndex]        
    curr = head
    while(curr.next != None and curr.key != key):            
      curr = curr.next
    if (curr.key == key):
      return curr.value
    else:
      return -1

  def remove(self, key: int) -> None:
    hashIndex = hash(key) % 10000
    print(hashIndex)
    head = self.hash_map[hashIndex]
    prev = head
    curr = head
    while(curr.next != None and curr.key != key):
      prev = curr
      curr = curr.next
    if curr.key == key:
      prev.next = curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)