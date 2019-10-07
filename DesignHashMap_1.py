# Time complexity(best) - O(1)
class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
class HashMap:
    def __init__(self):
        self.size = 1000
        self.arr = [None] * self.size
    def put(self,key,value):
        index = key % self.size
        if self.arr[index] == None:
            self.arr[index] = Node(key,value)
        else:
            curr = self.arr[index]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                elif curr.next == None:
                    break
                else:
                    curr = curr.next
            curr.next = Node(key, value)

    def get(self,key):
        index = key % self.size
        curr = self.arr[index]
        while curr:
            if curr.key == key:
                return curr.value
            else:
                curr = curr.next
        return None

    def remove(self,key):
        index = key % self.size
        prev = curr = self.arr[index]
        if not curr:
            return
        if curr.key == key:
            self.arr[index] = curr.next
        else:
            curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                else:
                    prev.key = prev.next
                    curr.key = curr.next
        return curr.key,curr.value

h = HashMap()
h.put(1, 10)
h.put(2, 20)
h.put(3, 30)
print(h.get(1))
print(h.remove(1))
print(h.get(1))








