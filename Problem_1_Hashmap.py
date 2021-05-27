

class ListNode(object):

    def __init__(self,key,val):
        """
        Initialize your data structure here.
        """
        #Using the linked list we look at the most recent added node and move to the next until find the correct node
        self.pair = (key,val)
        self.next = None


class MyHashMap:

    def __init__(self):
        self.m = 1000;
        self.h = [None]*self.m


    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = key % self.m
        if self.h[index] == None:
            self.h[index] = ListNode(key,value)
        else:
            cur = self.h[index]
            while True:
                #if current key is the index then update the value in the key at that index
                if cur.pair[0] == key:
                    cur.pair = (key,value)
                    return
                if cur.next == None:
                    break
                cur = cur.next
            cur.next = ListNode(key,value)



    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = key % self.m
        cur = self.h[index]
        while cur:
            if cur.pair[0] == key:
                return cur.pair[1]
            else:
                cur = cur.next
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = key % self.m
        cur = prev = self.h[index]
        if not cur:
            return
        if cur.pair[0] == key:
            self.h[index] = cur.next
        else:
            cur = cur.next
            while cur:
                if cur.pair[0] == key:
                    prev.next = cur.next
                    break
                else:
                    cur,prev = cur.next,prev.next

#Used array as direct table and linked list for key,value as pair. The time complexity for this hashmap for each function turns to be O(1).

# Your MyHashMap object will be instantiated and called as such:
#obj = MyHashMap()
#obj.put(key,value)
#param_2 = obj.get(key)
#obj.remove(key)