class Solution {
    public static boolean kahnAlgorithm(ArrayList<ArrayList<Integer>> adj, int numCourses, int[] indegree, int[] arr) {
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                Q.offer(i);
            }
        }
        int i = 0, count = 0;
        while(!Q.isEmpty()) {
            int temp = Q.poll();
            for(int it: adj.get(temp)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    Q.offer(it);
                }
            }
            arr[i] = temp;
            i++;
            count++;
        }
        if(count != numCourses) return false;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = prerequisites.length;
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        int[] arr = new int[numCourses];
        if(kahnAlgorithm(adj, numCourses, indegree, arr)) {
            return arr;
        }
        else {
            int[] ans = new int[0];
            return ans;
        }
    }
}