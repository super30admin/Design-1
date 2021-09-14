class Node:
    def __init__(self, key, val):
        self.pair = (key, val)
        self.next = None


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 10000
        self.hasharray = [False] * self.m

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hashcode = key % self.m
        temp = self.hasharray[hashcode]

        if not temp:
            self.hasharray[hashcode] = Node(key, value)

        else:
            while (True):
                if temp.pair[0] == key:
                    temp.pair = (key, value)
                    return
                if temp.next is None: break
                temp = temp.next
            temp.next = Node(key, value)

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hashcode = key % self.m
        temp = self.hasharray[hashcode]
        while (temp):
            if temp.pair[0] == key:
                return temp.pair[1]
            temp = temp.next
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hashcode = key % self.m
        temp = prev = self.hasharray[hashcode]

        if not temp: return

        if temp.pair[0] == key:
            self.hasharray[hashcode] = temp.next

        else:
            temp = temp.next
            while temp:
                if temp.pair[0] == key:
                    prev.next = temp.next
                    return
                else:
                    prev = prev.next
                    temp = temp.next