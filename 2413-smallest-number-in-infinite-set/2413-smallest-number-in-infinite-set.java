class SmallestInfiniteSet {
    PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> x - y);
    boolean[] set = new boolean[1001];
    public SmallestInfiniteSet() {
        for(int i = 1; i <= 1000; i++) {
            PQ.offer(i);
            set[i] = true;
        }
    }
    
    public int popSmallest() {
        int num = PQ.poll();
        set[num] = false;
        return num;
    }
    
    public void addBack(int num) {
        if(!set[num]) {
            PQ.offer(num);
            set[num] = true;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */