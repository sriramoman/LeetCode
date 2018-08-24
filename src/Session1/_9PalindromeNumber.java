package Session1;

public class _9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int r = 0, y = x;
        while (y > 0) {
            r = r * 10 + y % 10;
            y /= 10;
        }
        System.out.println(r);
        return r == x;
    }

    public static void main(String[] args) {
        //code
        System.out.println(isPalindrome(-121));
    }
}
