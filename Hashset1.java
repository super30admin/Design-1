// Time Complexity :add: O(1) 
//                  remove: O(1) 
//                  contains: O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//we are using hashset to store bucket ,bucketitems and storage to set T or F
//then we check and get the bucket =key%bucket and bucket items=key/bucket
//and then carry the operation of add ,remove,contain
  import java.util.Scanner;

class MyHashSet {
    int bucket ;
    int bucketitems;
    boolean[][] storage;
        public MyHashSet() {
            bucket=1000;
            bucketitems=1000;
            storage=new boolean[bucket][];
        }
        private int getbucket(int key){
            return key%bucket;
        }
         private int getbucketitems(int key){
            return key/bucket;
        }
        public void add(int key) {
            int bucket=getbucket(key);
            int bucketitem=getbucketitems(key);
            if(storage[bucket]==null){
                if(bucket==0){
                    storage[bucket]=new boolean[bucketitems+1];
                }
                else{
                    storage[bucket]=new boolean[bucketitems];
                }
            }
            storage[bucket][bucketitem]=true;
        }
        
        public void remove(int key) {
            int bucket=getbucket(key);
            int bucketitem=getbucketitems(key);
            if(storage[bucket]==null){
                return ;
            }
            storage[bucket][bucketitem]=false;
        }
        
        public boolean contains(int key) {
            int bucket=getbucket(key);
            int bucketitem=getbucketitems(key);
            if(storage[bucket]==null){
                return false;
            }
            return storage[bucket][bucketitem];
        }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add ");
            System.out.println("2. Remove ");
            System.out.println("3. Check");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    int elementToAdd = scanner.nextInt();
                    myHashSet.add(elementToAdd);
                    break;
                case 2:
                    System.out.print("Enter the element to remove: ");
                    int elementToRemove = scanner.nextInt();
                    myHashSet.remove(elementToRemove);
                    break;
                case 3:
                    System.out.print("Enter the element to check: ");
                    int elementToCheck = scanner.nextInt();
                    boolean contains = myHashSet.contains(elementToCheck);
                    System.out.println("Contains " + elementToCheck + ": " + contains);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
