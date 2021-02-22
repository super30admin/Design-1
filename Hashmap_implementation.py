// Time Complexity : O(1) Best , O(N/1000) worst time complexity
// Space Complexity : O(N) where N is the number of items in the dictionary
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but getting this idea is very different from other problems, 
//I saw the solution to come up with this code

# Initialize the linked list
class ListNode:
    def __init__(self, key, val):
        self.pair = (key,val)
        self.next = None

       
class MyHashMap:

	# Initialize the hashmap 
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 1000
        self.hash = [None]*self.m
        
        
	#Add key value pair to the dictionary, checking the lists if the value is present if yes add them to the key ,
	# if not add them to the linked lists
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key%self.m
        
        if self.hash[index] == None:
            self.hash[index] = ListNode(key,value)
        else:
            cur = self.hash[index]
            while True:
                if cur.pair[0] == key:
                    cur.pair = (key,value)
                    return
                if cur.next == None:
                    break
                cur = cur.next
            cur.next = ListNode(key,value)
            
            
            
        
	# Get the value from the dictionary using the key
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key%self.m
        cur = self.hash[index]
        if cur == None:
            return -1
        else:
            while True:
                if cur.pair[0] == key:
                    return cur.pair[1]
                if cur.next == None:
                    return -1
                cur = cur.next
                
    #Remove the key from the linked list.
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key%self.m
        cur, prev = self.hash[index],self.hash[index] 
        if cur == None:
            return
        if cur.pair[0] == key:
            self.hash[index] = cur.next
        else:
            cur = cur.next
            while cur:
                if cur.pair[0] == key:
                    prev.next = cur.next
                    break
                    
                prev, cur = prev.next,cur.next