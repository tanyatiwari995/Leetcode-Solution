public class index {
    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            List<Integer>[] graph=new ArrayList[n];
            for(int i=0;i<n;i++){
                graph[i]=new ArrayList<>();
            }
            for(int[] edge:edges){
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            int count=0;
            Set<Integer> visited=new HashSet<>();
            for(int i=0;i<n;i++){
                if(visited.contains(i)){
                    continue;
                }
                int[] cur=new int[2];
                dfs(i,graph,visited,cur);
                if(cur[0]*(cur[0]-1)==cur[1]){
                    count++;
                }
            }
            return count;
        }
        public void dfs(int i,List<Integer>[] graph,Set<Integer> visited,int[] cur){
            visited.add(i);
            cur[0]++;
            cur[1]+=graph[i].size();
            for(int temp:graph[i]){
                if(!visited.contains(temp)){
                    dfs(temp,graph,visited,cur);
                }
            }
        }
    } 
}
