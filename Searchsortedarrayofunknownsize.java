// tc - O(logN)
//sc - O(1)
// ran in leetcode -yes
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target){
            return 0;
        }

        int start = 0, end = 1;

        while(reader.get(end) < target){
            start = end;
            end  = end * 2;
        }

        int mididx, midEle;

        while(start <= end){
            mididx = (start + end) / 2 ;
            midEle = reader.get(mididx);

            if (midEle == target) return mididx;
            if (midEle > target){
                end = mididx -1 ;
            }else {
                start = mididx +1;
            }
        }
        return -1;
    }
}
