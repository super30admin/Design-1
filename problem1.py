#design Hashmap
# Time Complexity :best case O(1), avg case O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :initially the code didnt get accepted

class NodeList:
    def __init__(self,key,value):
        self.key = key
        self.value = value
class MyHashMap:
    def __init__(self):
        self.size = 1000
        self.hash_table = [None for i in range(self.size)]

    def put(self,key,value):
        index = key%self.size
        #check if bin is empty, if true create a node
        if self.hash_table[index]==None:
            self.hash_table[index]= NodeList(key,value)
        else:
            #not empty , traverse to see if match key, if not just append a node at end 
            curr_node = self.hash_table[value]
            while True:
                if curr_node.key == key:
                    curr_node.value = value
                    return
                if curr_node.next == None:
                    break
                curr_node = curr_node.next
            #No matches ->append key,value pair to it
            curr_node.next = NodeList(key,value)
    
    def get(self,key):
        #initalize index
        index = key%self.size
        #initialize current node
        curr_node = self.hash_table[index]
        #traverse if curr node key matches in the bin return value
        while curr_node:
            if curr_node.key == key:
                return curr_node.value 
            else:
                curr_node = curr_node.next
        return -1

    def remove(self,key):
        index = key%self.size
        curr_node = prev_node = self.hash_table[index]
        #remove empty bin 
        if not curr_node:
            return
        if curr_node.key == key:
            #node found to delete immediately, skip over it
            self.hash_table[index] = curr_node.next
        else:
            #node not found to delte , traverse ahead
            curr_node = curr_node.next

            while curr_node:
                if curr_node.key == key:
                    prev_node.next = curr_node.next
                    break
                else:
                    prev_node,curr_node = prev_node.next,curr_node.next
    

