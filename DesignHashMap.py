#Time complexity - O(n/k) time
#Space complexity - O(n + k) space
#Ran on leetcode - Yes

class ListNode:
    #create a node, as we are using a linked list.
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        self.max_size = 10000 #size of the primary array
        self.hash_table = [None] * self.max_size

        
    def put(self, key: int, value: int) -> None:
        #to put an item into the hash table we need to calculate an index
        index = key % self.max_size
        
        if self.hash_table[index] == None:
            self.hash_table[index] = ListNode(key, value)
        else:
            currentNode = self.hash_table[index]
            while True:
                if currentNode.key == key:
                    currentNode.value = value
                    return
                if currentNode.next == None:
                    break
                
                currentNode = currentNode.next
            currentNode.next = ListNode(key, value)
                

    def get(self, key: int) -> int:
        index = key % self.max_size
        currentNode = self.hash_table[index]
        
        while currentNode:
            if currentNode.key == key:
                return currentNode.value
            else:
                currentNode = currentNode.next
        
        return -1

    def remove(self, key: int) -> None:
        index =  key % self.max_size
        currentNode = previousNode = self.hash_table[index]
        
        if not currentNode:
            return
        
        if currentNode.key == key:
            self.hash_table[index] = currentNode.next
        else:
            currentNode = currentNode.next
            while currentNode:
                if currentNode.key == key:
                    previousNode.next = currentNode.next
                    break
                else:
                    previousNode, currentNode = previousNode.next, currentNode.next