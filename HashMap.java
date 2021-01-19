import java.util.ArrayList;

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    ArrayList<Pair> pairs; 

    public Bucket() {
        pairs = new ArrayList<Pair>();
    }
}

public class HashMap {

    ArrayList<Bucket> buckets;
    final int num_buckets = 4099;

    public HashMap() {
        buckets = new ArrayList<Bucket>();
        for(int i=0; i<num_buckets; i++) {
            buckets.add(new Bucket());
        }
    }

    public void put(int key, int value) {

        int bucket_index = key % num_buckets;
        ArrayList<Pair> pairs = buckets.get(bucket_index).pairs;
        boolean found = false;
        for(int i=0; i< pairs.size(); i++) {
            Pair currPair = pairs.get(i);
            if(currPair.key == key) {
                found = true;
                pairs.get(i).value = value;
            }
        }
        if (!found) {
            Pair ele = new Pair(key, value);
        buckets.get(bucket_index).pairs.add(ele);
        }
        
    }
    
    public int get(int key) {
        int bucket_index = key % num_buckets;
        ArrayList<Pair> pairs = buckets.get(bucket_index).pairs;

        for(int i=0; i< pairs.size(); i++) {
            Pair currPair = pairs.get(i);
            if(currPair.key == key) {
                return currPair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket_index = key % num_buckets;
        ArrayList<Pair> pairs = buckets.get(bucket_index).pairs;

        for(int i=0; i< pairs.size(); i++) {
            Pair currPair = pairs.get(i);
            if(currPair.key == key) {
                pairs.remove(i);
            }
        }
    }
    
}

class HashMapMain {
    public static void main(String[] args) {
        HashMap obj = new HashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
    }
}