# Did this code successfully run on Leetcode : YES

# Approach
# obviously we need a hash function - common choice is modulus
# i chose modulus by 100003 - decent tradeoff between space and number of collisions
# weird thing happening is if i choose modulus by 10001 code does not execute on Leetcode
# would appreciate some help on that
# for handling collisions i am using single probing using linkedlist

class Node:
	
	def __init__(self, key, value=-1, next=None):
		"""
		general purpose implementation for singly linkedlist
		---------
		arguments:
		key: int, the key attribute of the hashmap
		value: int, the value corresponding to the key
		next: none/Node, none by default, can be extended to refer to next node
		---------
		returns:
		none
		"""
		self.key = key
		self.value = value
		self.next = next

class MyHashMap:

	def __init__(self):
		"""
		Initialize your data structure here.
		choice of hash function = modulus by hashdiv (= 100003)
		base storage will be array of size hashdiv (= 100003)
		obviously there will be tradeoff between space and number of collisions
		if hashdiv is too big, collisions will be rare but space used will be large
		if hashdiv is too small, space used will be small but higher probability of collisions occuring
		"""
		self.hashdiv = 100003
		self.hashmap = [-1]*self.hashdiv

	def put(self, key: int, value: int) -> None:
		"""
		value will always be non-negative.
		insert key: value pair in hashmap
		also takes care of updating: if key is already present in hashmap value is updated
		TC: O(1) in best case, O(N/hashdiv) in worst case
		"""
		temp = self.hashmap[key%self.hashdiv]
		if temp == -1:
			self.hashmap[key%self.hashdiv] = Node(key, value)
		else:
			found = False
			while temp:
				if temp.key == key:
					found = True
					temp.value = value
					break
				temp = temp.next
			if not found:
				temp.next = Node(key, value)
		

	def get(self, key: int) -> int:
		"""
		Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		TC: O(N/hashdiv)
		"""
		temp = self.hashmap[key%self.hashdiv]
		if temp == -1:
			return temp
		while temp:
			if temp.key == key:
				return temp.value
			temp = temp.next

	def remove(self, key: int) -> None:
		"""
		Removes the mapping of the specified value key if this map contains a mapping for the key
		since implementation uses linkedlist i just replace value in the key value pair by -1 since 
		that is expected output if key not found
		TC: O(N/hashdiv)
		"""
		temp = self.hashmap[key%self.hashdiv]
		if temp == -1:
			return
		while temp:
			if temp.key == key:
				temp.value = -1
			temp = temp.next
		
		


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)