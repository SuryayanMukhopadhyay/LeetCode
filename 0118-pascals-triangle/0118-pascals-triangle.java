class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = list.get(i - 1);
            List<Integer> tempRow = new ArrayList<>();
            tempRow.add(1);
            int size = prevRow.size();
            for(int j = 1; j < size; j++) {
                tempRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            tempRow.add(1);
            list.add(tempRow);
        }
        return list;
    }
}