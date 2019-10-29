public class DietPlanPerformance {
    public int solution (int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int tempTotal = 0;
        for (int i = 0; i < calories.length; i++) {
            tempTotal += calories[i];
            if (i >= k - 1) {
                if (tempTotal > upper) {
                    sum++;
                }
                if (tempTotal < lower) {
                    sum--;
                }
                if (i+1 - k >= 0) {
                    tempTotal = tempTotal - calories[i+1 - k];
                }
            }
        }
        return sum;
    }

    public static void main (String[] args) {
        int[] calories = new int[]{3, 2};
        int k = 2, lower = 0, upper = 1;

        int res = new DietPlanPerformance().solution(calories, k, lower, upper);
        System.out.println("res " + res);
    }
}
