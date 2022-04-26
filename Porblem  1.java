//time complexity: o(1)
//space complexity: o(n)

public class Problem 1{
class MyHashMap{
    LinkedList<Entry>[] map;//array of linked lists that contains entry
    public int SIZE = 1000; // since value<10^6 took square root as size of primary array
    public MyHashMap(){
        map = new LinkedList[SIZE]; //constructor
    }

    public void put(int key, int value){
        int bucket = key % SIZE;
        if(map[bucket] == null) { //check if null
            map[bucket] = new LinkedList<Entry>(); //if null, create a new linked list and add the entry into the map 
            map[bucket].add(new Entry(key, value)); 
        }
        else {
            for(Entry entry : map[bucket]){ //iterate to check if key is already present
                if(entry.key == key){
                    entry.val = value; //if present update the value
                    return;
                }
            }
            map[bucket].add(new Entry(key, value)); //else if value no found, add the new key and value
        }
    }

    public int get(int key){
        int bucket = key % SIZE; //bucket is the array field and key%size taken as hash funtion to which field is selected
        LinkedList<Entry> entries = map[bucket];  //bucket is put into linked list
        if(entries == null) return -1;  //if there are no entries return -1
        for(Entry entry: entries){ //iteration 
            if(entry.key == key) return entry.val; //if key is found/matched return that value
        }
        return -1; //else return -1
    }

    public void remove(int key){
    	int bucket = key % SIZE;
			Entry toRemove = null;
			if(map[bucket] == null) return;//check if bucket is null
			else {
				for(Entry entry : map[bucket]){ //iterate and check if it is there
					if(entry.key == key) {
						toRemove = entry; 
					}
				}
				if(toRemove == null) return;
				map[bucket].remove(toRemove); //array built in remove to remove the element
			}
		}     
    }
}

class  Entry{
    public int key;
    public int val;

     public Entry(int key, int val){
         this.key = key;
         this.val = val;
     }
}


