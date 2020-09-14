"""
Author: Srinidhi Bhat 
Time Complexity : O(1) - (Can reach O(n) if hash function is not good and if collisions are regular, making the size of the bucket as n)
Space Complexity : O(N+M) - M is number of unique keys - N is Max bucket size required
Did this code successfully run on Leetcode : Yes - faster than 32% and memory less than 72%

Any problem you faced while coding this :Slightly took long time to write remove fucntion

Core Logic - 
hash function design - map given keys to indexes in the table, 
In case collision occurs, Nodes are added to the index and it is iterated to find corresponding (k,v) pair
"""
class ListNode:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:
    def __init__(self):
        self.size = 1543
        self.hash_table = [None]*(self.size)
        
    def put(self, key: int, value: int) -> None:
        index = key%self.size
        
        #Case -1 - when the index is reached first time, insert value
        if self.hash_table[index] == None:
            self.hash_table[index] = ListNode(key,value)
        else:
            #In this bin we have to see if the key is there, if it is add the node, else
            curr = self.hash_table[index]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                if curr.next is None:
                    break
                curr = curr.next
            curr.next = ListNode(key,value)
    
    def get(self, key: int) -> int:
        index = key%(self.size)
        node = self.hash_table[index]
        #if node exists, check if it is there in the table, else iterate the index
        while node:
            if node.key == key:
                return node.value
            else:
                node = node.next
        return -1 #doesn't exist
    

    def remove(self, key: int) -> None:

        index = key%(self.size)
        curr = prev = self.hash_table[index]
        
        #if this node is not there, it cannot be deleted also, hence return 
        if prev is None:
            return 
        #if found directly
        if curr.key == key:
            self.hash_table[index] = curr.next
        #if the case is that we have to iterate the index
        else:
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    break
                else:
                    prev = prev.next
                    curr = curr.next
                    
                    
                    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)