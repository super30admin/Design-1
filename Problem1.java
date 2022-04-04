class myBucket {
    boolean [][] bucketList;
    int buckets;
    int bucketItems;

    public myBucket(){
        buckets = 1000;
        bucketItems = 1000;
        bucketList = new boolean[buckets][];
    }

    public void add(int key){
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(bucketList[bucket] == null){
            if(bucket == 0){
                bucketList[bucket] = new boolean[bucketItems+1];
            }
            else{
                bucketList[bucket] = new boolean[bucketItems];
            }
        }
        bucketList[bucket][bucketItem] = true;
    }

    public void remove(int key){
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(bucketList[bucket]== null){
            return;
        }
        bucketList[bucket][bucketItem] = false;
    }

    public boolean contains(int key){
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(bucketList[bucket]== null){
            return false;
        }
        return bucketList[bucket][bucketItem];
    }

    public static void main(String[] args) {
        myBucket mb = new myBucket();
        mb.add(1);
        mb.add(2);
        System.out.println(mb.contains(1));
        System.out.println(mb.contains(3));
        mb.add(2);
        System.out.println(mb.contains(2));
    }
}
