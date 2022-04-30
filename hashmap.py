# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class node:
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.next=None

class MyHashMap:

    def __init__(self):
        self.array=[-1 for i in range(10000)]
        

    def put(self, key: int, value: int) -> None:
        hash_index=key%10000
        #if the index location in array is -1, then its empty initialize a linked           list
        if self.array[hash_index]==-1:
            self.array[hash_index]=node(-1,-1) #for edge case so that there will be no           single element in ll,(dummy node)
        #if not first check if the key is already present in the linked list,if it          does then just replace its value with new value,if its a new key just add           it
        
        prev=self.find(self.array[hash_index],key)
        if prev.next==None:#which means last node is returned and key not found
                prev.next=node(key,value)
               
        else:
                 prev.next.value=value
            
    def find(self,head,key):
        prev=None
        current=head
        #iterate until you find the next node which contains the key or you reach           the end of the linked list, when you do so return the previous element.
        while current!=None and current.key!=key:
            prev=current
            current=current.next
        return prev
        

    def get(self, key: int) -> int:
        hash_index=key%10000
        if self.array[hash_index]==-1:
            return -1
        prev=self.find(self.array[hash_index],key)
        if prev.next==None:
            return -1
        
        return prev.next.value
        
        

    def remove(self, key: int) -> None:
        hash_index=key%10000
        if self.array[hash_index]==-1:
            return
        else:
            prev=self.find(self.array[hash_index],key)
            if prev.next==None:
                
                return 
            else:
                prev.next=prev.next.next
                
        return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)