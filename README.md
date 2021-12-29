# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.s = [None]*self.buckets
    
    def hashfunc(self,key):
        return key%self.buckets
    
    def find(self,key,node):
        prev = None
        curr = node
        while curr!=None and curr.key!=key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hashval = self.hashfunc(key)
        if self.s[hashval]==None:
            self.s[hashval] = listnode(-1,-1)
        prev = self.find(key,self.s[hashval])
        if prev.next==None:
            prev.next = listnode(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        hashval = self.hashfunc(key)
        if self.s[hashval]==None:
            self.s[hashval] = listnode(-1,-1)
        prev = self.find(key,self.s[hashval])
        if prev.next==None:
            return -1
        else:
            return prev.next.value

    def remove(self, key: int) -> None:
        hashval = self.hashfunc(key)
        if self.s[hashval]==None:
            self.s[hashval] = listnode(-1,-1)
        prev = self.find(key,self.s[hashval])
        if prev.next==None:
            return
        else:
            prev.next = prev.next.next

class listnode():

    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
        

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack:

    def __init__(self):
        self.s = []        

    def push(self, val: int) -> None:
        if len(self.s)==0:
            self.s.append((val,val))
            return 
        s1=self.s[-1][1]
        self.s.append((val,min(s1,val)))

    def pop(self) -> None:
        self.s.pop()

    def top(self) -> int:
        return self.s[-1][0]

    def getMin(self) -> int:
        return self.s[-1][1]


