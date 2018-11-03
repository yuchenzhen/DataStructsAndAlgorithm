public class MergeSort {
  public static void main (String[] args) {
    int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };
    System.out.println("************直接插入排序************");
    System.out.println("排序前：");
    display(list);
    System.out.println("");

    System.out.println("排序后：");
    mergeSort(list);
    display(list);
  }

  public static void mergeSort (int[] list) {
    int low = 0;
    int high = list.length - 1;
    doSort(list, new int[list.length], low, high);
  }

  private static void doSort (int[] list, int[] temp, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      doSort(list, temp, low, mid);
      doSort(list, temp, mid + 1, high);
      merge(list, temp, low, mid, high);
    }
  }

  public static void merge (int[] list, int[] temp, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;
    int m = mid;
    int n = high;
    int tempHead = low;

    while (i <= m && j <= n) {
      if (list[i] < list[j]) {
        temp[tempHead++] = list[i++];
      } else {
        temp[tempHead++] = list[j++];
      }
    }

    while (i <= mid) {
      temp[tempHead++] = list[i++];
    }

    while (j <= high) {
      temp[tempHead++] = list[j++];
    }

    // 交换数据
    for (int l = low; l <= high; l++) {
      list[l] = temp[l];
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

// public class MergeSort {
//   public static void main(String[] args) {
//       int[] list = { 90, 10, 20, 50, 70, 40, 80, 60, 30, 52 };;
//       System.out.println("************归并排序************");
//       System.out.println("排序前：");
//       display(list);
//       System.out.println("");

//       System.out.println("排序后：");
//       mergeSort(list, new int[list.length], 0, list.length - 1);
//       display(list);
//   }

//   /**
//    * 归并排序算法
//    *
//    * @param list     待排序的列表
//    * @param tempList 临时列表
//    * @param head     列表开始位置
//    * @param rear     列表结束位置
//    */
//   public static void mergeSort(int[] list, int[] tempList, int head, int rear) {
//       if (head < rear) {
//           // 取分割位置
//           int middle = (head + rear) / 2;
//           // 递归划分列表的左序列
//           mergeSort(list, tempList, head, middle);
//           // 递归划分列表的右序列
//           mergeSort(list, tempList, middle + 1, rear);
//           // 列表的合并操作
//           merge(list, tempList, head, middle + 1, rear);
//       }
//   }

//   /**
//    * 合并操作(列表的两两合并)
//    *
//    * @param list
//    * @param tempList
//    * @param head
//    * @param middle
//    * @param rear
//    */
//   public static void merge(int[] list, int[] tempList, int head, int middle, int rear) {
//       // 左指针尾
//       int headEnd = middle - 1;
//       // 右指针头
//       int rearStart = middle;
//       // 临时列表的下标
//       int tempIndex = head;
//       // 列表合并后的长度
//       int tempLength = rear - head + 1;

//       // 先循环两个区间段都没有结束的情况
//       while ((headEnd >= head) && (rearStart <= rear)) {
//           // 如果发现右序列大，则将此数放入临时列表
//           if (list[head] < list[rearStart]) {
//               tempList[tempIndex++] = list[head++];
//           } else {
//               tempList[tempIndex++] = list[rearStart++];
//           }
//       }

//       // 判断左序列是否结束
//       while (head <= headEnd) {
//           tempList[tempIndex++] = list[head++];
//       }

//       // 判断右序列是否结束
//       while (rearStart <= rear) {
//           tempList[tempIndex++] = list[rearStart++];
//       }

//       // 交换数据
//       for (int i = 0; i < tempLength; i++) {
//           list[rear] = tempList[rear];
//           rear--;
//       }
//   }

//   /**
//    * 遍历打印
//    */
//   public static void display(int[] list) {
//       System.out.println("********展示开始********");
//       if (list != null && list.length > 0) {
//           for (int num :
//                   list) {
//               System.out.print(num + " ");
//           }
//           System.out.println("");
//       }
//       System.out.println("********展示结束********");
//   }
// }