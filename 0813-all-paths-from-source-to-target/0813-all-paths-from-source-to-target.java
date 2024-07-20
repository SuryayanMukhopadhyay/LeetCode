class Solution {
    public static void dfs(int[][] graph, int source, List<List<Integer>> list, int n, List<Integer> tempList) {
        if (source == n - 1) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i : graph[source]) {
            tempList.add(i);
            dfs(graph, i, list, n, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        dfs(graph, 0, list, n, tempList);
        return list;
    }
}