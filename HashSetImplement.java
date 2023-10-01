import javax.lang.model.element.Element;

public class HashSetImplement {
    //[][][] primary array
    //secondary array which is a booelan
    //i have first function to calculate the hash which is element%length
    //second function is has function which is element/length

    //edge cases : 1000000 % 1000 = 0
    //1000000/1000 = 1000
    // i will create secondary array of size 999 (because 0->999) (1000 length)
    // thus, the first secondary array i create will be of size 1001 (0-> 1000)

    //major functions that will be performed
    //insertion, deletion and peek

    // i am assuming that i will be getting elements in the range 1 to 1000000

    private boolean [][] storage;
    private int buckets;

    private int hashFirst(int element){
        return element % 1000;
    }

    private int hashSecond (int element){
        return element/1000;
    }

    //initializate the storage
    public HashSetImplement()
    {
        this.buckets = 1000;
        this.storage = new boolean[buckets][];
    }

    public void add(int element){ //time Complexity : 0(1)

        int index1 = hashFirst(element);
        int index2 = hashSecond(element);

        if(index1==0)
        {
            this.storage[0] = new boolean[1001];
            this.storage[index1][index2] = true;
        
        }
        else{
            this.storage[index1]= new boolean[1000];
            this.storage[index1][index2] = true;
        }

        System.out.println("Element " + element + " added to storage @ index " + index1 + index2 );
    }

    public void remove(int element) //time complexity O(1)
    {
        int index1 = hashFirst(element);
        int index2 = hashSecond(element);

        if(this.storage[index1][index2] == false)
        {
            System.out.println("Element does not exist");
        }
        
        this.storage[index1][index2] = true;
        System.out.println("Element removed");
    }

    public boolean get(int element) //time Complexity O(1)
    {
        int index1 = hashFirst(element);
        int index2 = hashSecond(element);

        return this.storage[index1][index2];
    }


    public static void main(String[] args)
    {
        System.out.println("Insert elements");
        HashSetImplement myhashSetImplement = new HashSetImplement();

        myhashSetImplement.add(0);
        myhashSetImplement.add(1);
        myhashSetImplement.add(1254);
        myhashSetImplement.add(1000000);

        myhashSetImplement.remove(1);

       System.out.println("Find 1254 : " +  myhashSetImplement.get(1254));

    }
}
