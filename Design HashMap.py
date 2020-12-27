class MyHashMap:
    class Node(object):



	    def __init__(self, key, val):



		    self.key = key



		    self.val = val



		    self.next = None





    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Hashlist = [None] * 10000


        




        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        i = self.find_index(key)

        if self.Hashlist[i] == None:
            self.Hashlist[i] = self.Node(-1, -1)
        prev_node = self.find_node(self.Hashlist[i], key)

        if prev_node.next == None:
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value




        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        i = self.find_index(key)
        if self.Hashlist[i] == None:
            return -1
        prev_node = self.find_node(self.Hashlist[i], key)
        return -1 if prev_node.next == None else prev_node.next.val


        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        i = self.find_index(key)
        if self.Hashlist[i] == None:
            return
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next == None:
            return None
        prev_node.next = prev_node.next.next
    
    def find_index(self, key):
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
