
class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxPoints=0,leftMax=0,diffMax=0;
        for(int k=0;k<nums.length;k++){
            maxPoints=Math.max(maxPoints,diffMax*nums[k]);
            diffMax=Math.max(diffMax,leftMax-nums[k]);
            leftMax=Math.max(leftMax,nums[k]);
        }
        return maxPoints;
    }
}