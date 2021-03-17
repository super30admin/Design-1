// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// I have used a 2069 Buckets with each Bucket being a List of values
import java.util.ArrayList;
import java.util.List;

class Pair<U,V>{
    public U first;
    public V second;
    public Pair(U first,V second){
        this.first = first;
        this.second = second;
    }
}
class Bucket{
    private List<Pair<Integer,Integer>> bucket;
    public Bucket(){
        this.bucket = new ArrayList<Pair<Integer,Integer>>();



    }
    public Integer get(Integer key){
        for (Pair<Integer,Integer> pair:this.bucket) {
            if(pair.first == key){
                return pair.second;
            }

        }
        return -1;
    }
    public void update(Integer key,Integer value){
        boolean found = false;
        for (Pair pair:bucket) {
            if(pair.first.equals(key)){
                pair.second = value;
                found = true;
                break;
            }

        }
        if (!found){
            this.bucket.add(new Pair<>(key, value));
        }

    }

    public void remove(Integer key){
        for (Pair pair:bucket) {
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;

            }

        }
    }

}
public class HashMap {
    private Integer keySpace;
    private List<Bucket> hashTable;
    public HashMap(){
        this.keySpace = 2069;
        this.hashTable = new ArrayList<Bucket>();
        for (int i = 0; i < this.keySpace ; i++) {
            this.hashTable.add(new Bucket());
        }
    }
    public Integer get(Integer key){
        Integer hash = key % this.keySpace;
        return this.hashTable.get(hash).get(key);

    }
    public void put(Integer key, Integer value){
        Integer hash = key % this.keySpace;
        this.hashTable.get(hash).update(key,value);

    }

    public void remove(Integer key){
        Integer hash = key % this.keySpace;
        this.hashTable.get(hash).remove(key);
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, 2);
        hashMap.put(2, 3);

        hashMap.get(3);
        hashMap.put(2, 4);
        hashMap.get(2);
        hashMap.remove(2);




    }

}
