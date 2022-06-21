class MyHashSet {
    private List<List<Integer>> keyList;
    private int arraySize = 809; //choose a prime number to avoid collisions
    private int maxValue = 1000000;
    
    public MyHashSet() {
        keyList = new ArrayList<>(arraySize);
        for(int i =0; i<arraySize;i++)
        {
            keyList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key%arraySize;
        List<Integer> bucket = keyList.get(index);
        if(bucket==null)
        {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            keyList.set(index, list);
        }
        else
        {
            if(!bucket.contains(key))
                bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key%arraySize;
        List<Integer> bucket = keyList.get(index);
        if(bucket!=null)
        {
            bucket.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key%arraySize;
        List<Integer> bucket = keyList.get(index);
        return bucket!=null&&bucket.contains(key);
    }
}
