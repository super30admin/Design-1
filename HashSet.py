class HashSet(object):
    """
    A HashSet implementation using a 2D list.

    Attributes:
    bucket_count (int): The number of buckets in the HashSet.
    data_list (list): A 2D list representing the HashSet.
    """

    def __init__(self):
        """
        Initializes the HashSet with a specified number of buckets.

        Time complexity: O(n)
        Space complexity: O(n)
        """
        self.bucket_count = 1000
        self.data_list = [0] * self.bucket_count

    def hash_function_1(self, key):
        """
        Calculates the index of the primary list using the modulo operator.

        Time complexity: O(1)
        Space complexity: O(1)
        """
        return key % self.bucket_count

    def hash_function_2(self, key):
        """
        Calculates the index of the secondary list using integer division.

        Time complexity: O(1)
        Space complexity: O(1)
        """
        return key // self.bucket_count

    def add(self, key):
        """
        Adds a key to the HashSet.

        Time complexity: O(1) on average, O(n) in the worst case
        Space complexity: O(n) in the worst case
        """
        hash_value_1 = self.hash_function_1(key)

        if not self.data_list[hash_value_1]:
            if hash_value_1 == 0:
                self.data_list[hash_value_1] = [False] * (self.bucket_count + 1)
            else:
                self.data_list[hash_value_1] = [False] * self.bucket_count

        hash_value_2 = self.hash_function_2(key)
        self.data_list[hash_value_1][hash_value_2] = True


    def remove(self, key):
        """
        Removes a key from the HashSet.

        Time complexity: O(1) on average, O(n) in the worst case
        Space complexity: O(1)
        """
        hash_value_1 = self.hash_function_1(key)
        if not self.data_list[hash_value_1]:
            return
        hash_value_2 = self.hash_function_2(key)
        if hash_value_2 < len(self.data_list[hash_value_1]):
            self.data_list[hash_value_1][hash_value_2] = False



  def contains(self, key):
      """
      Checks if a key exists in the HashSet.
  
      Time complexity: O(1) on average, O(n) in the worst case
      Space complexity: O(1)
      """
      hash_value_1 = self.hash_function_1(key)
      if not self.data_list[hash_value_1]:
          return False
  
      hash_value_2 = self.hash_function_2(key)
      if hash_value_2 < len(self.data_list[hash_value_1]):
          return self.data_list[hash_value_1][hash_value_2]
      return False
