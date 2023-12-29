import java.util.HashMap;
import java.util.Map;

class Solution {
    public int kSubstrConcat(int n, String s, int k) {
        if (n % k > 0)
            return 0;

        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n / k; ++i)
            mp.put(s.substring(i * k, (i + 1) * k), mp.getOrDefault(s.substring(i * k, (i + 1) * k), 0) + 1);
        
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet())
            cnt += (entry.getValue() > 1) ? 1 : 0;

        return (mp.size() <= 2 && cnt <= 1) ? 1 : 0;
    }
}
