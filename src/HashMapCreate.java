// Operation:            put         get          remove      findPrev
// Time Complexity:      O(n)        O(n)          O(n)         O(n)
// Space Complexity:     O(n)        O(n)          O(n)         O(n)
// Yes, this code ran successfully
// No, I faced a problem implementing using nodes only. I used 2D array of nodes earlier.

package src;

public class HashMapCreate
{
    public static void main(String[] args)
    {
        MyHashMap obj = new MyHashMap();
        obj.put(1,100);
        System.out.println("Element value: " + obj.get(1));

        obj.put(2,200);
        System.out.println("Element value: " + obj.get(2));
        obj.put(3,300);

        System.out.println("Element value: " + obj.get(2));
        obj.put(6,600);
        System.out.println("Element value: " + obj.get(2));
        System.out.println("Element value: " + obj.get(3));
        System.out.println("Element value: " + obj.get(6));

        obj.remove(2);
        System.out.println("Element value: " + obj.get(2));

        obj.put(1,500);
        System.out.println("Element value: " + obj.get(1));

        obj.remove(1);
        System.out.println("Element value: " + obj.get(1));

    }
}


class MyHashMap {

    private static final int NUM = 10000 ;
    private Node[] arr ;

    class Node
    {
        int key ;
        int val ;
        Node next ;
        public Node(int key, int val)
        {
            this.key = key ;
            this.val = val;
            this.next = null ;
        }
    }

    public MyHashMap()
    {
        arr = new Node[NUM] ;
    }

    public int getHash(int key)
    {
        return key % NUM ;
    }

    public void put(int key, int value) {
        Node prev = findPrev(key) ;
        if(prev == null)
        {
            int index = getHash(key) ;
            arr[index] = new Node(-1, -1) ;
            prev = arr[index] ;
        }

        if(prev.next != null)
            prev.next.val = value ;
        else
            prev.next = new Node(key,value) ;
    }

    public int get(int key) {
        Node prev = findPrev(key) ;
        if(prev == null || prev.next == null)
            return -1 ;
        return prev.next.val;
    }

    public void remove(int key) {
        Node prev = findPrev(key) ;
        if(prev == null || prev.next == null)
            return ;
        prev.next = prev.next.next ;

    }

    private Node findPrev(int key)
    {
        int index = getHash(key) ;
        if(arr[index] == null)
            return null ;
        Node prev = arr[index] ;
        Node cur = prev.next ;

        while(cur!=null && cur.key != key)
        {
            prev = prev.next ;
            cur = cur.next ;
        }
        return prev ;
    }
}


// ****************************** Brute Force approach ******************************
//class MyHashMap {
//
//    private static int ARR_SIZE = 1000 ;
//    //private int arr[][] ;
//    private List<List<Node>> parentList ;
//    Node node ;
//
//    class Node
//    {
//        int key ;
//        int val ;
//        public Node(int key, int val)
//        {
//            this.key = key ;
//            this.val = val;
//        }
//    }
//
//    public MyHashMap() {
//        //arr = new int[2][MAX] ;
//        parentList = new ArrayList<>(ARR_SIZE) ;
//        for(int i = 0 ; i < ARR_SIZE ; i++)
//            parentList.add(null) ;
//    }
//
//    public void put(int key, int value) {
//        int index = key % ARR_SIZE ;
//        node = new Node(index, value) ;
//        List<Node> childList = parentList.get(index) ;
//        if(childList == null)
//        {
//            List<Node> list = new LinkedList<>() ;
//            list.add(node) ;
//            parentList.set(index,list) ;
//        }
//        else
//        {
//            if(childList.contains(node) && (node.key == index))
//                childList.add(node);
//        }
//    }
//
//    public int get(int key) {
//        int index = key % ARR_SIZE ;
//        List<Node> childList = parentList.get(index) ;
//
//        if(childList.contains(node) && (node.key == index))
//        {
//            return node.val ;
//        }
//        else
//            return -1 ;
//    }
//
//    public void remove(int key) {
//        int index = key % ARR_SIZE ;
//        List<Node> childList = parentList.get(index) ;
//
//        if(childList != null && (node.key == index))
//        {
//            childList.remove(node) ;
//        }
//    }
//}
