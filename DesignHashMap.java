public class DesignHashMap{
    Pair[] HashMap = new Pair[1000];
    class Pair{
        private int key;
        private int value;
        private Pair next;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Pair find(Pair bucket, int key){
        Pair prev = null;
        Pair curr = bucket;
        while(curr != null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value){
        int hash = hashCode(key);
        if(HashMap[hash] == null){
            HashMap[hash] = new Pair(-1,-1);
        }
        Pair pair = find(HashMap[hash],key);
        if(pair.next != null){
            pair.next.value = value;
        }
        else{
            pair.next = new Pair(key,value);
        }
    }

    public int get(int key){
        int hash = hashCode(key);
        if(HashMap[hash] == null){
            return -1;
        }
        Pair pair = find(HashMap[hash], key);
        if(pair.next == null)
            return -1;
        return pair.next.value;
    }

    public void remove(int key){
        int hash = hashCode(key);
        Pair pair = find(HashMap[hash], key);
        if(pair != null){
            pair.next = pair.next.next;
        }
    }

    public int hashCode(int key){
        return key%HashMap.length;
    }

    public static void main(String args[]){
        DesignHashMap map = new DesignHashMap();
        map.put(3,4);
        System.out.println("Get 3 " + map.get(3));
        map.put(3,9);
        System.out.println("Get 3 " + map.get(3));
        map.remove(3);
        System.out.println("Get 3 " + map.get(3));

    }
}