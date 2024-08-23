class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        visited[0] = true;
        while(!Q.isEmpty()) {
            int node = Q.poll();
            for(int it : rooms.get(node)) {
                if(!visited[it]) {
                    Q.offer(it);
                    visited[it] = true;
                }
            }
        }
        for(boolean visit : visited) {
            if(!visit) return false;
        }
        return true;
    }
}