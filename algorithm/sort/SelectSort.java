public class SelectSort {
  public static void sort (int[] arr) {
    int N = arr.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      swap(arr, i, min);
    }
  }

  public static void swap (int[] arr, int i, int j) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  public static void main (String[] args) {
    int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };
    System.out.println("************直接插入排序************");
    System.out.println("排序前：");
    sort(list);
    System.out.println("");

    System.out.println("排序后：");
    display(list);
  }

  /**
   * 遍历打印
   */
  public static void display (int[] list) {
    System.out.println("********展示开始********");
    if (list != null && list.length > 0) {
      for (int num : list) {
        System.out.print(num + " ");
      }
      System.out.println("");
    }
    System.out.println("********展示结束********");
  }
}
