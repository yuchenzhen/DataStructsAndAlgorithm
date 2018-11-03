public class InsertSort {
  public static void main (String[] args) {
    int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };
    System.out.println("************直接插入排序************");
    System.out.println("排序前：");
    display(list);
    System.out.println("");

    System.out.println("排序后：");
    insertSort(list);
    display(list);
  }

  public static void insertSort (int[] list) {
    for (int i = 1; i < list.length; i++) {
      int temp = list[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (list[j] > temp)
          list[j + 1] = list[j];
        else
          break;
      }
      list[j + 1] = temp;
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