class Solution {
    public int getMax(int[] groupSizes, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, groupSizes[i]);
        }
        return max;
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> init = new ArrayList<>();
        int n = groupSizes.length;
        int max = getMax(groupSizes, n);
        for(int i = 0; i <= max; i++) {
            init.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            init.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> list = new ArrayList<>();
        int j = -1;
        for(int i = max; i >= 0; i--) {
            if(init.get(i).size() == 0) {
                continue;
            }
            j++;
            list.add(new ArrayList<>());
            int count = 0;
            while(init.get(i).size() != 0) {
                if(count == i) {
                    j++;
                    list.add(new ArrayList<>());
                    count = 0;
                }
                list.get(j).add(init.get(i).get(init.get(i).size() - 1));
                init.get(i).remove(init.get(i).size() - 1);
                count++;
            }
        }
        return list;
    }
}