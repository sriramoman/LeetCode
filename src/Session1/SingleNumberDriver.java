package Session1;

public class SingleNumberDriver {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums)
            result ^= n;
        return result;
    }

    public static void main(String[] args) {
        //code
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
