// Time Complexity : Add: O(1), Remove: O(1), Contains: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Problem 1
public class MyHashSet {
    boolean[][] arr;
    int primaryArr;
    int secondaryArr;

    public MyHashSet() {
        //Initialized values and array
        primaryArr = 1000;
        secondaryArr = 1000;
        arr = new boolean[primaryArr][];
    }

    // indexPrimaryArr to find an index of Primary array
    private int indexPrimaryArr(int key){
        return key % primaryArr;
    }

    // indexSecondArr to find an index of Secondary array
    private int indexSecondArr(int key){
        return key / secondaryArr;
    }

    public void add(int key) {
        // get an index of Primary array
        int indexPA = indexPrimaryArr(key);

        // get an index of Secondary array
        int indexSA = indexSecondArr(key);

        // Check index of Primary array, if it's null set value to Secondary array's 0th index
        if(arr[indexPA] == null){
            if(indexPA == 0){
                // To add value between 1 and 1000
                arr[indexPA] = new boolean[secondaryArr+1];
            }
            else{
                arr[indexPA] = new boolean[secondaryArr];
            }
        }
        // set true on the available index of arr array
        arr[indexPA][indexSA] = true;

    }

    public void remove(int key) {
        int indexPA = indexPrimaryArr(key);
        int indexSA = indexSecondArr(key);

        // Check index of Primary array, if it's null return false
        if(arr[indexPA] == null){
            return;
        }
        else{
            arr[indexPA][indexSA] = false;
        }
    }

    public boolean contains(int key) {
        int indexPA = indexPrimaryArr(key);
        int indexSA = indexSecondArr(key);

        // Check index of Primary array, if it's null return false
        if(arr[indexPA] == null){
            return false;
        }
        return arr[indexPA][indexSA];
    }
}
