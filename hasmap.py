# This class node contains a constructor with key, value, next properties of a hash table.
class Node():
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # capacity is defined by our design. You can define it anything as per your design.
        self.capacity = 1000
        
        # The size of the hashtable is dependent on capacity
        self.hash_table = [None]* self.capacity
    
    
    # This method helps to calculate the index of the hash table.
    def hash(self, key):
        index = key % self.capacity 
        return index
    
        
    # This method helps to add a new key, value pair into the hastable
    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        # get the index
        index = self.hash(key)
        
        # There are three(3) conditions to consider:
        # 1. If there is no key, value pair existing in the index, then create a new node to the index in hash table. 
        if self.hash_table[index] == None:
            self.hash_table[index] = Node(key, value)
            
        # If the key present in the index, then    
        else:
            
            # Initialize the curr_node with the hash index. 
            curr_node = self.hash_table[index]
            
            # Iterate through the loop while there is curr_node
            while curr_node:
                
                # 2. We check if the curr_node has the same key as the new node, then we update the value and return.
                if curr_node.key == key:
                    curr_node.value = value
                    return 
                
                # 3. If there is different keys with same hash index then we come out of the loop and
                if curr_node.next == None:
                    break
                else:
                    curr_node = curr_node.next 
                
            # add the new node to curr .next node.
            curr_node.next = Node(key, value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = self.hash(key)
        
        # curr_node is the index of the hashtable
        curr_node =self.hash_table[index]
        
        # Till there is curr_node
        while curr_node:
            
            # There are 2 conditions:
            # 1. if the key of the new node is same as the curr_node then update the value
            if curr_node.key == key:
                return curr_node.value
            
            # 2. If the key is not same then iterate through the list by incrementing the current node.
            else:
                curr_node= curr_node.next
        
        # If there is no key present in the hashtable as requested, return -1.
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = self.hash(key)
        
        if self.hash_table[index]== None:
            return
        
        curr_node = prev_node = self.hash_table[index]
        
        # To remove the key there are 3 conditions:
        # 1. if the curr_node key matches with the key then update the hashtable index
        if curr_node.key == key:
            self.hash_table[index] = curr_node.next
        else:
            
            # Update the curr_ node to next
            curr_node = curr_node.next
            
            while curr_node:
                
                # 2. If the curr node has the same key, update the pointer of prev to current.next. 
                # Break the condition and come out of the loop or else it will run infinitely. 
                if curr_node.key == key:
                    prev_node.next = curr_node.next
                    break
                
                # 3. If the key is not found, update the node in the bin.
                else:
                    prev_node = prev_node.next
                    curr_node = curr_node.next
  

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
