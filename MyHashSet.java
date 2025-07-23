class MyHashSet {
    final int len = 1000;
    List<List<Integer>> arr ;
    public MyHashSet() {

        arr = new ArrayList<>(len);
        for( int i = 0; i<len; i++ ){
            arr.add( new ArrayList<>() );
        }
    }

    public void add(int key) {
        // if key exist then don't add
        // else add at index => key % len , value => key in internal arrayList
        // go to index index => key % len , iterate arrayList find key else add

        //int index = key % len;
        int i = 0;
        while( i < arr.get(key % len).size() ){
            if( arr.get(key % len).get(i) == key ){
                return;
            }
            i++;
        }
        arr.get(key % len).add(key);

    }

    public void remove(int key) {

        int i = 0;

        while( i < arr.get(key % len).size() ){
            if( arr.get(key % len).get(i) == key ){
                // swap with last
                // remove last

                int last = arr.get(key % len).size() - 1;

                Collections.swap( arr.get(key % len) , last , i );
                arr.get(key % len).remove(last);
            }
            i++;
        }
        return;
    }

    public boolean contains(int key) {

        int i = 0;

        while( i < arr.get(key % len).size() ){

            if( arr.get(key % len).get(i) == key ){
                return true;

            }
            i++;
        }
        return false;

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */