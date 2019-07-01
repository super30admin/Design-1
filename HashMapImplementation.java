 class HashMap{
	
	 KeyValue[] map;
	HashMap(){
		map = new KeyValue[1000000];
	}
	
	void put(int key, int value){
		    System.out.println("\n ");
			System.out.println(" putting value:="+value );
			System.out.println(" \t at key :="+key ); 
			map[key]= new KeyValue(key,value);
	}
	

	
	int get(int key) {
		
		if (map[key]!=null) {
			System.out.println("Get value at Key ="+key);
			System.out.println(" value is  ="+map[key].value);
			return map[key].value;
		}else {
			return -1;
		}
	}
	
	void remove (int key) {	
	System.out.println(" removed value from map at key="+key ); 
	map[key]= null;
	}
}
 class KeyValue{
	    int key;
		int value;
		KeyValue (int k, int v){
			this.key = k;
			this.value =v;
		}
	}

 
//Driver code 
class HashMapImplementation  { 
  public static void main(String args[]) 
  { 
	  HashMap map=  new HashMap();
      map.put(1, 10); 
      map.put(2, 20); 
      map.put(3, 30); 
      map.get(1);
      map.remove(1);
  
  } 
}
