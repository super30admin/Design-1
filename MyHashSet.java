/* Design a HashSet without using any built-in hash table libraries.

 Implement MyHashSet class:

 void add(key) Inserts the value key into the HashSet.
 bool contains(key) Returns whether the value key exists in the HashSet or not.
 void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Constraints:
0 <= key <= 10`6
At most 10`4 calls will be made to add, remove, and contains. */

public class MyHashSet {
    int primaryIndex = 1000;
    int secondaryIndex = 1000;
    int array[][] = new int[primaryIndex][secondaryIndex];
    public MyHashSet(){
        this.primaryIndex = primaryIndex;
        this.secondaryIndex = secondaryIndex;
    }


    private void add(int key){
        int priRem = key%primaryIndex;
        int secRem = key/secondaryIndex;
        if(array[priRem][secRem] == 0){
            array[priRem][secRem] = key;
        }
        System.out.println("Element added:"+key);
    }

    private void remove(int key){
        int priRem = key%primaryIndex;
        int secRem = key/secondaryIndex;
        if(array[priRem][secRem] == key){
            array[priRem][secRem] = 0;
        }
        System.out.println("Element removed:"+key);
    }
    
    private boolean contains(int key){
        int priRem = key%primaryIndex;
        int secRem = key/secondaryIndex;
        if(array[priRem][secRem] == key){
            System.out.println("Element Found: "+key);
            return true;
        }
        System.out.println("Element Not Found: "+key);
        return false;
     }

     public static void main(String[] args) {
        MyHashSet s = new MyHashSet();
        s.add(10001);
        s.add(12345);
        s.add(1);
        s.add(73556);
        s.add(32445);
        s.remove(12345);
        s.contains(1);
     }

}
