'''

Your implementation should include these three functions: 

put(key, value) : Insert a (key, value) pair into the HashMap or If the value already exists, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if  no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key
'''
# Time Complexity : Put() - O(n/m)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
'''
The put operation incorporates overwriting a key value pair if the same key is put again, The only way I could do that was
by traversing the linked list (corresponding to a particular hashed key). I could think of a better approach than that

Also, Selecting m was also quetionable, I tried Chain Doubling but that kept giving eoor in Leetcode, For now, I chose m = 1000, as hinted on leetcode question
'''

class Node():

    def __init__(self, key,value, next_=None):

        self.key = key
        self.value = value
        self.next = next_

class LinkedList():

    def __init__(self):
        self.head = None

    def add(self, key, value):

        node_data = Node(key, value)
        ll_iterator = self.head
        if self.head is None:
            self.head = node_data
        else:
            while ll_iterator:
                if key == ll_iterator.key:
                    ll_iterator.key = key
                    ll_iterator.value = value
                    break
                    
                prev = ll_iterator
                ll_iterator = ll_iterator.next
            else:
                prev.next = node_data
            


    def find_value(self, key):

        ll_iterator = self.head

        while ll_iterator:
            if ll_iterator.key == key:
                return ll_iterator.value

            ll_iterator = ll_iterator.next
            
        else:
            return -1
            
    def remove(self, key):

        ll_iterator = self.head

        if ll_iterator.key == key:
            self.head = ll_iterator.next

        else:
            while ll_iterator.next and ll_iterator.key != key:
                prev = ll_iterator
                ll_iterator = ll_iterator.next
            
            prev.next = ll_iterator.next



class hashmap():

    m = 1000
    def __init__(self):

        self.hashlist = [None] * self.m
        
    def get_hash(self, key):

        hashed_key= (key % self.m)-1
        return hashed_key


    def put(self, key, value):

        hashed_key = self.get_hash(key)
        
        if self.hashlist[hashed_key] is None:
            linked_list_obj = LinkedList()
            linked_list_obj.add(key, value)
            self.hashlist[hashed_key] = linked_list_obj
        else:
            self.hashlist[hashed_key].add(key, value)


    def get(self, key):

        hashed_key = self.get_hash(key)
        linked_list_cell = self.hashlist[hashed_key]
        
        if linked_list_cell:
            return linked_list_cell.find_value(key)
        else:
            return -1
    
    def remove(self, key):
        
        hashed_key = self.get_hash(key)
        linked_list_cell = self.hashlist[hashed_key]
        linked_list_cell.remove(key)
        

hashMap = hashmap()
hashMap.put(1, 2)

hashMap.put(2, 3)

print (hashMap.get(1))   #       // returns 2
print (hashMap.get(3))     #       // returns -1 (not found)

hashMap.put(2, 4)   #       // update the existing value

print (hashMap.get(2))       #     // returns 4 

hashMap.remove(2)   #     // remove the mapping for 2

print (hashMap.get(2))#           // returns -1 (not found)
