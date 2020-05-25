// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Designing HashMap w/o using any inbuilt libraries
 * Using Array with default capacity of 16 and increasing the size of it when 75% of the array is filled.
 * No collision check involved -- mentioned in the problem stmt.
 */
public class HashMap_simple {
    int[] values;                       //stores the values with key being the array index
    int capacity;                       // default size of the array
    int size;                           // filled array size

    HashMap_simple(){
        capacity = 16;                  //Default value used by Java too
        values = new int[capacity];
        fillArray(values);              //filling the values of the array with dummy value
        size = 0;
    }

    /**
     * filling the values of the array with dummy value, here Integer.MIN_VALUE
     * @param array
     */
    public void fillArray(int[] array){
        for(int i=0; i< capacity; i++)
            array[i] = Integer.MIN_VALUE;
    }

    /**
     * Putting the values in the array
     * @param key
     * @param val
     */
    public void put(int key, int val){
        if(size >= 0.75*capacity){
            values = increaseCapacity();                //Trying to avoid collisions by increasing the capacity of the array
        }
        if(values[key%capacity] == Integer.MIN_VALUE)   // increasing the size of the array of the value is dummy
            size++;
        values[key%capacity] = val;                     //Hash the key -- index & input the value in the index position
    }

    /**
     * Increasing the capacity of the HashMap when 75% of the array is filled inorder to avoid collisions and optimize the working of hashmap
     * @return newarray
     */
    public int[] increaseCapacity(){
        capacity = 2*capacity;                        // double the capacity of the array
        int[] newarray = new int[capacity];
        fillArray(newarray);
        for(int i=0;i<values.length;i++){
            if(values[i] != Integer.MIN_VALUE){       // check if the value is not a dummy then place it in new array with new hashed key
                newarray[i%capacity] = values[i];
            }
        }
        return newarray;
    }

    /**
     * returns -1 if key is not present else returns the value
     * @param key
     * @return -1 if key is not present else returns the value
     */
    public int get(int key){
        return values[key%capacity] == Integer.MIN_VALUE ? -1 : values[key%capacity];
    }

    /**
     * if key is present then decrease the size and place dummy value in the hashed key indicating no value
     * @param key
     */
    public void remove(int key){
        if(values[key%capacity] != Integer.MIN_VALUE) {
            values[key % capacity] = Integer.MIN_VALUE;
            size--;
        }
    }

    public static void main(String[] args){
        HashMap_simple hmap = new HashMap_simple();
        hmap.put(1,2);
        System.out.println(hmap.get(1));
        System.out.println(hmap.get(3));
        hmap.put(2,4);
        System.out.println(hmap.get(2));
        hmap.remove(2);
        System.out.println(hmap.get(2));
    }
}
