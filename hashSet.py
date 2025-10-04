class MyHashSet:
	def __init__(self):
		# HashSet has following properties
		# Given a key:
		#     Search should be in O(1) time complexity
		#     Insert should be in O(1) time complexity
		#     Remove be in O(1) time complexity
		# To achieve the above we can naively use an array to store the key's
		# And based on the range, the value that needs to be stored will be the key of the array. So we can perform all the above operations using an array.
		# However this would take more space and we can implement it in a better way
		# We can divide the array into buckets each bucket can store some values and others can store other values. The array would store the references to this buckets. Lets call this primaryBuckets and the size of this array be primaryBucketsSize
		self.primaryBucketsSize = 1000
		# We also need to define the size of each bucket.
		self.bucketsSize = 1000; # Simply divide the input by primaryBucketsSize
		# We also need to store this values so we can initialize a store
		self.store = [None] * self.primaryBucketsSize

	def getPrimaryBucketIndex(self, key: int):
		# This is nothing but a hash function
		# used to get the index where the key should be stored in the primaryArrayBuckets
		# For this we will use % operator as hash function
		return key % self.primaryBucketsSize

	def getBucketIndex(self, key: int):
		# This is nothing but a hash function
		# used to get the index where the key should be stored in the secondarArrayBuckets
		# For this we will use division operator as hash function
		return key // self.bucketsSize

	def add(self, key: int) -> None:
		primaryBucketIndex = self.getPrimaryBucketIndex(key)

		# Try to check based on our has can we store this somewhere
		# We do not have None at the primaryBucketIndex in the store
		if self.store[primaryBucketIndex]:
			bucketIndex = self.getBucketIndex(key)
			self.store[primaryBucketIndex][bucketIndex] = True
			return

		# We initialized the store with None
		# So we have to check that place where this key needs to be stored, has it been initialized or not
		if primaryBucketIndex == 0:
			self.store[primaryBucketIndex] = [False] * (self.bucketsSize + 1)
		else:
			self.store[primaryBucketIndex] = [False] * self.bucketsSize

		bucketIndex = self.getBucketIndex(key)
		self.store[primaryBucketIndex][bucketIndex] = True

	def remove(self, key: int) -> None:
		primaryBucketIndex = self.getPrimaryBucketIndex(key)
		if not self.store[primaryBucketIndex]:
			return
		bucketIndex = self.getBucketIndex(key)
		self.store[primaryBucketIndex][bucketIndex] = False

	def contains(self, key: int) -> bool:
		primaryBucketIndex = self.getPrimaryBucketIndex(key)
		if not self.store[primaryBucketIndex]:
			return False
		bucketIndex = self.getBucketIndex(key)
		return self.store[primaryBucketIndex][bucketIndex]

