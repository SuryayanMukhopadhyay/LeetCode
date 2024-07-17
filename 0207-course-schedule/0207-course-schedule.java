class Solution {
    public static boolean dfs(int numCourses, int[][] prerequisites, int source, boolean[] visited, boolean[] path, int n) {
        visited[source] = true;
        path[source] = true;
        for (int i = 0; i < n; i++) {
            if (prerequisites[i][0] == source) {
                if (!visited[prerequisites[i][1]]) {
                    if (dfs(numCourses, prerequisites, prerequisites[i][1], visited, path, n))
                        return true;
                } else if (path[prerequisites[i][1]])
                    return true;
            }
        }
        path[source] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        int n = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if(dfs(numCourses, prerequisites, i, visited, path, n)) return false;
            }
        }
        return true;
    }
}