class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None
        
class MyHashSet:
    def __init__(self):
        ## space complexity is O(N)
        self.set = [ListNode(0) for i in range(10*4)]
        
    def add(self, key):
        # time complexity Adding towards the end of list is O(N)
        index = key%len(self.set)
        current = self.set[index]
        
        while current.next:
            if current.next.key == key:
                return
            current = current.next
        current.next = ListNode(key)
        
    def remove(self, key):
        # time complexity removing towards the end of list is O(N)
        index = key%len(self.set)
        current = self.set[index]
        
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
                return
            current= current.next
      
    def contains(self, key):
         # time complexity if element is present at the end of the list O(N)
        index = key%len(self.set)
        current = self.set[index]
        
        while current.next:
            if current.next.key == key:
                return True
            current = current.next
        return False