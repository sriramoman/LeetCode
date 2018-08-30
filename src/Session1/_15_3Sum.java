package Session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            index.put(nums[i], i);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                if (index.containsKey(target) && index.get(target) > j) {
                    r.add(Arrays.asList(nums[i], nums[j], target));
                    j = index.get(nums[j]);
                }
                i = index.get(nums[i]);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        //code
        int[] arr = {-1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1};
        List<List<Integer>> k = threeSum(arr);
        for (List<Integer> l : k) {
            System.out.print("[ ");
            for (Integer m : l)
                System.out.print(m + ", ");
            System.out.println("]");
        }
    }
}
