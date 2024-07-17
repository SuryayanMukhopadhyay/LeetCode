class Solution {
    public static void dfs(int[][] isConnected, boolean[] visited, int source, int V) {
        visited[source] = true;
        for (int i = 0; i < V; i++) {
            if (isConnected[source][i] == 1) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i, V);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i, V);
            }
        }
        return count;
    }
}