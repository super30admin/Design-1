#Time complexity: 
# Add - O(n) if all inserts chained to same node
# Remove - O(n) if all inserts chained to same node and removal of ~ last node
# Contains - O(n) if all inserts chained to same node and check for last node

#Space complexity:
# Add - O(1)
# Remove - O(1) 
# Contains - O(1)

#Approach:
# Separate chaining, maintain a linked list at each index, attach to Linked List in case of collision

#Accepted by linked list


class Node:
	def __init__(self, val, next = None):
		self.val = val
		self.next = next 

class MyHashSet:
    SIZE = 1000

    def __init__(self):
        self.storageArr = [Node(float('inf')) for i in range(MyHashSet.SIZE)]
        

    def add(self, val: int) -> None:
        #Node to be added
        newNode = Node(val)
        #if already exists do nothing else add
        hashOfVal = self.hash(val)
        #check if hashOccupied by val
        startNode = self.storageArr[hashOfVal]
        curNode = startNode
        prevNode = None
        while curNode and curNode.val!=val:
            prevNode = curNode
            curNode = curNode.next
		
        if curNode == None:
            prevNode.next = newNode
            
        
    def hash(self, val): 
        return val%MyHashSet.SIZE
        

    def remove(self, val: int) -> None:
        hashOfVal = self.hash(val)
        startNode = self.storageArr[hashOfVal]
        curNode = startNode
        prevNode = None
        while curNode and curNode.val!=val:
            prevNode = curNode
            curNode = curNode.next

        if curNode: #found node to be removed
            prevNode.next = curNode.next
        

    def contains(self, val: int) -> bool:
        hashOfVal = self.hash(val)
        startNode = self.storageArr[hashOfVal]
        return True if self.getNodeIfExists(startNode, val) else False
    
    def getNodeIfExists(self,head,val): #helper function
        traverseNode = head
        while traverseNode:
            if traverseNode.val == val:
                break
            else:
                traverseNode = traverseNode.next
        return traverseNode #will return None if does not exist
        
    
        