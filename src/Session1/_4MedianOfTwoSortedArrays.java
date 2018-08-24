package Session1;

public class _4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //code
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Referred to leet code solution
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmp2 = m;
            m = n;
            n = tmp2;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i])
                iMin = i + 1;
            else if (i > iMin && nums1[i - 1] > nums2[j])
                iMax = i - 1;
            else { //perfect i
                int maxLeft = 0;
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
                if ((m + n) % 2 == 1) return maxLeft;
                int minRight = 0;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
