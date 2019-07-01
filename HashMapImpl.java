/**Reference https://www.javamadesoeasy.com/2015/02/hashmap-custom-implementation.html */
public class HashMapImpl {

    private Entry[] hashMap;
    private int capacity= 4; 

    static class Entry{
        Integer key;
        Integer value;

        public Entry(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    public HashMapImpl(){
        this.hashMap = new Entry[capacity];
    }

    private int hash(Integer key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(int newKey, int data){
        
        int hash=hash(newKey);
       //create new entry.
       Entry newEntry = new Entry(newKey, data);
       hashMap[hash] = newEntry;
    }
    
    public int get(int key){
        int hash = hash(key);
        if(hashMap[hash] == null){
         return -1;
        }else{
         Entry temp = hashMap[hash];
        if(temp != null){
            return temp.value;
        }   
        else{
            return -1;
        }
        }
    }

    public boolean remove(int deleteKey){
        int hash=hash(deleteKey);
              
        if(hashMap[hash] == null){
              return false;
        }else{
            hashMap[hash] = null;
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("HashMap Implementation statrts");
        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put(1, 5);
        hashMap.put(2, 10);
        hashMap.put(3, 15);

        System.out.println(hashMap.get(3));
        hashMap.put(3, 17);
        System.out.println(hashMap.get(3));
        hashMap.remove(3);
        System.out.println(hashMap.get(3));

    }
}