// Time Complexity : O(N) where n is the no.of keys
// Space Complexity : O(N) where n is the no.of keys
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach

// created a linkedlist
// added values
// checked if contains value-> if present remove
// return boolean using contiains method in linkedlist

class MyHashSet {

    List<String> ans;
    public MyHashSet() {
        ans=new LinkedList<>();
    }

    public void add(int key) {
        ans.add(key+"");
    }

    public void remove(int key) {
        while(contains(key)) {
            ans.remove(key+"");
        }
    }

    public boolean contains(int key) {
        return ans.contains(key+"");
    }
}
