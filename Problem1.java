class MyHashMap {

    private final int MAP_SIZE = 20;

    List<Integer[]>[] map = new List[MAP_SIZE];

    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        // get index to put
        int index = key % MAP_SIZE;
        List<Integer[]> list;
        if(map[index] == null){
            list = new LinkedList<>();
            list.add(new Integer[]{key, value});
            map[index] = list;
        } else {
            // check list contains key
            list = map[index];
            list.removeIf(it -> it[0] == key);
            list.add(new Integer[]{key, value});
        }
    }
    
    public int get(int key) {
        List<Integer[]> list = map[key % MAP_SIZE];
        if(list == null) return -1;
        Integer[] item = list.stream().filter(it -> it[0] == key).findFirst().orElse(null);
        return item == null ? -1 : item[1];
    }
    
    public void remove(int key) {
        List<Integer[]> list = map[key % MAP_SIZE];
        if(list == null) return;
        list.removeIf(it -> it[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
