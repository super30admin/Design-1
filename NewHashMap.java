//keys should be positive
public class NewHashMap {
    ListNode[] nodes ;

    public class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int data,int val){
            this.key = data;
            this.val = val;
            this.next = null;
        }
    }
    public NewHashMap(){
        nodes = new ListNode[100000];
    }

    public void put(int key,int val){
        int index = index(key);
        if(nodes[index] == null)
            nodes[index] = new ListNode(-1,-1);
        ListNode prev = find(nodes[index],key);
        if(prev.next==null)
            prev.next = new ListNode(key,val);
        else
            prev.next.val = val;


    }
    public void remove(int key){
        if(nodes[index(key)]==null)
            return;
        ListNode prev = find(nodes[index(key)],key);
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
    public int get(int key){
        int index = index(key);
        if(nodes[index] == null)
            return -1;
        else{
            ListNode prev = find(nodes[index],key);
            if(prev.next==null)
                return -1;
            return prev.next.val;
        }
    }

    public int index(int key){
        //int x = Integer.hashCode(key);
        return Integer.hashCode(key)%nodes.length;

    }
    public ListNode find(ListNode bucket,int key){
        ListNode dummy = bucket,prev = null;
        while (dummy!=null && dummy.key!=key){
            prev = dummy;
            dummy = dummy.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        NewHashMap hm = new NewHashMap();
        hm.put(3,33);
        System.out.println(hm.get(3));
        hm.remove(3);
        System.out.println(hm.get(3));

    }
}
