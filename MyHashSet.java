// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/*
 * Initially I choose to work with ArrayList and leverage `contains()` and `remove()`
 * So while removing key from arrayList is was removing without specifying index (trying to remove by value directly***)
 * I was facing Index out of bond Exception
*/


// Your code here along with comments explaining your approach
/*
 * I've used ArrayList and leveraged contians and remove method of the arraylist
 * tradeoFF is TimeComplexity and Space complexity is O(n) but I get to preserve the keys for future use
*/

class MyHashSet {

    private List<Integer> list;

    public MyHashSet() {
        
        list = new ArrayList<>((int) (Math.pow(10, 6) + 1));
    }
    
    public void add(int key) {

        if (!this.list.contains(key)) {
            this.list.add(key);
        }
    }
    
    public void remove(int key) {

        int index = this.list.indexOf(key);
        if (index != -1)
            this.list.remove(index);
        
    }
    
    public boolean contains(int key) {
        return this.list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */