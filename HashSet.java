
// Your code here along with comments explaining your approach
// Used List<List<Integer>> to simulate array (index) and corresponding linkedlist at each index
// to store the values
class MyHashSet {

    int size = 100;
    List<List<Integer>> list;
    public MyHashSet() {
        list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(null);
        }
    }
 // o(1)
    public void add(int key) {
        int index = key%size;
        List<Integer> temp = list.get(index);
        if(temp==null){
            List<Integer> link = new LinkedList<>();
            link.add(key);
            list.set(index,link);
        }
        else{
            if(!temp.contains(key)){
                temp.add(key);
                list.set(index,temp);
            }
        }
    }
//o(n)
    public void remove(int key) {
        int index = key%size;
        List<Integer> temp = list.get(index);
        if(temp!=null){
            temp.remove(Integer.valueOf(key));
        }

    }
//o(n)
    public boolean contains(int key) {
        int index = key%size;
        List<Integer> temp = list.get(index);
        if(temp!=null){
            if(temp.contains(Integer.valueOf(key))){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}



