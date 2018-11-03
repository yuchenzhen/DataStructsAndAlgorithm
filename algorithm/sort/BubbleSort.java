public class BubbleSort {
  public static void main (String[] args) {
    int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };
    System.out.println("************直接插入排序************");
    System.out.println("排序前：");
    display(list);
    System.out.println("");

    System.out.println("排序后：");
    bubbleSort(list);
    display(list);
  }

  public static void bubbleSort (int[] list) {
    int temp;
    for (int i = 0; i < list.length - 1; i++) {
      for (int j = 0; j < list.length - 1 - i; j++) {
        if (list[j + 1] < list[j]) {
          temp = list[j + 1];
          list[j + 1] = list[j];
          list[j] = temp;
        }
      }
    }
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