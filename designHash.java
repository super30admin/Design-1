class node
{
    int d,v;
    node next;
    node(int d,int v)
    {
        this.d=d;
        this.v=v;
        this.next=null;
    }
}
class MyHashMap {

    node head;
    public MyHashMap() {
         head=null;
    }
    
    public void put(int key, int value) {
        if(head==null)
        {
            node ptr=new node(key,value);
            head=ptr;
            return;
        }
        node ptr=head;
        while(ptr!=null)
        {
            if(ptr.d==key)
            {
                ptr.v=value;
                return;
            }
            ptr=ptr.next;
        }
        ptr=new node(key,value);
        ptr.next=head;
        head=ptr;
    }
    
    public int get(int key) {
        if(head==null)
        {
            return -1;
        }
        node ptr=head;
        while(ptr!=null)
        {
            if(ptr.d==key)
            {
                return ptr.v;
            }
            ptr=ptr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        if(head==null)
        {
            return;
        }
        if(head.d==key)
        {
            head=head.next;
            return;
        }
        node ptr=head;
        node temp=head.next;
        while(temp!=null)
        {
            if(temp.d==key)
            {
                ptr.next=temp.next;
                return;
            }
            ptr=ptr.next;
            temp=temp.next;
        }
    }
}