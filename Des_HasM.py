""" 
Time Complexity: O(n)
"""
class LinkedList:
    def __init__(self, key, value):
        # create a node and initialize it here
        self.pair = (key, value) # data of the node
        self.next = None # next ptr of the node
    
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Const = 1000
        self.hastb = [None] * self.Const

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        ind = key % self.Const
        
        # if the LL is empty
        if self.hastb[ind] is None:
            self.hastb[ind] = LinkedList(key, value)
        else:
            # start node
            strt = self.hastb[ind]
            # traverse through the LL
            while True:
                k, v = strt.pair
                # check if the key already exists or not
                if k == key:
                    # update the value at that particular key
                    strt.pair = (key, value)
                    return
                # if the key is not present and we have reached the end of the LL then
                if strt.next is None:
                    # add new node to the end of the LL
                    strt.next = LinkedList(key, value)
                    return
                # move onto the next node in the LL
                strt = strt.next

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        
        ind = key % self.Const
        # start node
        strt = self.hastb[ind]
        # traverse through the LL
        while strt is not None:
            k, v = strt.pair
            # check if the key already exists or not
            if k == key:
                # update the value at that particular key
                return v
            # move onto the next node in the LL
            strt = strt.next
        # if the key is not present then return -1
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        ind = key % self.Const
        strt = self.hastb[ind]
        
        # if the LL is empty
        if strt is None:
            return -1
        # start node
        root, strt = strt, strt.next
        k, v = root.pair
        # if the key is the root node
        if k == key:
            # update it to next node
            self.hastb[ind] = strt
            return

        # traverse through the LL
        while strt is not None:
            k, v = strt.pair
            # check if the key already exists or not
            if k == key:
                # update to the next node
                root.next = strt.next
                return
            # move onto the next node in the LL
            root, strt = strt, strt.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)