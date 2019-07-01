public class HashMap {
	boolean keyArray[] = new boolean[1000001];
	int valueArray[] = new int[1000001];
	
	
	public void put(int key,int value) {
		keyArray[key]= true;
		valueArray[key]=value;
	}

	public int get(int key) {
		if(keyArray[key]==true) {
			return valueArray[key];
		}
		return -1;
			
	}
	
	public void remove(int key) {
		keyArray[key]=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      HashMap obj = new HashMap();
      obj.put(1, 20);
      System.out.println(obj.get(1));
      obj.remove(1);
      System.out.println(obj.get(1));
	}

}