class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] prereqCount = new int[numCourses];
        for (int[] req : prerequisites) prereqCount[req[1]]++;

        final int length = prerequisites.length;
        final boolean[] finished = new boolean[length];
        boolean run = true;
        while (run) {
            run = false;
            for (int i = 0; i < length; i++) {
                if (!finished[i] && prereqCount[prerequisites[i][0]] == 0) {
                    finished[i] = true;
                    prereqCount[prerequisites[i][1]]--;
                    run = true;
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (prereqCount[i] != 0) return false;
        }
        return true;
    }
}