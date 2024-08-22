class Tuple {
    int stops;
    int vertex;
    int cost;

    Tuple(int _stops, int _vertex, int _cost) {
        this.stops = _stops;
        this.vertex = _vertex;
        this.cost = _cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        Queue<Tuple> Q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        Q.offer(new Tuple(0, src, 0));
        dist[src] = 0;
        while (!Q.isEmpty()) {
            Tuple temp = Q.poll();
            if(temp.stops > k) continue;
            for (int[] flight : adj.get(temp.vertex)) {
                if (dist[flight[0]] > temp.cost + flight[1] && temp.stops <= k) {
                    dist[flight[0]] = temp.cost + flight[1];
                    Q.offer(new Tuple(temp.stops + 1, flight[0], temp.cost + flight[1]));
                }
            }
        }
        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }
}