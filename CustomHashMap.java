package Day1;

public class CustomHashMap<K,V> {
    class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    Entry<K,V>[] arr_ent;
    int size = 10;

    /** Initialize your data structure here. */
    public CustomHashMap() {
        arr_ent = new Entry[size];

    }

    /** value will always be non-negative. */
    public void put(K key, V value) {
        if(key == null){
            return;
        }

        int hash_code = hash_gen(key);

        Entry<K, V> temp = new Entry<>(key, value, null);

        if(arr_ent[hash_code] == null){
            arr_ent[hash_code] = temp;
        }
        else{
            Entry<K, V> prev = null;
            Entry<K, V> curr = arr_ent[hash_code];

            while(curr != null){
                if(curr.key.equals(key)){
                    if(prev == null){
                        temp.next = curr.next;
                        arr_ent[hash_code] = temp;
                        return;
                    }
                    else{
                        temp.next = curr.next;
                        prev.next = temp;
                        return;
                    }
                }

                prev = curr;
                curr = curr.next;
            }
            prev.next = temp;
        }


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public V get(K key) {
        int hash_code = hash_gen(key);

        if(arr_ent[hash_code] == null){
            return null;
        }
        else{
            Entry<K, V> temp = arr_ent[hash_code];

            while( temp != null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    public int hash_gen(K key){
        return Math.abs(key.hashCode())%size;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public boolean remove(K key) {

        int hash_code = hash_gen(key);

        if(arr_ent[hash_code] == null){
            return false;
        }

        else{
            Entry<K, V> prev = null;
            Entry<K, V> curr = arr_ent[hash_code];

            while(curr != null){
                if(curr.key.equals(key)){
                    if(prev == null){
                        arr_ent[hash_code] = arr_ent[hash_code].next;
                        return true;
                    }
                    else{
                        prev.next = curr.next;
                        return true;
                    }
                }
                prev = curr;
                curr = curr.next;
            }

            return false;
        }
    }

    public void display(){
        for(int i=0; i<size; i++){
            if(arr_ent[i] != null){
                Entry<K, V> entry = arr_ent[i];

                while(entry != null){
                    System.out.println(entry.key+":"+entry.value);
                    entry=entry.next;
                }
            }
        }
    }
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
                + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
                + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

    }
}