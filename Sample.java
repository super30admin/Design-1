// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Few Silly mistakes


// Your code here along with comments explaining your approach

class MinStack {
    int min=Integer.MAX_VALUE;
    int top=-1;
    ArrayList<Integer> stack;
    static Stack<Integer> minStack;
    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        top++;
        if(min>=val){
            min=val;
            minStack.push(val);
        }
        stack.add(val);
    }

    public void pop() {
        //System.out.println(stack.get(top)+" result "+minStack.peek());
        if(Objects.equals(stack.get(top), minStack.peek())){
            //System.out.println("poped");
            minStack.pop();
            if(minStack.isEmpty()){
                min=Integer.MAX_VALUE;
            }else
                min=minStack.peek();

        }

        stack.remove(top);
        top--;
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return minStack.peek();
    }

}
//Implement hashmap without using built in hash table libraries
//LeetCode tested


class MyHashMap {
    LinkedList<Element>[] map;
    public static int SIZE = 769;
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % SIZE;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Element>();
            map[bucket].add(new Element(key,value));
        }else{
            for (Element element:map[bucket]) {
                if(element.key == key){
                    element.value = value;
                    return;
                }
            }
            map[bucket].add(new Element(key,value));
        }
    }

    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Element> currentBucket = map[bucket];
        if(currentBucket == null) return -1;
        for (Element element:currentBucket) {
            if(element.key == key) return element.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        if(map[bucket] == null) return;
        else{
            Element removedElement = null;
            for (Element element:map[bucket]) {
                if(element.key == key)
                    removedElement = element;
            }
            if(removedElement != null){
                map[bucket].remove(removedElement);
            }
        }
    }
}

class Element{
    public int key;
    public int value;

    public Element(int key,int value){
        this.key = key;
        this.value = value;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
