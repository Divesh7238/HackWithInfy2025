package DP;

import java.util.*;

public class MaxEventsAttend {
    static int[][] events;
    static Map<String, Integer> memo = new HashMap<>();

    public static int dp(int i, int day) {
        if (i == events.length) return 0;
        String key = i + "," + day;
        if (memo.containsKey(key)) return memo.get(key);

        int res = dp(i + 1, day);


        if (day <= events[i][1]) {
            int nextDay = Math.max(day, events[i][0]);
            if (nextDay <= events[i][1]) {
                res = Math.max(res, 1 + dp(i + 1, nextDay + 1));
            }
        }

        memo.put(key, res);
        return res;
    }

    public static int maxEvents(int[][] inputEvents) {
        Arrays.sort(inputEvents, Comparator.comparingInt(a -> a[0]));
        events = inputEvents;
        memo.clear();
        return dp(0, 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt();
            events[i][1] = sc.nextInt();
        }

        System.out.println(maxEvents(events));
    }
}
