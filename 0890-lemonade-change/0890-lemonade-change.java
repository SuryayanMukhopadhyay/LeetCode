class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = bills.length;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(bills[i])) {
                int freq = map.get(bills[i]);
                map.remove(bills[i]);
                freq += 1;
                map.put(bills[i], freq);
            }
            else {
                map.put(bills[i], 1);
            }
            if(bills[i] == 10) {
                if(map.containsKey(5) && map.get(5) > 0) {
                    int freq = map.get(5);
                    freq -= 1;
                    map.remove(5);
                    map.put(5, freq);
                }
                else {
                    return false;
                }
            }
            else if(bills[i] == 20) {
                if(map.containsKey(10) && map.get(10) > 0) {
                    if(map.containsKey(5) && map.get(5) > 0) {
                        int freq10 = map.get(10);
                        int freq5 = map.get(5);
                        freq10 -= 1;
                        freq5 -= 1;
                        map.remove(10);
                        map.remove(5);
                        map.put(10, freq10);
                        map.put(5, freq5);
                    }
                    else {
                        return false;
                    }
                }
                else if(map.containsKey(5) && map.get(5) > 2) {
                    int freq = map.get(5);
                    freq -= 3;
                    map.remove(5);
                    map.put(5, freq);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}