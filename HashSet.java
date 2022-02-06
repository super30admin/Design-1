/*
Implement HashSet without using any built-in libraries.

your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
Example:

MyHashSet hashSet = new MyHashSet();
 */
/*
Implement HashSet without using any built-in libraries.

your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
Example:

MyHashSet hashSet = new MyHashSet();
 */
class MyHashSet {
    private static int H1_HELPER = 1000;
    private static int H2_HELPER = 1000;
    private boolean[][] arr;

    public MyHashSet() {
        arr = new boolean[H1_HELPER][];
    }

    private int getHash1(int key)
    {
        return key%H1_HELPER;
    }

    private int getHash2(int key)
    {
        return key/H2_HELPER;
    }

    public void add(int key) {
        if (!contains(key))
        {
            int hash1 = getHash1(key);
            if (arr[hash1] == null)
            {
                //handle edsge case case of 10^6
                if (hash1 == 0)
                {
                    arr[hash1] = new boolean[H1_HELPER+1];
                }
                else
                {
                    arr[hash1] = new boolean[H1_HELPER];
                }
            }
            int hash2 = getHash2(key);
            arr[hash1][hash2] = true;

        }

    }

    public void remove(int key) {
        if(contains(key))
        {
            int hash1  = getHash1(key);
            int hash2 = getHash2(key);
            arr[hash1][hash2] = false;
        }
    }

    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if (arr[hash1] == null)
        {
            return false;
        }
        else
        {
            int hash2 = getHash2(key);
            return arr[hash1][hash2];
        }
    }


}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */