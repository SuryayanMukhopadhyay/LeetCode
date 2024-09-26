class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        int[] prev = new int[2];
        prev[0] = intervals[0][0];
        prev[1] = intervals[0][1];
        while(i < n) {
            if(prev[0] < intervals[i][0] && prev[1] > intervals[i][1]) {
                i++;
            }
            else if(prev[1] >= intervals[i][0]) {
                if(prev[1] <= intervals[i][1]) {
                    prev[1] = intervals[i][1];
                }
                i++;
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(prev[0]);
                temp.add(prev[1]);
                list.add(temp);
                prev[0] = intervals[i][0];
                prev[1] = intervals[i][1];
            }
        }
        List<Integer> last = new ArrayList<>();
        last.add(prev[0]);
        last.add(prev[1]);
        list.add(last);
        int[][] res = new int[list.size()][2];
        i = 0;
        for(List<Integer> temp : list) {
            res[i][0] = temp.get(0);
            res[i][1] = temp.get(1);
            i++;
        }
        return res;
    }
}