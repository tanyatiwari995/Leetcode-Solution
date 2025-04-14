package day32;


class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if(nums[i]<k){
                return -1;
            }
            if (nums[i] > k) {
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    count++;
                }
            }
        }
        
        return count;
    }
}