#design Hashset
#chaining solution
#solution accepted
#Timecomplexity:O(1)
#spacecomplexity:O(n)
class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.m = [None]*self.size

    def add(self, key: int) -> None:
        index = key%self.size
        #If the node at given index is None then set it with given key
        if self.m[index] == None:
            self.m[index] = ListNode(key,True)
        else:
            currNode = self.m[index]
            #If there are nodes at given index then traverse the linked-list and attach the key at the end.
            tempHead = currNode
            self.m[index] = ListNode(key,True)
            self.m[index].next = currNode

    def remove(self, key: int) -> None:
        index = key%self.size
        #If node at given index is None then do nothing. 
        if self.m[index] == None:
            return
        #Otherwise find given key in the linked-list at current index and set its value to False.
        else:
            currNode = self.m[index]
            while currNode:
                if currNode.key == key:
                    currNode.val = False
                    break
                currNode = currNode.next
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key%self.size
        #If there's no linked-list at given index then return False.
        if self.m[index] == None:
            return False
        #Otherwise traverse the linked-list to check if the desired element is present and its value is True.
        else:
            currNode = self.m[index]
            while currNode:
                if currNode.key == key:
                    if currNode.val == True:
                        return True
                    else:
                        return False
                currNode = currNode.next
            return False

#second approach- not using linked list
#linear probing
#space complexity: O(n)
#timecomplexity:O(1) 
class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.hash_set = [None for i in range (self.size)]
    
    def calc_hash(self,key):
        return key%self.size

    def add(self, key: int) -> None:
        hv = self.calc_hash(key)
        if self.hash_set[hv]==None:
            self.hash_set[hv]=[key]
        else:
            self.hash_set[hv].append(key)
        

    def remove(self, key: int) -> None:
        hv = self.calc_hash(key)
        if self.hash_set[hv]!=None:
            while key in self.hash_set[hv]:
                self.hash_set[hv].remove(key)
        

    def contains(self, key: int) -> bool:
        hv = self.calc_hash(key)
        if self.hash_set[hv]!=None:
            return key in self.hash_set[hv]
           
        
#Random

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
