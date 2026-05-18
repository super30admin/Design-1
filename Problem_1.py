'''
The hashset is initialized as array of size 10**3 with empty nodes.
Once we have a key to add, we calculate the hash using // operation to get the first 3 digits.
Then we add the key to that particular index in the array.

If there is a collision, we use the nodes as a linkedlist and add the node to the end of the linkedlist,
if not already present.

For removal, we stop at the node previous to the key node, and then set the next of this node to the node after the key node.

Contains is a simple iterative search.
'''
class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

class MyHashSet:

    def __init__(self):
        self.hashSet = [Node(None) for _ in range(1000+1)]

    def add(self, key: int) -> None:
        row = key // 1000
        curr = self.hashSet[row]

        # End of list or the key is already present
        while curr.next is not None and curr.next.data != key:
            curr = curr.next

        # If key is not already present
        if curr.next is None:
            curr.next = Node(key)       
        
    def remove(self, key: int) -> None:
        row = key // 1000
        curr = self.hashSet[row]

        while curr.next is not None and curr.next.data != key:
            curr = curr.next
        
        # If the key is present
        if curr.next is not None and curr.next.data == key:
            curr.next = curr.next.next

    def contains(self, key: int) -> bool:
        row = key // 1000
        curr = self.hashSet[row]

        while curr is not None:
            if curr.data == key:
                return True
            curr = curr.next
     
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)