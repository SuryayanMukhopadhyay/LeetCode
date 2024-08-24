class Pair {
    char ch;
    int freq;
    Pair(char _ch, int _freq) {
        this.ch = _ch;
        this.freq = _freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, 1);
            }
            else {
                int freq = map.get(ch);
                map.remove(ch);
                map.put(ch, freq + 1);
            }
        }
        PriorityQueue<Pair> PQ = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int freq = map.get(ch);
                PQ.offer(new Pair(ch, freq));
                map.remove(ch);
            }
        }
        StringBuilder str = new StringBuilder("");
        while(!PQ.isEmpty()) {
            char c = PQ.peek().ch;
            int f = PQ.peek().freq;
            PQ.poll();
            while(f > 0) {
                str.append(c);
                f--;
            }
        }
        return str.toString();
    }
}