class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                ArrayList<Integer> list = map.get(arr[i]);
                list.add(i);
                map.remove(arr[i]);
                map.put(arr[i], list);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        int[] temp = arr;
        Arrays.sort(temp);
        int[] res = new int[n];
        int rank = 1;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(temp[i])) {
                continue;
            } 
            ArrayList<Integer> list = map.get(temp[i]);
            int size = list.size();
            for(int j = 0; j < size; j++) {
                res[list.get(j)] = rank;
            }
            rank++;
            map.remove(temp[i]);
        }
        return res;
    }
}