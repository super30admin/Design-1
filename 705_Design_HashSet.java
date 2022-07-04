import java.util.ArrayList;
import java.util.LinkedList;

class HashSet{
    public HashBucket[] H_array;
    private int keyrange;

    // Initialize data structure
    public HashSet(){
        this.keyrange = 1013;
        this.H_array = new HashBucket[this.keyrange];
        for(int i = 0; i<this.keyrange; ++i){
            this.H_array[i] = new HashBucket();
        }
    }

    protected int hashval(int key){
        return (key%this.keyrange);
    }

    public void add(int key){
        int HashArrayindex = this.hashval(key);
        this.H_array[HashArrayindex].insert(key);
    }

    public void remove(int key){
        int HashArrayindex = this.hashval(key);
        this.H_array[HashArrayindex].delete(key);
    }

    public boolean contains(int key){
        int HashArrayindex = this.hashval(key);
        return this.H_array[HashArrayindex].exists(key);
    }



}


class HashBucket{
    public ArrayList<Integer> hlist;
    public HashBucket(){
        hlist = new ArrayList<>();
    }
    public void insert(Integer key){
        int index = this.hlist.indexOf(key);
        this.hlist.add(key);

    }

    public void delete(Integer key){
        this.hlist.remove(key);
    }

    public boolean exists(Integer key){
        int index = this.hlist.indexOf(key);
        return (index != -1);
    }



}


class Design_HashSet{
    public static void main(String[] args){

        HashSet obj = new HashSet();
        obj.add(1);
        obj.add(2);
        obj.remove(1);


        boolean param_2 = obj.contains(2);
        boolean param_1 = obj.contains(1);
        System.out.println("param_1 : " + param_1);
        System.out.println("param_2 : " + param_2);

//        for(int i=0 ; i < obj.H_array.length ; i++){
//            for(int key : obj.H_array[i].hlist){
//                System.out.print(key+ "->");
//            }
//            System.out.println("");
//        }
    }
}