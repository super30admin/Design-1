//Time Complexity: O(1) for add, remove, contains
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

//Approach:
/* we are performing double-hashing,
size of array  = sqrt(10^6) (or) sqrt(ceil of the max constraint)
only initialize primary array first
initialize secondary array only if we need to insert a key
hashFunction 1 - gives idx of primary array
hashFunction 2 - gives idx of secondary array
we have an extra element (1000000) which gives a hash1 value 0 & hash2 value 1000
so we create an extra index where primary array index is 0
 */

//Constraints:
//0 <= key <= 10^6
//At most 10^4 calls will be made to add, remove, and contains.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashSet {
    private boolean[][] hs;
    private int size1;
    private int size2;

    HashSet() {
        this.size1 = 1000;
        this.size2 = 1000;
        this.hs = new boolean[size1][];
    }

    //first hash function
    public int hashFun1(int key) {
        return key%size1;
    }

    //second hash function
    public int hashFun2(int key) {
         return key/size1;
    }
    public void add(int key){
        int hashVal1 = hashFun1(key);
        int hashVal2 = hashFun2(key);
        if (this.hs[hashVal1] == null){//data-structure inside a data-structure is referred as a pointer, that is why we check with null
            if (hashVal1 == 0){
                this.hs[hashVal1] = new boolean[size2+1];
            } else {
                this.hs[hashVal1] = new boolean[size2]; // initializing primary array
            }
        }
        this.hs[hashVal1][hashVal2] = true; // marking the key position as true
        System.out.println("added "+key);
    }

    public void remove(int key) {
        int hashVal1 = hashFun1(key);
        int hashVal2 = hashFun2(key);
        if (this.hs[hashVal1] == null) return; // exit the function if the primary array idx is null, that means key value is not present in the hashset
        this.hs[hashVal1][hashVal2] = false; // if the value is present mark it as false, we only consider indexes that are marked as true are added
        System.out.println("Removed "+key);
    }

    public boolean contains(int key) {
        int hashVal1 = hashFun1(key);
        int hashVal2 = hashFun2(key);
        if (this.hs[hashVal1] == null) return false;
        return this.hs[hashVal1][hashVal2];
    }
    public static void main(String args[]) {
//        Reading input
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        input1 = input1.replaceAll("[\\[\\]\"]", "");
        String[] operations = input1.split(",\\s*");
        sc.nextLine();

        String valuesLine = sc.nextLine();

        valuesLine = valuesLine.substring(1, valuesLine.length() - 1);

        String[] parts = valuesLine.split("],\\s*\\[");

        List<List<Integer>> values = new ArrayList<>();

        for (String part : parts) {
            part = part.replaceAll("[\\[\\]]", "");
            List<Integer> nums = new ArrayList<>();

            if (!part.isEmpty()) {
                for (String num : part.split(",")) {
                    nums.add(Integer.parseInt(num.trim()));
                }
            }

            values.add(nums);

        }

        HashSet hashSet = new HashSet();
        for(int i=0;i<operations.length;i++) {
            if(operations[i].equals("add")) {
                hashSet.add(values.get(i).get(0));
            } else if(operations[i].equals("remove")){
                hashSet.remove(values.get(i).get(0));
            } else if(operations[i].equals("contains")){
                System.out.print("contains "+values.get(i).get(0)+" - ");
                System.out.println(hashSet.contains(values.get(i).get(0)));
            }
        }
    }
}

/*Test with the below input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]

[[], [1], [2], [1], [3], [2], [2], [2], [2]]
 */
