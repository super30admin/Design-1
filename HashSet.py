class LinkedList:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashSet:

    def __init__(self):
        self.bucketSize = 1000
        self.bucket = [None]*self.bucketSize

    def add(self, key: int) -> None:
        index = key%self.bucketSize
        if self.bucket[index] == None:
            self.bucket[index] = LinkedList(key,True)
        else:
            tempNode = self.bucket[index]
            self.bucket[index]= LinkedList(key,True)
            self.bucket[index].next=tempNode


    def remove(self, key: int) -> None:
        index = key%self.bucketSize 
        if self.bucket[index] == None:
            return
        
        else:
            tempNode = self.bucket[index]
            while tempNode:
                if tempNode.key == key:
                    tempNode.val = False
                    break
                tempNode = tempNode.next
        

    def contains(self, key: int) -> bool:
        index = key%self.bucketSize
        
        if self.bucket[index] == None:
            return False
        else:
            tempNode = self.bucket[index]
            while tempNode:
                if tempNode.key == key:
                    if tempNode.val == True:
                        return True
                    else:
                        return False
                tempNode = tempNode.next
            return False