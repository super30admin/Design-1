public class HashMap {
    private HashNode[] bucket; // array to store the HashNodes
    private int numberOfBuckets; // define number of buckets
    private int size; // number of

    //constructor define in the initial number of buckets
    //and initialize the HashNode bucket array
    HashMap(){
        this.numberOfBuckets = 16;
        bucket = new HashNode[this.numberOfBuckets];
        this.size = 0;
    }

    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put(1, 10);
        map.put(1, 20);
        map.put(2, 20);
        map.put(3, 30);
        map.remove(2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

    //method to return the index at which the hash node has to be inserted.
    //it first calculates the hash code of the key, based on the hash code
    //and from number of buckets bucket index is determined
    private int getIndex(Integer key){
        int hashCode = key.hashCode();
        int index = hashCode % numberOfBuckets;
        return index;
    }

    //method to insert HashNode
    //first get the bucketIndex and node at that index in bucket array
    //if a hashnode is already present in that index make the existing node 
    //as new node.next 
    //if size or load is greater than 0.7 increase the number of buckets
    public void put(Integer key, Integer value){
        int bucketIndex = getIndex(key);
        HashNode head = bucket[bucketIndex];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket[bucketIndex];
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        bucket[bucketIndex] = newNode;

        //if load factor goes beyond threshold then double hash table size
        if((1.0*size)/numberOfBuckets >= 0.7){
            HashNode[] temp =bucket;
            numberOfBuckets = 2 *numberOfBuckets;
            bucket = new HashNode[numberOfBuckets];
            size = 0;
            for(int i=0; i<numberOfBuckets; i++){
                bucket[i] = null;
            }
            for(HashNode node : temp){
                while (node !=null){
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        } 
    }

    //first calculate the bucket index
    //go to that bucketIndex in the array search for node
    //with same key value at that particular index
    public Integer get(Integer key){
        int bucketIndex = getIndex(key);
        HashNode head = bucket[bucketIndex];
        while (head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    //first calculate the bucket Index,
    //check node doesn't exists at that location return -1
    public Integer remove(Integer key){
        int bucketIndex = getIndex(key);
        HashNode node = bucket[bucketIndex];

        HashNode prev = null;
        while (node != null){
            if(node.key.equals(key)){
                break;
            }
            prev = node;
            node = node.next;
        }
        if(node == null) return -1;
        size--;

        if(prev != null){
            prev.next = node.next;
        }else{
            bucket[bucketIndex] = node.next;
        }
        return node.value;
    }

}
class HashNode{
    Integer key;
    Integer value;
    HashNode next;

    public HashNode(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }
}