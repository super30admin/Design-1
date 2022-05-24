// Time Complexity : O(1) on average for add operation and O(n) on average for remove operation;  O(n) is the worst case time complexity for remove, contains, add operation
// Space Complexity : O(n) as size increases during add operation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced stack overflow related problems 

// Your code here along with comments explaining your approach

class MyHashSet {

    int[] arr;
    static int MAX = 5;
    static int counter = -1;
    static double CFUpper = 0.5;
    static double CFLower = 0.2;
    static int MF = 2;
    static int k = 0;
    static int n = 0;
    static double c;
    static double m;

    public MyHashSet() {
        this.arr = new int[MAX];
    }

    public void add(int key) {

        if (contains(key)) {
            arr[k] = key;
            return;
        }
        c = (double) counter;
        m = (double) MAX;
        // System.out.println("Counter/MAX: " + c/m);
        if (c / m >= CFUpper) {
            int max = MAX;
            int[] temp = new int[MAX]; // creating a temporary array to store the existing values in array "arr"
            for (int i = 0; i < MAX; i++)
                temp[i] = arr[i];

            MAX = MAX * MF; // increasing the size of the array by multiplicative factor 2
            this.arr = new int[MAX];
            for (int i = 0; i < max; i++)
                arr[i] = temp[i];
            arr[++counter] = key;
        } else
            arr[++counter] = key;
    }

    public void remove(int key) {

        if (counter == -1 || !contains(key)) {
            System.out.println(
                    "Either there aren't keys present in the array to remove or the specific key requested to remove isn't present in the array");
            return;
        }
        c = (double) counter;
        m = (double) MAX;
        if (c / m < CFLower) {
            // System.out.println("Counter/MAX: " + c/m);
            // int max = MAX;
            int[] temp = new int[MAX]; // creating a temporary array to store the existing values in array "arr"
            for (int i = 0; i < MAX; i++)
                temp[i] = arr[i];

            MAX = MAX / MF; // increasing the size of the array by multiplicative factor 2
            this.arr = new int[MAX];
            for (int i = 0; i <= counter; i++)
                arr[i] = temp[i];

            // System.out.println("Removing " + temp[k]);
            for (int i = k; i <= counter; i++) {
                // System.out.println("printing arr["+i + "] " + arr[i] +" and temp[" + (i+1)
                // +"] " + temp[i+1]);
                arr[i] = temp[i + 1];
                // print();
            }
            --counter;
            return;

        } else {
            if (contains(key)) {
                // System.out.println("Removing " + arr[k]);
                for (int i = k; i <= counter; i++)
                    arr[i] = arr[i + 1];
                --counter;
                return;
            }
        }
    }

    public boolean contains(int key) {

        for (int i = 0; i <= counter; i++) {
            k = i;
            if (arr[i] == key)
                return true;
        }
        return false;
    }

    public void print() {
        System.out.print(" [ ");
        for (int i = 0; i <= counter; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("] ");
        System.out.println(" ");
    }

    public static void main(String args[]) {
        MyHashSet myHashSet = new MyHashSet();
    	myHashSet.add(1);      // set = [1]
    	myHashSet.add(2);      // set = [1, 2]
    	myHashSet.contains(1); // return True
    	myHashSet.contains(3); // return False, (not found)
    	myHashSet.add(2);      // set = [1, 2]
    	myHashSet.contains(2); // return True
    	myHashSet.remove(2);   // set = [1]
    	myHashSet.contains(2); // return False, (already removed)
    }
}
