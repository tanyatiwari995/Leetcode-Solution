class Solution {
    public int subsetXORSum(int[] nums) {
         
 int n=nums.length;
 int ogans=0;
 for(int i=0;i<(1<<n);i++){
  int sum=0;
  for(int j=0;j<n;j++){
int bit=i&(1<<j);
if (bit!=0){
 sum=sum^nums[j];
}    
}
  ogans+=sum;
 }
return ogans;
    }
}