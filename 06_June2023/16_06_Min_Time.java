// Link: https://practice.geeksforgeeks.org/problems/95bb244da24edd6214086ff934886ccda6ed9da8/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public long minTime(int n, List<Integer> locations, List<Integer> types) {
        Map<Integer, List<Integer>> col = new HashMap<>();
        List<Integer> type = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int currentType = types.get(i);
            int currentLocation = locations.get(i);

            if (!col.containsKey(currentType)) {
                col.put(currentType, new ArrayList<>(List.of(currentLocation, currentLocation)));
            } else {
                List<Integer> loc = col.get(currentType);
                loc.set(0, Math.min(loc.get(0), currentLocation));
                loc.set(1, Math.max(loc.get(1), currentLocation));
            }
        }

        col.put(0, new ArrayList<>(List.of(0, 0)));
        col.put(1000002, new ArrayList<>(List.of(0, 0)));

        for (int key : col.keySet()) {
            type.add(key);
        }

        int tsz = type.size();
        long[][] dp = new long[tsz + 1][2];
        long lastval, offset;
        dp[tsz][0] = dp[tsz][1] = 0;

        for (int i = tsz - 1; i >= 0; --i) {
            for (int li = 1; li >= 0; --li) {
                List<Integer> loc = col.get(type[i]);

                lastval = col.get(type[i - 1]).get(li);
                offset = Math.abs(loc.get(0) - loc.get(1));

                dp[i][li] = offset + Math.min(dp[i + 1][1] + Math.abs(lastval - loc.get(0)),
                        dp[i + 1][0] + Math.abs(lastval - loc.get(1)));
            }
        }

        return Math.min(dp[0][0], dp[0][1]);
    }
}
