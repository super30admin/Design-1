# All the operations have O(1) time complexity
# space : Hashlist uses space of 10* 4, not modified with input size. So constant space.

class MyHashMap:
    class Node(object):
        def __init__(self, key, val):
            self.key = key
            self.val= val
            self.next = None

    def __init__(self):
        self.Hashlist = [None] * 10000 # 10**4 values and 10**2 linked list

    def put(self, key: int, value: int) -> None:
        
        hashKey = self.find_index(key)
        
        if self.Hashlist[hashKey] == None:
            # create a dummy node (-1, -1)
            self.Hashlist[hashKey] = self.Node(-1, -1)
        
        # find node through the linked list
        prev_node = self.find_node(self.Hashlist[hashKey], key)
        
        if prev_node.next == None:
            # create the new node into the list
            prev_node.next = self.Node(key, value)
        else:
            # update the value into the list
            prev_node.next.val = value


    def get(self, key: int) -> int:
        
        i = self.find_index(key)
        if self.Hashlist[i] == None:
            return -1
        
        prev_node = self.find_node(self.Hashlist[i], key)
        return -1 if prev_node.next == None else prev_node.next.val


        
    def remove(self, key: int) -> None:
        i = self.find_index(key)
        
        if self.Hashlist[i] == None: 
            return
        
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next == None:
            return None
        
        prev_node.next = prev_node.next.next


    def find_index(self, key):
        # hash(key) : hashCode and it should be in range of 0-10^4.
        return hash(key) % len(self.Hashlist)

    
    def find_node(self, head, key):
        cur = head
        prev = None
        
        while cur != None and cur.key != key:
            prev = cur
            cur = cur.next
        
        return prev
    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)





	







	