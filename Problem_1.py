# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Node:
    def __init__(self,key,value):
        self.value = value
        self.key =key
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # size of hashmap = 103787
        self.HashMap = [None] * 103787
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        iterator = self.HashMap[key%103787]
        # if not used key position create node and put refrence to it key position
        if iterator == None:
            self.HashMap[key%103787] = Node(key,value)
            return
        else:
        # if key position us used
            #search linked list
            while iterator.next:
                # if same key update value
                if iterator.key == key:
                    break
                iterator = iterator.next
            if iterator.key == key:
                #updating value
                iterator.value = value
            else:
                #create new node with new key
                iterator.next = Node(key,value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        iterator = self.HashMap[key%103787]
        #search for key
        while iterator:
            if iterator.key == key:
                return iterator.value
            iterator = iterator.next
        # if not found return -1
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        iterator = self.HashMap[key%103787]
        #if key position not used return
        if not iterator:
            return
        #if first key in key position is my key
        elif iterator.key == key :
            self.HashMap[key%103787] = iterator.next
        else:
        #if my key not first key search for it
            while iterator.next:
                if iterator.next.key == key:
                    iterator.next = iterator.next.next
                    return
                iterator = iterator.next