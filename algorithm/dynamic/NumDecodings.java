public class NumDecodings {
    public int numDecodings(String s) {
        String[] ary = s.split("");
        int len = ary.length;
        int[] dp = new int[len + 1 ];


        if (ary[0].equals("0") ) {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;

        // [2, 0]
        for (int i = 2; i <= len; i++) {
            int tmpNum = Integer.parseInt(ary[i - 1]);
            int lastNum = Integer.parseInt(ary[i-2]);
            int lastCon = lastNum * 10 + tmpNum;

            if (lastCon <= 26 && lastCon>= 10) {
                if (lastCon == 10 || lastCon == 20) {
                    dp[i] = dp[i-2];
                } else {
                    dp[i] = dp[i-2] + dp[i-1];
                }
            } else if (lastCon > 0 && lastCon < 10) {
                dp[i] = dp[i-1];
            } else {
                return 0;
            }

//            if (tmpNum == 0  ) {
//                if (lastCon >= 30 || lastCon < 10) {
//                    return 0;
//                }
//                dp[i] = dp[i-2];
//            } else {
//                if (lastCon <= 26 && lastCon >= 10) {
//                    dp[i] = dp[i-2] + dp[i-1];
//                } else {
//                    dp[i] = dp[i-1];
//                }
//            }
        }
        return dp[len];
    }

    /**
     * 递归方式
     * i start from 0
     */
//    public int getAns(String[] arr, int i) {
//        if (arr.length == i) {
//            return 1;
//        }
//        if (arr[i-1].equals("0")) {
//            return 0;
//        }
//
//        int ans1 = getAns(arr, i+1);
//        int res;
//        int thisNum =
//        res = ans1 + ans2;
//        return res;
//    }

    public static void main (String[] ary) {
        int res = new NumDecodings().numDecodings("0");
        System.out.println("res "+ res);
    }
}
