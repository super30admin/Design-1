namespace CustomDataStructures
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : One specific issue I faced in this problem is 
    // on how to differentiate between the actual value that needs to be stored being '0' and
    // the initial default value of an int data type in the array. I explored two solutions for
    // resolving this issue. The first one being  initializing the hashMap with -1, but this solution takes O(N)
    // and that defeats the purpose of HashMap. So I resorted to the second solution of storing the incoming actual value '0' as -2 
    // with an arithmetic operation. And while getting the value in Get() method, if it is -2, 
    // I am returning '0'

    public class MyHashMap
    {

        private int[][] arr;
        private int buckets;
        private int bucketItems;

        /** Initialize your data structure here. */
        public MyHashMap()
        {
            buckets = 1000;
            bucketItems = 1000;
            arr = new int[buckets][];
        }

        //Hash function for caluclating index of the buckets
        public int bucket(int key)
        {
            return key % buckets;
        }

        //Hash function for caluclating index of the bucket items (Nested index - index for the nested structure)
        public int bucketItem(int key)
        {
            return key / bucketItems;
        }

        //Time Complexity - O(1)
        //Space Complexity - O(n) in this method - Since we have to just allocated BucketItems here
        /** value will always be non-negative. */
        public void Put(int key, int value)
        {
            var firstIndex = bucket(key);
            var secondIndex = bucketItem(key);
            if (arr[firstIndex] == null)
            {
                if (firstIndex == 0)   
                {
                    // If the key is 10^6, then our hash function returns 1000 for the 0th index,
                    // where as we can only store 0 to 999 bucketItems, for this reason I am checking if the first index is 0, 
                    // then allocate 1001 elements so that my index can go upto 1000 for the bucket items
                    arr[firstIndex] = new int[bucketItems + 1];
                }
                else
                {
                    arr[firstIndex] = new int[bucketItems];
                }
            }
            if (value == 0)
            {
                arr[firstIndex][secondIndex] = value - 2;
            }
            else
            {
                arr[firstIndex][secondIndex] = value;
            }

        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int Get(int key)
        {
            var firstIndex = bucket(key);
            var secondIndex = bucketItem(key);
            if (arr[firstIndex] == null || arr[firstIndex][secondIndex] == 0)
            {
                return -1;
            }
            if (arr[firstIndex][secondIndex] == -2)
            {
                return 0;
            }
            return arr[firstIndex][secondIndex];
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void Remove(int key)
        {
            var firstIndex = bucket(key);
            var secondIndex = bucketItem(key);
            if (arr[firstIndex] == null || arr[firstIndex][secondIndex] == -1) return;
            arr[firstIndex][secondIndex] = -1;
        }
    }
 }
