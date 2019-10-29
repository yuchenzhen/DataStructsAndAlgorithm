import java.lang.reflect.Array;
import java.util.*;

class CanMakePaliQueries {
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        int[][] count = new int[n][26];

        count[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; ++i) {
            count[i][s.charAt(i) - 'a']++;
            for (int j = 0; j < 26; ++j) {
                count[i][j] += count[i - 1][j];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            if (k >= right - left + 1) {
                res.add(true);
                continue;
            }
            int modify = 0;
            for (int i = 0; i < 26; ++i) {
                int p = left == 0 ? count[right][i] : count[right][i] - count[left - 1][i];
                if (p > 0) {
                    if (p % 2 == 1) {
                        modify++;
                    }
                }
            }
            if ((modify / 2 <= k) || modify == 0 || (modify == 1 && k == 0)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = queries.length;
        List<Boolean> answer = new ArrayList<>(len);
        char[] ss = s.toCharArray();
        for (int[] query: queries) {
            answer.add(this.check(ss, query[0], query[1], query[2]));
        }
        return answer;
    }

    private Boolean check(char[] s, int left, int right, int change) {
        if (change >= 13) {
            return true;
        }
        if (change >= right - left + 1) {
            return true;
        }
//        System.out.printf("array is %s, left is %d, right is %d, change is %d", array.toString(), left, right, change);
//        System.out.println(" ");
        int len = s.length;
        int[] count = new int[26];
        for (int i = left; i <=right; i++) {
            if (count[s[i] - 'a'] == 0) {
                count[s[i] - 'a'] = 1;
            } else {
                count[s[i] - 'a'] = 0;
            }
        }
        int singleCount = 0;

        for (int ignored : count) {
            singleCount+=ignored;
        }

//        System.out.printf("[data]:==> singleCount = %d, change = %d, len = %d", singleCount, change, len);
//        System.out.println(" ");

        return singleCount - 2 * change <= 1;

//        return singleCount <= change;
    }

    public static void main (String[] arg) {
        int[][] queries = {
            {1,1,1},
            {2,3,0},
            {3,3,1},
            {0,3,2},
            {1,3,3},
            {2,3,1},
            {3,3,1},
            {0,3,0},
            {1,1,1},
            {2,3,0},
            {3,3,1},
            {0,3,1},
            {1,1,1}
        };
//        int[][] queries = {
//                {3,3,0},
//                {1,2,0},
//                {0,3,1},
//                {0,3,2},
//                {0,4,1}
//        };



        System.out.println("queries " + Arrays.deepToString(queries));
        // [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
//
        String input = new String("hunu");
//        String input = new String("abcda");
        List<Boolean> output = new CanMakePaliQueries().canMakePaliQueries(input, queries);
        System.out.println("output" + output);
    }
}

//[true,false,true,true,true,true,true,false,true,false,true,false,true]
//        预期：
//        [true,false,true,true,true,true,true,false,true,false,true,true,true]
