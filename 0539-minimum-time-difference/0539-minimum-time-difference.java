class Solution {
    public int getMinutes(String time) {
        StringBuilder hour = new StringBuilder("");
        hour.append(time.charAt(0));
        hour.append(time.charAt(1));

        StringBuilder mins = new StringBuilder("");
        mins.append(time.charAt(3));
        mins.append(time.charAt(4));

        int h = Integer.parseInt(hour.toString());
        int m = Integer.parseInt(mins.toString());

        return (h * 60) + m;
    }
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int n = timePoints.size();
        int max = 1440;
        int prev = getMinutes(timePoints.get(n - 1));
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int mins = getMinutes(timePoints.get(i));
            System.out.println(mins);
            diff = Math.min(diff, Math.min(Math.abs(prev - mins), max - prev + mins));
            prev = mins;
        }
        return diff;
    }
}