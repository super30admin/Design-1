import java.util.Arrays;

/*
Time Complexity : put O(1), get O(1), and remove O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :


Your code here along with comments explaining your approach
1. To implement HashMap, I used array data structure
2. For put operation, I will be having key as the index of the array and value will be stored corresponding to that
key
3. For get operation, key is given and based on the key I am extracting value from the array, key as the index
4. To remove, I am using key and setting value corresponding to this key index as -1, cause as the constraint it is
mentioned that value and key both will be positive 0 <= key, value <= 10^6

 */
public class HashMap {
    int [] map;
    public HashMap(){
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value){
        map[key] = value;
    }

    public int get(int key){
        return map[key];
    }

    public void remove(int key){
        System.out.println("Removing element for the key: "+ key);
        map[key] = -1;
    }

    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put(0, 1);
        map.put(1, 2);
        map.put(2, 3);
        System.out.println(map.get(2));
        map.remove(0);
    }
}
