public class Fibonacci {

  public static int fibonacci(int N) {
    if (N <= 1)
      return 1;
    else
      return fibonacci(N - 2) + fibonacci(N - 1);
  }

  public static int fibonacciB(int N) {
    int i;
    int lastNum, resultNum, lastLastNume;
    lastNum = resultNum = lastLastNume = 1;
    for (i = 2; i <= N; i++) {
      resultNum = lastNum + lastLastNume;
      lastLastNume = lastNum;
      lastNum = resultNum;
    }
    return resultNum;
  }

  public static void main (String[] args) {
    for (int i = 1; i < 20; i++) {
      System.out.println("fibonacci A is " + fibonacci(i) + "  fibonacci B is " + fibonacciB(i)  );
    }
  }
}