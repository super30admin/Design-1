// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class MyHashSet{

        private boolean[] set;

        public MyHashSet(){

            set = new boolean[1000001];
        }
        
        public void add(int key) {
            set[key] = true;
        }

        public void remove(int key) {
            set[key] = false;
        }

        public boolean contains(int key){
            return set[key];
        }
    
    public static void main(String[] args) {
    
    int key = 3;
    MyHashSet obj = new MyHashSet();
    obj.add(key);
    obj.remove(key);
    boolean param_3 = obj.contains(key);
    System.out.println(param_3);
    }
}