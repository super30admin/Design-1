 public class MyHashSet {
   //Approach: Determine size of primary and secondary array based on the dataset
   //          Determine the primary and secondary hash function
   //          If adding secondary array value for that key will be true and if removing secondary array value for that key will be false.


// Time Complexity : Add - O(N), Remove - O(N) and Contains - O(N)
// Space Complexity : Considering the large dataset O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
   
    private bool[][] storage;
        private int buckets;
        private int bucketItems;

        private int PrimaryHash(int key)
        {
            return key%buckets;
        }

        private int SecondaryHash(int key)
        {
            return key/bucketItems;
        }

        public MyHashSet()
        {
            buckets = 1000;
            bucketItems = 1000;
            storage = new bool[1001][];
        }

      
        public void Add(int key)
        {
            int bucket = PrimaryHash(key);
            if(storage[bucket] == null)
            {
                if (bucket == 0)
                {
                    storage[bucket] = new bool[bucketItems + 1];
                }
                else
                {
                    storage[bucket] = new bool[bucketItems];
                }
            }
            int bucketItem = SecondaryHash(key);
            storage[bucket][bucketItem] = true;
        }

        public void Remove(int key)
        {
            int bucket = PrimaryHash(key);
            if (storage[bucket] == null)
            {
                return;
            }
            int bucketItem = SecondaryHash(key);
            storage[bucket][bucketItem] = false;
        }

        public bool Contains(int key)
        {
            int bucket = PrimaryHash(key);
            if (storage[bucket] == null)
            {
                return false;
            }

            int bucketItem = SecondaryHash(key);
            return storage[bucket][bucketItem];
        }
}


