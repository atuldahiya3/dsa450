
import java.util.Arrays;

class Solution {
    public int largestPrime(int n) {
        if (n < 2) return 0;

        // 1️⃣ Sieve of Eratosthenes
        boolean[] isPrime = sieve(n);

        int sum = 0;
        int res = 0;

        // 2️⃣ Prefix sum of primes starting from 2
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                if (sum > n) break;

                // 3️⃣ Check if prefix sum itself is prime
                if (isPrime[sum]) {
                    res = sum;
                }
            }
        }
        return res;
    }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
