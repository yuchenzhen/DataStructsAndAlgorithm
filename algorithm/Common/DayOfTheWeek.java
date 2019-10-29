import java.math.BigInteger;

public class DayOfTheWeek {
    public String solution (int day, int month, int year ) {
        // 蔡勒公式
        // y1 = year % 100; 年的后两位
        // y2 = year / 100;   年的前两位
        // m 月份， 但是 1，2 月要算作前一年的 13， 14 月， 年份相对也要修改
        // d 日期
        // w 从 0 开始 ， Sunday 开始算
        // w = (y1 + (y1/4) + (y2/4) - 2* y2 + (26*(m + 1) / 10 ) + d - 1   )

        String[] map = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month <= 2 ) {
            year--;
            month = month + 12;
        }
        int y1 = year / 100;
        int y2 = year % 100;

//        System.out.printf("[data]:==> y1: %d, y2: %d, month : %d, day: %d", y1, y2, month, day);
//        System.out.println(" ");
        int res = (y2 + (y2/4) + (y1/4) - 2*y1 +  (26 *(month + 1) / 10) + day - 1 );
//        System.out.println("res" + res);
        res = this.mod(res, 7);
        return map[res];
    }

    private int mod(int x, int y)
    {
        int result = x % y;
        return result < 0? result + y : result;
    }

    public static void main (String[] arg) {
        String res = new DayOfTheWeek().solution(4, 4, 2006);
        System.out.printf("[data]:==> res: %s", res);
    }
}
