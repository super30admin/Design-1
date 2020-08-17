import java.util.Scanner;

public class hashMap {
	
	static int k=0;
	int[] arr = new int[100000000];
	public void put(int key, int value) {
			arr[key]= value;
	}
	
	public int get(int key) {
		int val = arr[key];
		return val;
	}
	
	public void remove(int key) {		
		arr[key] = -1;
	}
	
	public static void main(String[] args) {
		hashMap Hashmap = new hashMap();
		Hashmap.put(2,10);
		Hashmap.put(19, 100);
		System.out.println("The value retrieved from the key 19: "+Hashmap.get(19));
//		System.out.println("Deleted value from the Hashmap for key 3: ");
		Hashmap.remove(3);
	}
}
