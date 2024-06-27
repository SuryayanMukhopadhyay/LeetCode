class Solution {
    public static int sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n];

        int size = (int) Math.sqrt(n);
        for (int j = 2; j <= size; j++) {
            if (prime[j] == false) {
                for (int i = j * j; i < n; i += j)
                    prime[i] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == false)
                count++;
        }
        return count;
    }

    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        return sieveOfEratosthenes(n);
    }
}