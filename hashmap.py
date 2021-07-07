class ListNode:
    def __init__(self, key, value):
        self.pair = (key, value)
        self.next = None
   

class MyHashMap:
    def __init__(self):
        self.size = 1000
        self.slots = [None] * self.size
        
        
    def put(self, key, value):
        hashvalue = key % self.size                      #Simple Remainder method, create hashvalue using the key
        
        if self.slots[hashvalue] == None:                #if slot is empty we create a linkedlist node and set the key value tuple 
            self.slots[hashvalue] = ListNode(key, value)
               
        else:                                            #Collision Resolution by Linear Chaining (LinkedList)
            current = self.slots[hashvalue]              #hashvalue having a collision, using linked list for chaining 
            while True:
                if current.pair[0] == key:               #if the key matches, update the key value pair & return
                    current.pair = (key, value)
                    return
        
                if current.next == None:                 #if key value doesnt match & next pointer is None, we update the next pointer to a new node having the key, value tuple
                    break
                current = current.next                  #if key value doesnt match & if linkedlist exists, then iterate through the next until next pointer is None and set the next pointer to a new node having the key, value tuple
                
            current.next = ListNode(key, value)
        
                
    def get(self, key):
        hashvalue = key % self.size     
        current = self.slots[hashvalue]
        
        while current:
            if current.pair[0] == key:
                return current.pair[1]
            else:
                current = current.next
                
        return -1
                           

    def remove(self, key):
        hashvalue = key % self.size
        current = previous = self.slots[hashvalue]
        
        if not current:
            return
        if current.pair[0] == key:         #if key is found, change the hashvalue to point to the next node
            self.slots[hashvalue] = current.next         
        else:                              #if key is not found, iterate through the LinkedList until we find the key
            current = current.next
            while current:
                if current.pair[0] == key:   
                    previous.next = current.next   
                    break
                else:
                    current = current.next
                    previous = previous.next
                    
                


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)