class MyHashSet{
	
int buckets;
int buketitem;
boolean[][] storage;
public MyHashSet() {
	super();
	this.buckets = 1000;
	this.buketitem = 1001;
	this.storage = new boolean[this.buckets][];
}
private int getBucket(int key) {
    return key % buckets;
}

private int getBucketItem(int key) {
    return key / buckets;
}

public void add(int key) {
	int bucket =getBucket(key);
	int bucketItem=getBucketItem(key);
	if (storage[bucket] == null) {
        storage[bucket] = new boolean[bucketItem];
    }
	storage[bucket][bucketItem] = true; 
       
}

public void remove(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    if (storage[bucket] != null) {
        storage[bucket][bucketItem] = false;
    }
}

public boolean contains(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    return storage[bucket] != null && storage[bucket][bucketItem];
}
	
	
	
	
}
