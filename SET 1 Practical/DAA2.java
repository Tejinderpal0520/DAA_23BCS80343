import java.util.*;

class DAA2 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1, 2, 1 }, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix = prefix + nums[i];
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}