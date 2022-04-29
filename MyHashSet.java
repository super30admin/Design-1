import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// space complexity depends on the number of buckets 
// o(n) -time 
// O(n) - space
public class MyHashSet {

	List<List<Integer>> bucketList;
	private final Integer MAX_VALUE=1000000;
	private final int ARRAY_SIZE=100;
	
	public MyHashSet() {
		bucketList= new ArrayList<>(ARRAY_SIZE);
		for(int i =0; i<ARRAY_SIZE;i++) {
			bucketList.add(null);
		}
	}
	
	public void add(int key) {
		int index = key%ARRAY_SIZE;
		List<Integer> currentBucketIndexList = bucketList.get(index);
		if(currentBucketIndexList==null) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(key);
			bucketList.set(index, list);
		}else {
			if(!currentBucketIndexList.contains(key)) {
				currentBucketIndexList.add(key);
			}
		}
	}
	public void remove(int key) {
		
		int index = key%ARRAY_SIZE;
		List<Integer> currentBucketIndexList = bucketList.get(index);
		if(currentBucketIndexList==null) {
			currentBucketIndexList.remove(Integer.valueOf(key));
		}

	}
	// o(1)
	public boolean contains(int key) {
		
		int index = key%ARRAY_SIZE;
		List<Integer> currentBucketIndexList = bucketList.get(index);
		return currentBucketIndexList!=null && currentBucketIndexList.contains(key);
	}
	
	
	public static void main(String[] args) {
		
		MyHashSet myHashSet = new MyHashSet();  
		myHashSet.add(11);
		myHashSet.remove(11);
		myHashSet.add(100);
		myHashSet.add(1267);
		myHashSet.remove(1000);
        boolean val1 = myHashSet.contains(11);
        boolean val2 = myHashSet.contains(100);
        System.out.println(val1);
        System.out.println(val2);
	}
}
