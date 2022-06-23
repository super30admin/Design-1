//Time Complexity : add, contains, remove- O(1) constant time
//Space Complexity : O(n) i.e. O(n), n is size of HashSet. Here though size of n is taken as square root of(10^6)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : no

//Your code here along with comments explaining your approach

/*Step 1: I am designing HashSet using dynamic arrays. I first initialize the primary array with NULL. 
 * Step 2: If we will initialize array with given size i.e. 10^6 and has to store just 2 elements. Then it will be simply wastage of memory. Hence, we will initialize array with just 10^3 size.
 * Step 3: We will perform mod% operation to find the index to store key. for values greater than calculated size(10^3) and less than given size(10^6).
 Step 4: In order to avoid collisions, we will again use divide operator to find index to store key in secondary array. If primary index is NULL, then first we will create secondary array 
 for that index of primary array and then perform / operation to find index on secondary array.
 */



import java.util.Scanner;

public class DesignHashset {
	    static boolean[][] space;
	    static int buckets;
	    static int bucketItems;
	    
	    public static void DesignHashset() {  //initialization
	        buckets=1000;
	        bucketItems=1000;
	        space=new boolean[buckets][];  //initialized with NULL 
	    }
	    
	    public static int getbucket(int key)
	    {
	        return key % buckets;
	    }
	    
	    public static int getbucketItems(int key){
	        return key / buckets;
	    }
	    
	    public static void add(int key) {
	        int bucket = getbucket(key);
	        int bucketItem= getbucketItems(key);
	        
	        if(space[bucket] == null)   //if index is null means no secondary array has been initialized
	        {
	            if(bucket==0)
	            {
	                space[bucket] = new boolean[bucketItems+1];   //if primary index is 0, means 10^6/10^3 will give 0. After this when we will perform 10^6/10^3 to find index to store in secondary index. We will get 1000. But our index is till 999. Hence, we will add one more space just for 0th index
	            }
	            else{
	                space[bucket] = new boolean[bucketItems];  // if not 0th primary index but is NULL then initialize secondary array with 999 size.
	            }
	        }
	        space[bucket][bucketItem]= true;  //and make the index value on secondary array as true means key exists on this space[bucket][bucketItem] index
	    }
	    
	    public static void remove(int key) {
	        int bucket=getbucket(key);
	        int bucketItem= getbucketItems(key);
	        
	        if(space[bucket] == null)  // if index is null means no key is present to be removed
	        { 
	        	return;
	        }
	        space[bucket][bucketItem]= false; // otherwise, if you find the key just make that key value as false means it is removed
	        if(space[bucket][bucketItem]== false)
	        {
	        	System.out.println("The item is removed from HashSet");
	        }	        
	    }
	    
	    public static void contains(int key) {
	        int bucket=getbucket(key);
	        int bucketItem= getbucketItems(key);
	        
	        if(space[bucket] == null)    // if index is null means no key is present 
	        { 
	        	System.out.println("No the key is not present");
	        }
	        if(space[bucket][bucketItem]== true)   // if index is true means key is present 
	        {
	        	System.out.println("Yes the item is present");
	        }
	        else     //means on searching secondary index no key is found
	        {
	        	System.out.println("No the item is not present");
	        }
	    }
	    



public static void main(String[] args) {
	DesignHashset();

	Scanner inpObj = new Scanner(System.in); 
    do
	{
    	System.out.println("Enter the operation(add, contains, remove) and Q/q to exit \n");
    	String text = inpObj.nextLine(); 
    	if(text.equals("Q") || text.equals("q"))
    	{
    		break;
    	}
    	if(text.equals("add"))
    	{
    		System.out.println("Please enter the integer element you want to add into HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		add(num);
    	}
    	if(text.equals("contains"))
    	{
    		System.out.println("Please enter the integer element you want to check into HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		contains(num);
    	}
    	if(text.equals("remove"))
    	{
    		System.out.println("Please enter the integer element you want to remove from HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		remove(num);
    	}
    	
	}	while(true);
}

}
