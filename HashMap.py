#Time Complexity : o(1)
#Space Complexity : o(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

# Approach: Array is bounded and hashfunction should have no collisions. If we have collisions then we use linked list method 
class MyHashMap:

    class Node(object):
        def __init__(self, key, val):
            """
            Initialize your data structure here.
            """
            self.key = key
            self.val = val
            self.next = None
            
    # Initialize an empty list        
    def __init__(self):
        self.Hashlist = [None] * 10000
        
   
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        # get the location of index through hash function
        index =self.find_index(key)
        
        # if the index does not have any value, create a node and store (-1,-1)
        if self.Hashlist[index] == None:
            self.Hashlist[index] = self.Node(-1,-1)
        
        # if the index has a value, find the prev node of the value
        prev_node = self.find_node(self.Hashlist[index], key)
        
        if prev_node.next==None:
            prev_node.next=self.Node(key,value)
        else:
            prev_node.next.val=value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index=self.find_index(key)
        
        if self.Hashlist[index] == None:
            return -1
        prev_node = self.find_node(self.Hashlist[index], key)
        
        return -1 if prev_node.next == None else prev_node.next.val
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.find_index(key)
        if self.Hashlist[index] == None:
            return None
        prev_node=self.find_node(self.Hashlist[index], key)
        if prev_node.next == None:
            return None
        prev_node.next=prev_node.next.next
        
    # Hash function to compute the index    
    def find_index(self, key):
        return hash(key)% len(self.Hashlist)
    
    # function to find the node 
    def find_node(self, head, key):
        cur=head
        prev=None
        while (cur!= None and cur.key!=key):
            prev=cur
            cur=cur.next
        return prev
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)