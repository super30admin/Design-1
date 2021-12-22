// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : want clarifictaion on space complexity of O(1)
//

// Your code here along with comments explaining your approach

Class Design1 {

// Create 2 stack one to push all the elements and other for maintaining the min value

Stack<Integer> st1 = new Stack<>();
Stack<Integer> st2 = new Stack<>();

public void push(int x) {
    st1.push(x);
    if (st2.isEmpty()){
       st2.push(x);
     } else if (st2.peek() >= x){

      st2.push(x);

 }
}

public void pop(){
 int popElement = st1.pop();
 if (popElement == st2.peek()){
 st2.pop();
  }
}

public int top() {
 return st1.peek();
}

public int getMin(){
return st2.peek();
}





//Time Complexity: O(N/K) N is the vales K is predefined buckets
//Space complexity O(K+M) K is the number of buckets and M is the number of unique vales that has been inserted in hashset
//We are using List as for any insertion and deletion there is O(1) time and like that we can have more buckets to avoid collisions in hashset

  Class Design2 {

    List<Integer> l;
    public MyHashSet() {
        l=new ArrayList();
    }
    
    public void add(int key) {
        if(l.contains(key)==false)
            l.add(key);
    }
    
    public void remove(int key) {
        if(l.contains(key))
            l.remove(l.indexOf(key));
    }
    
    public boolean contains(int key) {
        return l.contains(key);
           
    }
}


