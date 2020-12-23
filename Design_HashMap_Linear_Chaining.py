# Created by Aashish Adhikari at 4:32 PM 12/22/2020

class Node(object):
    def __init__(self, key = None, value = None):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.hashed_locations = [Node() for idx in range(10)]


    def put(self, key, value):
        """
        Insert a (key, value) pair into the HashMap or If the value already exists, update the value.
        "value" will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """

        index_to_store_in = key % 10

        # Check if an entry already exists in the storage
        if self.hashed_locations[index_to_store_in].key is None:
            # No data exists in this index
            self.hashed_locations[index_to_store_in] = Node(key, value)
        else:
            # Use linear chaining to extend the set of values that correspond to this hashing index
            curr = self.hashed_locations[index_to_store_in]
            while curr is not None:

                # If the key already exists, replace the value of the key.
                if curr.key == key:
                    curr.value = value
                    break
                else:
                    if curr.next is None:
                        # Since the key was not found, append the <key-value> pair at the end of the linked list
                        curr.next = Node(key, value)
                        break

                    curr = curr.next





    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index_to_search = key % 10

        if self.hashed_locations[index_to_search].key is None:
            return -1
        else:
            # Check the linked list to check if the key exists
            curr = self.hashed_locations[index_to_search]
            while curr is not None:
                if curr.key == key:
                    return curr.value
                curr = curr.next

            # If the key does not exist, return -1
            return -1


    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index_to_search = key % 10

        # If a key-value pair exists at this index
        if self.hashed_locations[index_to_search].key is not None:
            curr = self.hashed_locations[index_to_search]

            # Traverse the linked list at this location until you remove the <key,value> pair
            if curr.key == key:
                if curr.next is not None:
                    self.hashed_locations[index_to_search] = curr.next
                else:
                    self.hashed_locations[index_to_search] = Node()
            else:
                while curr is not None:
                    if curr.next.key == key:
                        if curr.next.next is not None:
                            curr.next = curr.next.next
                        else:
                            curr.next = None
                        break



# obj = MyHashMap()
# obj.put(1,1)
# obj.put(2,2)
# param_2 = obj.get(1)
# param_3 = obj.get(3)
# obj.put(2,1)
# param_4 = obj.get(2)
# obj.remove(2)
# param_5 = obj.get(2)
