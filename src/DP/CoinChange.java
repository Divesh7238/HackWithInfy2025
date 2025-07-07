package DP;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] D = {1, 5, 6, 9};
        int n = 11;

        int[] C = new int[n + 1];
        int[] S = new int[n + 1];

        Arrays.fill(C, Integer.MAX_VALUE);
        C[0] = 0;

        for (int p = 1; p <= n; p++) {
            for (int i = 0; i < D.length; i++) {
                if (D[i] <= p && C[p - D[i]] != Integer.MAX_VALUE) {
                    if (C[p - D[i]] + 1 < C[p]) {
                        C[p] = C[p - D[i]] + 1;
                        S[p] = D[i];
                    }
                }
            }
        }

        System.out.println("Minimum coins required to make " + n + " = " + C[n]);

        System.out.print("Coins used: ");
        int temp = n;
        while (temp > 0) {
            System.out.print(S[temp] + " ");
            temp -= S[temp];
        }
    }
}
