//time complexity- O(1) 
//space complexity- O(n)
// passed all test cases on leetcode
// as the range is 1000000 we can take outer array size as 1000 and inner array size as 1000 as it is the best possible design for the overall cases and i have used modulus operator on the outer array and division operator on the inner array to access the index of the element
class hashset {
    private int outer;
    private int inner;
    boolean arr[][];

    public MyHashSet() {
        outer=1000;
        this.inner=1000;
        arr=new boolean[1000][];
    }

    private int outerhash(int key) {
        return key % 1000;
    }

    private int innerhash(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int out = outerhash(key);
        if (arr[out] == null) {
            if (out == 0)
                arr[out] = new boolean[inner + 1];
            else
                arr[out] = new boolean[inner];
        }
        int in = innerhash(key);
        arr[out][in] = true;
    }

    public void remove(int key) {
        int out = outerhash(key);
        if (arr[out] == null) {
            return;
        }
        int in = innerhash(key);
        arr[out][in] = false;
    }

    public boolean contains(int key) {
        int out = outerhash(key);
        if (arr[out] == null) {
            return false;
        }
        int in = innerhash(key);
        return arr[out][in];
    }
}
