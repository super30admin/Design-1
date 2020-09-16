class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        self.size = 500
        self.hash_table = [None] * self.size 

    def put(self, key: int, value: int) -> None:
        index = key % self.size 
    
        if self.hash_table[index] == None:
            self.hash_table[index] = ListNode(key, value)
        else:
            curr_node = self.hash_table[index]
            while True:
                if curr_node.key == key:
                    curr_node.value = value
                    return 
                if curr_node.next == None: 
                    break
                curr_node = curr_node.next 
            curr_node.next = ListNode(key, value)

    def get(self, key: int) -> int:
        index = key % self.size         
        curr_node = self.hash_table[index]
        
        while curr_node:
            if curr_node.key == key:
                return curr_node.value 
            else:
                curr_node = curr_node.next
        
        return -1
        

    def remove(self, key: int) -> None:
        index = key % self.size 
        
        curr_node = prev_node = self.hash_table[index]
      
        if not curr_node: 
            return 
        
        if curr_node.key == key:
            self.hash_table[index] = curr_node.next
        else:
            curr_node = curr_node.next
            
            while curr_node:
                if curr_node.key == key:
                    prev_node.next = curr_node.next 
                    break
                else:
                    prev_node, curr_node = prev_node.next, curr_node.next
