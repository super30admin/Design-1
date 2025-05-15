/* Time Complexity: Add O(1); Remove O(1); Contains O(1)
   Space Complexity: Add O(1); Remove O(1); Contains O(1)

   Approach: Computing the initial hash of the  number by using modulo square of the range for the first dimension and divide by square root of the range for the second dimension gives us the exact boolean array element. If the element is added to the array then the corresponding array element computed by hash functions is set to true.
*/

public class MyHashSet {

    private bool[][] nums;

    public MyHashSet() {
        nums = new bool[1000][];
    }

    private int hash1(int key) {
        return key % 1000;
    }

    private int hash2(int key) {
        return key / 1000;
    }

    public void Add(int key) {
        int i = hash1(key);
        int j = hash2(key);

        if (nums[i] == null) {
            nums[i] = (i == 0) ? new bool[1001] : new bool[1000];
        }

        nums[i][j] = true;
    }

    public void Remove(int key) {
        int i = hash1(key);
        int j = hash2(key);

        if (nums[i] != null) {
            nums[i][j] = false;
        }
    }

    public bool Contains(int key) {
        int i = hash1(key);
        int j = hash2(key);

        return nums[i] != null && nums[i][j];
    }
}
