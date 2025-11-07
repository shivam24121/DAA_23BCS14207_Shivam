class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] dp=new Boolean[arr.length+1][sum+1];
        return solve(arr,0,sum,dp);
    }
    static Boolean solve(int[] arr,int st,int sum,Boolean[][]dp){
        if(sum==0)return true;
        if(st==arr.length)return false;
        
        if(dp[st][sum]!=null)return dp[st][sum];
        boolean skip=solve(arr,st+1,sum,dp);
        boolean pick=false;
        if(arr[st]<=sum){
            pick=solve(arr,st+1,sum-arr[st],dp);
        }
        return dp[st][sum]=skip||pick;
    }
}
