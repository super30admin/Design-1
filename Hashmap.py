#Approach : Use of LinkedList for bucket and storing the buckets inside an array for Hashmap. 
#Time Complexity : O(1) for put and get operations
#Space Complexity : O(n)

class Node():
    
    def __init__(self):
        self.next = None
        self.value = []
    
    def put(self,key,value):
        self.value = [key,value]
        

class Bucket():
    
    def __init__(self):
        self.head = None
        
        
    def put(self,key,value):
        cur = self.head
        if(self.head is None):
            newNode = Node()
            newNode.put(key,value)
            self.head = newNode
            return
        
        while(cur is not None):
            if(cur.value[0]==key):
                cur.value[1] = value
                return
            cur = cur.next
        newNode = Node()
        newNode.put(key,value)
        cur = newNode
        
        
        # for i in self.bucket:
        #     if(i[0]==key):
        #         i[1] = value
        #         return
        #     else:
        #         self.bucket.append([key,value])
                
    def get(self,key):
        
        cur = self.head
        while(cur!=None):
            if(cur.value[0]==key):
                return cur.value[1] 
            cur = cur.next
            
        return -1
    
    def remove(self,key):
        cur_val = self.head
        if(self.head is None):
            print ("list is Empty")
            return
        else:
             while(cur_val is not None):
                prev = cur_val
                if(prev.value[0] == key):
                    self.head = prev.next
                    return
                cur_val = cur_val.next
                if(cur_val is not None and cur_val.value[0]==key):                 
                    prev.next = cur_val.next
                    return
                    #print(prev.next)
        print ("Element given is not present in the list")
        
            
class MyHashMap(object):
    
   

    def __init__(self):
        self.map = [None]*(10**6+1)
        self.hashfunc = 10**6+1
        

    def put(self, key, value):
        
        hashvalue = key % self.hashfunc
        if(self.map[hashvalue] is not None):
            bucket = self.map[hashvalue]
            bucket.put(key,value)
        else:
            self.map[hashvalue] = Bucket()
            self.map[hashvalue].put(key,value)
            

    def get(self, key):
        hashvalue = key % self.hashfunc
        if(self.map[hashvalue] is not None):
            bucket = self.map[hashvalue]
            return bucket.get(key)
        else:
            return -1
            
#         for i in self.map:
#                 if(i[0]==key):
#                     return i[1]
       
#         return -1

    def remove(self, key):
        hashvalue = key % self.hashfunc
        if(self.map[hashvalue] is not None):
            bucket = self.map[hashvalue]
            return bucket.remove(key)
        else:
            print('key is not found')
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
