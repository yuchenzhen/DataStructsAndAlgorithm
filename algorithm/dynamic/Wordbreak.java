import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class Wordbreak {
    private static boolean wordBreakFn (String s, List<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];

        f[0] = true;
        System.out.println(f[1]);

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= wordDict.size() -1 ; j++) {
                String thisWord = wordDict.get(j);
                int tempLen = thisWord.length();
                if (i >= tempLen) {
                    String endPart = s.substring(i- tempLen, i);
//                    System.out.println("result  endPart " + endPart + " thisWord " + thisWord + " boolean " + (Objects.equals(thisWord,endPart)));
                    if (Objects.equals(thisWord,endPart)) {
                        f[i] = f[i] || f[i-tempLen];
                    }
                }
            }
        }
        return f[len];
    }

    public static void main (String[] args) {
        String s = new String("leetcode");
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");

        boolean f = wordBreakFn(s, wordDict);
        System.out.print("f result is " + f);
    }
}