public class RotateArray {
    static void rotate3(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int swapVar=nums[i];
            nums[i]=nums[nums.length-k+i];
            nums[nums.length-k+i]=swapVar;
        }
    }

    static void rotate2(int[] nums, int k){
        for (int i = 0; i <= k; i++) {
            int bkpVar = nums[0];
            for (int j = 1 ; j < nums.length; j++) {
                nums[j-1]=nums[j];
            }
            nums[nums.length-1]=bkpVar;
        }
    }

    static void rotate1(int[] nums,int k){
        int[] spareNums = new int[k];
        for (int i = 0; i < k; i++) {
            spareNums[i]=nums[nums.length-k+i];
        }
        for (int i = 0; i <nums.length-k ; i++) {
            nums[nums.length-1-i]=nums[nums.length-1-k-i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]=spareNums[i];
        }
    }

    public static void main(String[]args){
        int[] nums={1,2};
        rotate3(nums,0);
        for (int x :
                nums) {
            System.out.println(x);
        }
    }
}
