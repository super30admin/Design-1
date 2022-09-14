import java.util.*;
public class Problem1 {
    
// Time Complexity : constant
// Space Complexity : O(n) n-> entries in the hashSet
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

    List<Integer> []  set;
    public Problem1() {

        this.set=new ArrayList[10000];


    }
    
    public void add(int key) {
     
        //hash 
        
        int hash=key%this.set.length;
        if(this.set[hash]==null){
            this.set[hash]=new ArrayList<>();
        }
        
        for( int i=0;i<this.set[hash].size();i++){
            
            if(this.set[hash].get(i)==key){return;}
        }
        
        
        this.set[hash].add(key);
        
    }
    
    public void remove(int key) {
        
        int hash=key%this.set.length;
        if(this.set[hash]==null){
            return;
        }
        
        for( int i=0;i<this.set[hash].size();i++){
            
            if(this.set[hash].get(i)==key){
                this.set[hash].remove(i);
                return;}
        }
        
        
        
    }
    
    public boolean contains(int key) {
        
        int hash=key%this.set.length;
        if(this.set[hash]==null){
           return false;
        }
        
        for( int i=0;i<this.set[hash].size();i++){
            
            if(this.set[hash].get(i)==key){return true;}
        }
        
        
return false;
    }
        
        



}



