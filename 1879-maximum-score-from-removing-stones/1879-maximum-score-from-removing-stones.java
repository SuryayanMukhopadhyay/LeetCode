class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> y - x);
        PQ.offer(a);
        PQ.offer(b);
        PQ.offer(c);
        int score = 0;
        while(!PQ.isEmpty()) {
            int x = PQ.poll();
            int y = PQ.poll();
            if(x == 0 || y == 0) {
                break;
            }
            score++;
            PQ.offer(x - 1);
            PQ.offer(y - 1);
        }
        return score;
    }
}