class Solution {
    public int bulbSwitch(int n) {
        //intuition in this video : https://youtu.be/q-7aoEILGb0?si=0rZ8xCaVnMoMDU4j

        //take a big example, (say 20)...you will see only perfect square numbered bulbs are remaining turned ON.
        //so just find number of perfect squares between 1 and n (inclusive).
        int count = 0;
        for(int i = 1; i*i <= n; i++) {
            count++;
        }
        return count;
    }
}