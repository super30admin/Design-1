"""Could you please check the time and space complexities?"""

#Accepted on leetcode

#Time complexity for creating Hash Map - O(N)
#Space omplexity - O(1) or O(k)
class ListNode:
	#Time complexity for creating LinkedList - O(1), create refernce to the head node
	#Space omplexity - O(1) constant for a node
    #Creating a LinkedList class to implement linear chaining technique
    def __init__(self,key,value):
        self.pair = (key,value)#Tuple of key,val pair
        self.next = None

class MyHashMap(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
		#Time complexity for creating Hash Map - O(N), N=size
		#Space omplexity - O(1)
		
        self.size = 1000#Initalizing the size as 1000
        self.nodes = [None]*self.size

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
		#Time complexity for put operation - O(N), worst case if it is last index
		#Space complexity - O(1)
        index = key % (self.size)#Calculating the index with first hash function 'size'.
        if self.nodes[index] == None:
            self.nodes[index] = ListNode(key,value)
        else:
            cur = self.nodes[index]
            while True:
                if cur.pair[0] == key:
                    cur.pair = (key,value)
                    return
                if cur.next == None:
					break
                cur = cur.next
            cur.next = ListNode(key,value)        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
		#Time complexity for get operation - O(N), worst case if it is last index
		#Space omplexity - O(1)
        index = key%(self.size)
        cur = self.nodes[index]
        while cur:
            if cur.pair[0] == key:
                return cur.pair[1]
            else:
                cur = cur.next
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
		#Time complexity for get operation - O(N), worst case if LinkedList has many nodes
		#Space omplexity - O(1)
        index = key%(self.size)
        cur = prev = self.nodes[index]#Storing prev value to remove a node and change the next pointer
        if not cur:
			return
        if cur.pair[0] == key:
            self.nodes[index]=cur.next
        else:
            cur = cur.next
            while cur:
                if cur.pair[0] == key:
                    prev.next =cur.next
                    break
                else:
                    cur,prev = cur.next,prev.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)