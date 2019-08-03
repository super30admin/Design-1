class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        # intialiseing the datastructure here
        self.size = 1000
        self.hashmap = [None] * self.size

    def put(self, key: int, value: int) -> None:

        # calculate the index
        index = key % self.size

        # if the particular inde is empty, then we put the node in the index
        if self.hashmap[index] == None:
            self.hashmap[index] = Node(key, value)

        # if the index is not empty, we traverse the linkedlist with curr
        else:
            curr = self.hashmap[index]
            while True:

                # if we found an equivalent key in the lnkedlist, we just update the value
                if curr.key == key:
                    curr.value = value
                    return

                # if we find an empty place after traversing the linkedlist we comeout the loop and add an node there
                if curr.next == None:
                    break
                # if its not empty or if we don;t get the matching key, we just traverse the linkedlist
                curr = curr.next
                # inserting

            curr.next = Node(key, value)

    def get(self, key: int) -> int:
        # calculating the index
        index = key % self.size

        # placing a cursor at the point
        curr = self.hashmap[index]

        # traversing the linkedlist
        while curr:
            if curr.key == key:
                return curr.value
            else:
                curr = curr.next
        # not found
        return -1

    def remove(self, key: int) -> None:

        # calculate index
        index = key % self.size

        # place two cursors at the  macthed index.
        curr = prev = self.hashmap[index]

        if not curr:
            return

        if curr.key == key:

            self.hashmap[index] = curr.next
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
