class MyHashSet:
    '''
    Design a hashset using boolean array for storage
    https://leetcode.com/problems/design-hashset/

    Design a HashSet without using any built-in hash table libraries.
    Implement MyHashSet class:
    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

    Example 1:
        Input: ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
                [[], [1], [2], [1], [3], [2], [2], [2], [2]]
        Output:
              [null, null, null, true, false, null, true, null, false]
        Explanation:
            MyHashSet myHashSet = new MyHashSet();
            myHashSet.add(1);      // set = [1]
            myHashSet.add(2);      // set = [1, 2]
            myHashSet.contains(1); // return True
            myHashSet.contains(3); // return False, (not found)
            myHashSet.add(2);      // set = [1, 2]
            myHashSet.contains(2); // return True
            myHashSet.remove(2);   // set = [1]
            myHashSet.contains(2); // return False, (already removed)

    Constraints:
        0 <= key <= 10^6

    Reference:
        https://www.youtube.com/watch?v=Luk-_Jtb_v4
    '''
    def __init__(self):
        '''
            init hash

            Time: O(1), Space: O(N) (N = length of primary array)
        '''
        print(f"\n --- Hashset --- ")
        self.len_primary = 1000 # sqrt(max key) = sqrt(10^6)
        self.len_secondary = 1000 # sqrt(max key) = sqrt(10^6)
        # create a list of head nodes; head node is a dummy node
        # with no information in key. Hence, key = None
        self.set = [False]*self.len_primary

    def hash(self, k):
        '''
        convert key to index
        '''
        primary_array_index = k % self.len_primary
        secondary_array_index = k // self.len_secondary
        return (primary_array_index, secondary_array_index)

    def add(self, k):
        '''
        add key to hash

        Time: O(1), Space: O(1) (best case), O(N) (worst case) (N = length of secondary array)
        '''
        assert k >= 0 and k <= 1000000, f"key must be in the range [0, 1e6]"
        i, j = self.hash(k)
        curr = self.set[i]
        if not curr:
            # special case: key = 10^6 (upper bound of range of keys)
            # if key = 10^6, i = 0, j = 10^3
            # Hence, self.set[0] should have a secondary array of size 10^3 + 1
            if i == 0:
                self.set[i] = [False]*(self.len_secondary + 1)
            else:
                self.set[i] = [False]*self.len_secondary
        if self.set[i][j]:
            print(f"Key = {k} already present at position {i, j}")
        else:
            self.set[i][j] = True
            print(f"Key = {k} added at position {i, j}")


    def contains(self, k):
        '''
        check if key is present in hash or not

        Time: O(1), Space: O(1)
        '''
        i, j = self.hash(k)
        curr = self.set[i]
        if not curr:
            print(f"Not found {k}")
            return False
        print(f"Found {k} at position {i, j}") if self.set[i][j] else print(f"Not found {k}")
        return self.set[i][j]

    def remove(self, k):
        '''
        remove key from hash if it exists

        Time: O(1), Space: O(1)
        '''
        i, j = self.hash(k)
        curr = self.set[i]
        if not curr:
            print(f"Key = {k} not found, nothing to be removed")
            return False
        print(f"Remove key = {k} at position {i, j}")
        self.set[i][j] = False

def run_hashset():
    h = MyHashSet()
    h.add(1) # set = [1]
    h.add(2) # set = [1, 2]
    h.add(1002) # set = [1, [2, 1002]]
    h.add(2002) # set = [1, [2, 1002, 2002]]
    h.contains(1) # return True, (found)
    h.contains(1002) # return True, (found)
    h.contains(2002) # return True, (found)
    h.contains(3002) # return False, (not found)
    h.contains(3) # return False, (not found)
    h.add(2) # set = [1, [2, 1002, 2002]]
    h.contains(2) # return True
    h.remove(2) # set = [1, [1002, 2002]]
    h.contains(2) # return False, (already removed)
    h.contains(2002) # return True, (found)

    # special case: key = 10^6
    h.add(1000000) # added key at position (0,1000)


run_hashset()