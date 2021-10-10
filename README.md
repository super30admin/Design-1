# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
class Bucket:
    def __init__(self):
        self.bucket = []

    def get(self, key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        found = False
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                self.bucket[i] = (key, value)
                found = True
                break

        if not found:
            self.bucket.append((key, value))

    def remove(self, key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]


class MyHashMap(object):

    def __init__(self):
        self.keysize =10000
        self.hash_table = [Bucket() for i in range(self.keysize)]
    def f(self,key):
        return key % self.keysize 
    def put(self, key, value):
        self.hash_table[self.f(key)].update(key, value)
    def get(self, key):
        return self.hash_table[self.f(key)].get(key)
    def remove(self, key):
        self.hash_table[self.f(key)].remove(key)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
class MinStack:

    def __init__(self):
        self.a=[]
        
    def push(self, val: int) -> None:
        if len(self.a)==0:
            self.a.append((val,val))
            return
        b=self.a[-1][1]
        self.a.append((val,min(b,val)))
    def pop(self) -> None:
        self.a.pop()
    def top(self) -> int:
        return self.a[-1][0]
    def getMin(self) -> int:
        return self.a[-1][1]
        



