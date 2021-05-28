import java.util.List;
import java.util.LinkedList;

class MyHashMap {
    List[] myArr = new LinkedList[10];
    void HashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = Integer.hashCode(key);
        //System.out.println(hashCode);

        List<Node> bucketList;
        //System.out.println(myArr.length);
        if(myArr.length <= hashCode) {
            //increase the capacity of the array
            myArr = increaseListCapUtility(myArr.length);
        }

        if(myArr.length > hashCode && myArr[hashCode] == null) {
            //if the bucket size is more than or equal to hash code, then check the value at the place of hashcode is empty
            //if yes then create a linked list and add the linked list to the bucket
            bucketList = new LinkedList<>();
            bucketList.add(new Node(key, value));
            myArr[hashCode] =  bucketList;

        } else if(myArr.length > hashCode && myArr[hashCode] != null) {
            //if the key already exist, replace the value with new value
            bucketList = myArr[hashCode];
            for(int i = 0; i < bucketList.size(); i++) {
                    if(bucketList.get(i).getKey() == key) {
                        bucketList.set(i, new Node(key, value));
                    }
                }
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //Get the hashcode of the given key
        int hashCode = Integer.hashCode(key);
        //check the array at the specific index, if the ptr for link list exist then traverse and find the value for key
        if(myArr[hashCode] != null) {
            List<Node> bucketList = myArr[hashCode];
            for(int i=0; i< bucketList.size();i++) {
                if(bucketList.get(i).getKey() == key) {
                    return bucketList.get(i).getValue();
                }
            }
        }
       return -1;

    }

    public void remove(int key) {
        //Get the hashcode of the given key
        int hashCode = Integer.hashCode(key);
        //check array at the specific location is empty or not, if its not traverse the link list and find the value for key and remove it
        //if not found return -1
        if(myArr[hashCode] != null) {
            List<Node> bucketList = myArr[hashCode];
            for(int i=0; i< bucketList.size();i++) {
                if(bucketList.get(i).getKey() == key) {
                    bucketList.remove(i);
                    System.out.println("Key and value removed from the bucket");
                    return;
                }
            }
        }
        System.out.println("Value does not exist in the map");
    }

    public List[] increaseListCapUtility(int size) {
        size = size*2;
        List[] newArr = new List[size];
        for(int i=0; i<myArr.length;i++) {
            newArr[i] = myArr[i];
        }
        myArr = newArr;
        return myArr;
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        MyHashMap obj = new MyHashMap();
        obj.put(1,2);
        System.out.println("key found or not "+ obj.get(1));
        obj.put(5,4);
        obj.put(1,4);
        obj.put(3,5);
        obj.put(10,5);

        System.out.println("key found or not: "+ obj.get(3));
        System.out.println("key found or not: "+ obj.get(6));
        System.out.println("key found or not: "+ obj.get(1));
        System.out.println("key found or not: "+ obj.get(10));

        obj.remove(1);
        System.out.println("key found or not: "+ obj.get(1));


    }
}
