class Solution {
    static class Pair{
        int node;
        int distance;
        Pair(int n,int d){
            this.node=n;
            this.distance=d;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        boolean[] visited=new boolean[V];
        
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currNode=curr.node;
            int currDist=curr.distance;
            
            
            if(currDist>dist[currNode])continue;
            if(visited[currNode])continue;
            visited[currNode]=true;
            
            for(Pair neigh:adj.get(currNode)){
                int nextNode=neigh.node;
                int nextDist=neigh.distance;
                
                if(dist[currNode]+nextDist<dist[nextNode]){
                    dist[nextNode]=dist[currNode]+nextDist;
                    pq.offer(new Pair(nextNode,dist[nextNode]));
                }
            }
        }
        return dist;
    }
}
