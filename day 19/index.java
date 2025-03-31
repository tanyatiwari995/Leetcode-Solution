
import java.util.*;
class Solution {
    public long putMarbles(int[] w, int k) {
        if (w.length == k || k == 1) return 0;
        int n = w.length;
        List<Integer> vec = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            vec.add(w[i] + w[i + 1]);
        }
        Collections.sort(vec);
        long mini = 0, maxi = 0;
        for (int i = 0; i < k - 1; i++) {
            mini += vec.get(i);
            maxi += vec.get(n - 2 - i);
        }
        return maxi - mini;
    }
}
