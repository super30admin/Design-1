//time complexity: O(N/K) where N is all the values and K is the array_size
//space complexity: O(K+M) where K is array size and M is the values added in the sublist
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    int array_size=1000;
       List<List<Integer>> mainlist;
       int hashing;
       public MyHashSet() {
           mainlist= new ArrayList<>(array_size);
           for(int i=0;i<array_size;i++)
           {
               mainlist.add(null);
           }
       }
       
       public void add(int key) {
           int hashing= key%array_size;
           List<Integer> sublist= mainlist.get(hashing);
           if (sublist==null)
           {
               List<Integer> list= new LinkedList<>();
               list.add(key);
               mainlist.set(hashing, list);
           }
           else
           {
               if(!sublist.contains(key))
               {
                   sublist.add(key);
               }
           }
           
       }
       
       public void remove(int key) {
           hashing= key%array_size;
           List<Integer> sublist = mainlist.get(hashing);
           if(sublist!=null)
           {
               sublist.remove(Integer.valueOf(key));
           }
           
       }
       
       public boolean contains(int key) {
           hashing =key%array_size;
           List<Integer> sublist = mainlist.get(hashing);
           if(sublist!=null)
           {
               return sublist.contains(key);
           }
           else
               return false;
           
       }
       public static void main(String args[]) 
    { 
        MyHashSet mhs = new MyHashSet();  
        mhs.add(11);
        mhs.remove(11);
        mhs.add(100);
        mhs.add(1267);
        mhs.remove(1000);
        boolean val1 = mhs.contains(11);
        boolean val2 = mhs.contains(100);
        System.out.println(val1);
        System.out.println(val2);
    } 
   }
   
  