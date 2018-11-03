public class QuickSort {
  public static void main (String[] args) {
    int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };
    System.out.println("************直接插入排序************");
    System.out.println("排序前：");
    display(list);
    System.out.println("");

    System.out.println("排序后：");
    quickSort(list, 0, list.length);
    display(list);
  }

  public static void quickSort (int[] list, int low, int high) {
    if (low < high-1) {
      int mid = partion(list, low, high-1);
      quickSort(list, low, mid);
      quickSort(list, mid+1, high);
    }
  }

  public static int partion (int[] list, int low, int high) {
    int p = list[low];
    while (low < high) {
      while (list[high] >= p && high > low) {
        high--;
      }
      list[low] = list[high];

      while (list[low] <= p && low < high) {
        low++;
      }
      list[high] = list[low];
    }
    list[low] = p;
    return low;
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