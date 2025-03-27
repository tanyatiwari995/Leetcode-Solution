package day15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class index {
    class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len = nums.size();
        
        int[] lMaxFreqs = findDominantFromLeft(nums, len);
        int[] rMaxFreqs = findDominantFromRight(nums, len);
        
        for (int id = 0; id < len - 1; id++) {
            if (lMaxFreqs[id] == rMaxFreqs[id + 1] && lMaxFreqs[id] != 0) {
                return id;
            }
        }
        
        return -1;
    }
    
    private int[] findDominantFromLeft(List<Integer> nums, int len) {
        int[] dominant = new int[len];
        
        Map<Integer, Integer> freqs = new HashMap<>();
        int prev = -1;
        
        for (int id = 0; id < len; id++) {
            int num = nums.get(id);
            freqs.put(num, 1 + freqs.getOrDefault(num, 0));
            
            int size = id + 1;
            
            int freq = freqs.get(num);
            if (2 * freq > size) {
                dominant[id] = num;
                prev = num;
            } else {
                freq = freqs.get(prev);
                if (2 * freq > size) {
                    dominant[id] = prev;
                }
            }
        }
        
        return dominant;
    }
    
    private int[] findDominantFromRight(List<Integer> nums, int len) {
        int[] dominant = new int[len];
        
        Map<Integer, Integer> freqs = new HashMap<>();
        int prev = -1;
        
        for (int id = len - 1; id >= 0; id--) {
            int num = nums.get(id);
            freqs.put(num, 1 + freqs.getOrDefault(num, 0));
            
            int size = len - id;
            
            int freq = freqs.get(num);
            if (2 * freq > size) {
                dominant[id] = num;
                prev = num;
            } else {
                freq = freqs.get(prev);
                if (2 * freq > size) {
                    dominant[id] = prev;
                }
            }
        }
        
        return dominant;
    }
}
}
