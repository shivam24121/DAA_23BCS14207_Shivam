class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] res=new int[n-k+1];
        for(int i=0;i<n;i++){
            heap.offer(new int[]{nums[i],i});
            while(heap.peek()[1]<=i-k){
                heap.poll();
            }
            if(i>=k-1){
                res[i-k+1]=heap.peek()[0];
            }
        }
        return res;
    }
}
