package Session1;

public class _11ContainerWithMostWater {
    public static void main(String[] args) {
        //code
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * h);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
