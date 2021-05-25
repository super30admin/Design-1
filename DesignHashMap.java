// Time Complexity : O(1)
// Space Complexity : O(N) where N is the size of the initial array

class DesignHashMap{
  int[] array;

  public DesignHashMap(){
    array = new int[100000];
    Arrays.fill(array, -1);
  }

  public int get(int key){
    return array[key];
  }

  public void put(int key, int value){
    array[key] = value;
  }

  public void remove(int key){
    array[key] = -1;
  }
}
