// Time Complexity :o(n)
// Space Complexity :o(n)

//Design a HashSet without using any built-in hash table libraries.

class MyHashSet {
   
    LinkedList<Entry>[] map;
    int SIZE=769; //prime number to reduce chances of collision
    
    public MyHashSet() {
        map=new LinkedList[SIZE];
    }
    
    public void add(int key) {
        int bucket=key%SIZE;
        if(map[bucket]==null){
            map[bucket]=new LinkedList<Entry>();
            map[bucket].add(new Entry(key,key));
        }else{
            
            for (Entry entry: map[bucket]){
                
                if(entry.key==key)return;
            }
        }
        map[bucket].add(new Entry(key,key));
        
    }
    
    public void remove(int key) {
       int bucket = key % SIZE;
			Entry toRemove = null;
			if(map[bucket] == null) return;
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key) {
						toRemove = entry;
					}
				}
				if(toRemove == null) return;
				map[bucket].remove(toRemove);
			}
		}
    
    
    public boolean contains(int key) {
        int bucket=key%SIZE;
        LinkedList<Entry> entries=map[bucket];
        if (entries==null) return false;
        for (Entry entry:entries){
            if(entry.key==key) return true;
        }
        return false;
         }
   }

  class Entry{
        int key;
        int val;
        
        Entry(int key, int val){
            this.key=key;
            this.val=val;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

