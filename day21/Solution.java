
class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0,maxDiff=0,maxVal=0;
        for(int n:nums){
            ans=Math.max(ans,maxDiff*n);
            maxDiff=Math.max(maxDiff,maxVal-n);
            maxVal=Math.max(maxVal,n);
        }
        return ans;
    }
}
