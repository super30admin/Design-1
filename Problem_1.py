#time_complexity: O(1)
#space_complexity: O(n)

class MyHashMap:

	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.hashlist = [None]*99999
		

	def put(self, key: int, value: int) -> None:
		"""
		value will always be non-negative.
		"""
		self.hashlist[key] = value
		

	def get(self, key: int) -> int:
		"""
		Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		"""
		if self.hashlist[key] is None:
			return -1
		else:
			return self.hashlist[key]
		

	def remove(self, key: int) -> None:
		"""
		Removes the mapping of the specified value key if this map contains a mapping for the key
		"""
		self.hashlist[key] = None
		


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)