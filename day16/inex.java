


class Solution {
    static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] traversed;
    Queue<int[]> que;
    private int solve(int[][] grid, int ele){
        int n = grid.length, m = grid[0].length, count = 0;
        if(ele <= grid[0][0]) return 0;
        while(!que.isEmpty()){
            int coor[] = que.peek();
            if(ele <= grid[coor[1]][coor[2]]) break;
            que.poll();
            count ++;
            for(int[] dirs: direction){
                int x = coor[1] + dirs[0];
                int y = coor[2] + dirs[1];
                if(x < 0 || y < 0 || x == n || y == m || 
                traversed[x][y]) continue;
                que.offer(new int[]{grid[x][y], x, y});
                traversed[x][y] = true;
            }
        }
        return count;
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] res = new int[queries.length];
        int[][] pairs = new int[queries.length][2];
        traversed = new boolean[grid.length][grid[0].length];
        que = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        que.offer(new int[]{grid[0][0], 0, 0});
        traversed[0][0] = true;
        for(int i = 0; i < pairs.length; i++){
            pairs[i][0] = queries[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < pairs.length; i++){
            res[pairs[i][1]] = solve(grid, pairs[i][0]) + (i > 0 ? res[pairs[i - 1][1]]: 0);
        }
        return res;
    }
}