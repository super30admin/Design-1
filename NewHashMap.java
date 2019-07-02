//keys should be positive
public class NewHashMap {
    boolean[] keyArr = new boolean[1000000];
    int[] valueArr = new int[100000];

    public void put(int key,int value){
        keyArr[key] = true;
        valueArr[key] = value;
    }

    //returns -1 if no key found
    public int get(int key){
        if(keyArr[key]){
            return valueArr[key];
        }
        return -1;
    }

    public void remove(int key){
        keyArr[key] = false;
    }

    public static void main(String[] args) {
        NewHashMap hm = new NewHashMap();
        hm.put(3,33);
        System.out.println(hm.get(3));
        hm.remove(3);
        System.out.println(hm.get(3));

    }
}
