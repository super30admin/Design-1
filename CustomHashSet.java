package Problem2;
//Implement HashSet without using any built-in libraries.
//Leetcode Link : https://leetcode.com/problems/design-hashset/


import java.util.LinkedList;
import java.util.List;

public class CustomHashSet {
    private int numOfBuckets = 15000 ;
    List<Integer>[] buckets ;
    private int hashFunction(int key){
        return key % numOfBuckets ;
    }

    public CustomHashSet() {
        buckets = new LinkedList[numOfBuckets];
    }

    public void add(int key) {
        int i = hashFunction(key);
        if(buckets[i] == null){
            buckets[i]= new LinkedList<>();
        }
        if(buckets[i].indexOf(key) == -1){
            buckets[i].add(key);
        }

    }

    public void remove(int key) {
        int i = hashFunction(key);
        if(buckets[i] == null){
            return ;
        }
        if(buckets[i].indexOf(key) != -1)
        {
            buckets[i].remove(buckets[i].indexOf(key));
        }
    }

    public boolean contains(int key) {
        int i = hashFunction(key);
        if(buckets[i] == null || buckets[i].indexOf(key) == -1){
            return false ;
        }
        else
            return true ;
    }
}
