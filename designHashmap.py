#Code didnot run correctly in leetcode gave wrong answer but running fine in local system
class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.tableSize = 1000
        self.hashMap = [None]*self.tableSize

    #rType : None
    def put(self, key, value):
        hashIndex = key%self.tableSize
        curr = self.hashMap[hashIndex]
        if curr == None:
            self.hashMap[hashIndex] = Node(key,value)
            return
        else:
            while curr:
                if curr.key == key:
                    curr.val = value
                    return
                elif curr.next is None:
                    curr.next = Node(key,value)
                    return
                else:
                    curr = curr.next

    #rType : int
    def get(self, key):
        hashIndex = key%self.tableSize
        curr = self.hashMap[hashIndex]
        if curr is None:
            return -1
        else:
            while curr:
                if curr.key == key:
                    return curr.val
                else:
                    curr = curr.next


    #rType : None
    def remove(self, key):
        hashIndex = key%self.tableSize
        prev = self.hashMap[hashIndex]
        if prev is None:
            return
        else:
            while prev:
                curr = prev.next
                if prev.key == key:
                    print("The removed key value pair {} {}".format(prev.key,prev.val))
                    prev.next = curr
                    return
                else:
                    prev = prev.next



# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(4,77)
obj.put(3,88)
obj.put(7,89)
obj.put(7,90)
param_2 = obj.get(7)
print("The value at 7 is {}".format(param_2))
obj.remove(7)
param_2 = obj.get(1)
print("The value at 1 is {}".format(param_2))
