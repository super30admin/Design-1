class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
class HashMap:

    def __init__(self):
        self.size = 1000
        self.hash = [None] * self.size 

    def put(self,key,value):
        index = key % self.size 
        if self.hash[index] == None:
            self.hash[index] = ListNode(key, value)
        else:
            curr_node = self.hash[index]
            while True:
                if curr_node.key == key:
                    curr_node.value = value
                    return 
                if curr_node.next == None: break
                curr_node = curr_node.next 
            curr_node.next = ListNode(key, value)

    def get(self,key):
        index = key % self.size 
        curr_node = self.hash[index]
        while curr_node:
            if curr_node.key == key:
                return curr_node.value 
            else:
                curr_node = curr_node.next
        return -1
        

    def remove(self,key):

        index = key % self.size 
        curr_node = prev_node = self.hash[index]
        if not curr_node: return 
        if curr_node.key == key:
            self.hash[index] = curr_node.next
        else:
            curr_node = curr_node.next
            while curr_node:
                if curr_node.key == key:
                    prev_node.next = curr_node.next 
                    break
                else:
                    prev_node, curr_node = prev_node.next, curr_node.next

# Explanation
"""
Put operation-
This problem can be solved using linkedlist. firstly we create an array for 1000 size initially
set to None. Now using the mod operator we check if there is any list already present there with
a key value pair. if not we create a list with the key value pair. if not and the index already
has a list present we traverse through the list using the current pointer. if the same key, value
pair is found we simply exit if not we traverse through the end of the list and append the new
key, value pair. Also if in the middle we find any key but different value, we update the value of 
the particular key.

Get operation-
We simply do a mod operation with the particular key to get the index and we set the current pointer
to the head and traverse through the ll checking at each state the key, if a match is found we return
the value else we exit after the end of the list.

Remove operation-
Again here we get the index using the mod operation and set two pointers cur and prev both on the of 
the ll. if the input key value matches to the head node we return the head node value. if not we traverse
the ll using the cur pointer incrementing both cur and prev, when we find the key in the ll we increment 
the cur pointer and we remove the node by setting prev.next to cur node's next node, hence deleting the current node.
"""
 