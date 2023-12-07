package Leet;

public class Sqrt {
    public static void main(String[] args) {
        int result = mySqrt(2147395599);
        System.out.println(result);
    }
    public static int mySqrt(int x) {
        long left = 1;
        long right = x;
        long mid = 0;
        if(x == 0) return 0;
        if (x < 3) {
            return 1;
        }
        while (left <= right && right - left > 1) {
            mid = left + (right - left)/2;
            if((mid * mid) == x){
                return (int)mid;
            }else if((mid * mid) < x){
                left = mid;
            }else if((mid * mid) > x){
                right = mid;
            }
        }
        return (int)left;
        
    }
}
