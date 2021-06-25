
#time complexity-O(n) length of linked list
#space complexity- O(n+l) 
class ListNode:
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.next=None
class MyHashMap:

    def __init__(self):
        self.size=10000
        self.h=[None]*self.size
    
    def calculate_hash(self,key):
        """Hash val calculation using hash function"""
        return key%(self.size)
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index=self.calculate_hash(key)
        if self.h[index]==None:
            self.h[index]=ListNode(key,value)
        else:
            temp=self.h[index]
            while True:
                if temp.key == key:
                    #update value
                    temp.value = value
                    return
                if temp.next == None:
                    #if we reach end
                    break
                temp = temp.next
            temp.next = ListNode(key, value)
            

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index=self.calculate_hash(key)
        # Not found
        if self.h[index]==None:
            return -1
        else:
            #traverse through linked list to find the value
            temp=self.h[index]
            while temp:
                if temp.key == key:
                    return temp.value
                temp = temp.next
            return -1
             

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index=self.calculate_hash(key)
        
        temp=self.h[index]
        #when there is at leats one node
        if self.h[index]!=None:
            #element is at the head 
            if temp.key==key:
                self.h[index]=temp.next
            else:
                prev, curr = temp, temp.next
            #element is not at head
                while curr:
                    if curr.key == key:
                        prev.next = curr.next
                        break
                    prev = prev.next
                    curr = curr.next
        else:
            return 
            
        
        
        
            
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
