
class IsUlgy {
    public int nthUglyNumber (int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;


        for (int i = 1;  i < n; i++) {
            int min = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        return dp[n-1];
    }
//    public int nthUglyNumber(int n) {
//        int len;
//        if ( n <= 5) {
//            len = 5;
//        } else {
//            len = n;
//        }
//        int[] f = new int[len + 1];
//        f[1] = 1;
//        f[2] = 2;
//        f[3] = 3;
//        f[4] = 4;
//        f[5] = 5;
//
//        if (n <= 5) {
//            return f[n];
//        }
//
//        for (int i = 6; i <= n; i++) {
//            f[i] = f[i-1] + 1;
//
//            while (!isUgly(f[i], f)) {
//                f[i] = f[i] +1 ;
//            }
//        }
//
//        return f[n];
//    }
//
//    public boolean isUgly (int num, int[] arr) {
//        boolean result = false;
//        if (num % 2 == 0 && contains(arr, num / 2) ) {
//            return true;
//        }
//        if (num % 3 == 0 && contains(arr, num / 3) ) {
//            return true;
//        }
//        if (num % 5 == 0 && contains(arr, num / 5) ) {
//            return true;
//        }
//        return result;
//    }
//
//
//    public boolean contains(int[] array, int v) {
//
//        boolean result = false;
//
//        for(int i : array){
//            if(i == v){
//                result = true;
//                break;
//            }
//        }
//
//        return result;
//    }

    public static void main (String[] arg) {
        int res = new IsUlgy().nthUglyNumber(364);
        System.out.println("res " + res);
    }
}

/**
 第 n 个丑数， 与 第n-1 个丑数的关系
 f[n]

 f[0] = 1



 */