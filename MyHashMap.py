#Time Complexity : O(log n) for all methods
#Space Complexity : O(n*m) n = primary array and m = length of link list
#Did this code successfully run on Leetcode : Yes
class Node:
    #initiallies a node of link list. Deafault value of next  = None.
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        #initialize a primary array of size 100000
        self.primary_array_size = 100000
        self.primary = [None] * self.primary_array_size

    def hashFunction(self, key):
        return key % self.primary_array_size

    def find(self, head, key):
        #this function is called when we have to find certain node in a linked list
        #we initialize prev to head and current to next of prev.
        prev = head
        current = prev.next
        #if current is last node of linked list or required key is found,
        #while loop is ended. Untill parse further in linked list
        while current.next != None and current.key != key:
            prev = current
            current = current.next
        return prev

    def put(self, key: int, value: int) -> None:
        #create a node
        node = Node(key, value)
        h = self.hashFunction(key)
        #to check is index of primary_array is empty or not. If not then this node
        #will be placed in that location
        if self.primary[h] == None:
            self.primary[h] = node
        #else, we check if there is only one node present. If present them we directly
        #add it as second node in linked list.
        else:
            if self.primary[h].next == None and self.primary[h].key != key:
                self.primary[h].next = node
            elif self.primary[h].next == None and self.primary[h].key == key:
                self.primary[h] = node
            #else we call find function to find the specific node and add our new node
            #accordingly.
            else:
                prev = self.find(self.primary[h], key)
                prev.next.next = node

    def get(self, key: int) -> int:
        #same logic as used in put function. But here we just return value of
        #respected key instead of adding a node next to it.
        h = self.hashFunction(key)
        if self.primary[h] == None:
            return -1
        else:
            if self.primary[h].next == None and self.primary[h].key == key:
                return self.primary[h].value
            else:
                prev = self.find(self.primary[h], key)
                return prev.next.value

    def remove(self, key: int) -> None:
        # same logic as used in put function. But here we are removing node by assigning
        # next pointer (of returned node from find function) to it's next pointer.
        # by doing this we are cutting off the respective node from the linked list.
        h = self.hashFunction(key)
        if self.primary[h] == None:
            return
        else:
            if self.primary[h].next == None and self.primary[h].key == key:
                self.primary[h] = None
            else:
                prev = self.find(self.primary[h], key)
                prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
