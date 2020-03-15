
public class MyHashSet {
	
	int bucket = 1000;
	int bucketItem = 1000;
	
	boolean[][] myHashSet;
	
	public MyHashSet()
	{
		myHashSet = new boolean[bucket][];
	}
	
	private int hashBucket(int key){
		return key % bucket;
	}
	
	private int hashBucketItem(int key){
		return key % bucketItem;
	}
	
	public void add(int key){
		int index1 = hashBucket(key);
		int index2 = hashBucketItem(key);
		
		if (myHashSet[index1] == null){
			myHashSet[index1] = new boolean[bucketItem];
		}
		myHashSet[index1][index2] = true;
	}
	
	public boolean contains(int key){
		int index1 = hashBucket(key);
		int index2 = hashBucketItem(key);
		
		return myHashSet[index1] != null && myHashSet[index1][index2];
		
	}
	
	public void remove(int key){
		int index1 = hashBucket(key);
		int index2 = hashBucketItem(key);
		
		if (myHashSet[index1] != null){
			myHashSet[index1][index2] = false;
		}
	}

	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		
		myHashSet.add(1);
		myHashSet.add(2);
		
		System.out.println(myHashSet.contains(1));
		System.out.println(myHashSet.contains(3));
		
		myHashSet.add(2);
		System.out.println(myHashSet.contains(2));
	}

}
