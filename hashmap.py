"""
Time Complexity: O(1) , worst case O(n) - for other operations
Space complexity: O(n) - size of the hashmap
No doubts
Execution complete:
Explaintation:
1> creating two functions (find_index)-> to find the index to which the element has to be inserted and
                            (find) - iterate through the linked list to find the node
2) performing most of the functions with prev pointer
"""


class Node:
    def __init__(self, key, value):  # creating a node
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    def __init__(self):
        self.hashmap = [None] * 1000  # creating a hashmap of size 1000

    def find_index(self, key):
        return hash(key) % len(
            self.hashmap)  # finds the index of the hashmap where a linkedlist will be present and the node will be present in the linked list

    def find(self, head, key):
        curr = head
        prev = None
        while curr != None and curr.key != key:  # curr nodes finds the element and the will return the prev elements
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:

        index = self.find_index(key)  # calculating the index of the key
        if self.hashmap[index] == None:
            self.hashmap[index] = Node(-1,
                                       -1)  # if the index is none, inserting the first node with key value - (-1,-1)
        prev = self.find(self.hashmap[index], key)  # if its not empty traverse through the linked list
        if prev.next == None:  # if the element is not found in the list -  create a new node
            prev.next = Node(key, value)
        else:
            prev.next.value = value  # update the value

    def get(self, key: int) -> int:
        index = self.find_index(key)  # finding the index
        if self.hashmap[index] == -1:  # if there is nothing in the hashmap, return -1
            return -1

        prev = self.find(self.hashmap[index], key)  # if not empty, finding the index
        if prev == None or prev.next == None:  # if not in the linkedlist, return -1
            return -1
        else:
            return prev.next.value  # return next value

    def remove(self, key: int) -> None:
        index = self.find_index(key)  # finding index
        if self.hashmap[index] == -1:  # if index is empty, return -1
            return -1

        prev = self.find(self.hashmap[index], key)  # travarse through the list
        if prev == None or prev.next == None:
            return None
        prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)