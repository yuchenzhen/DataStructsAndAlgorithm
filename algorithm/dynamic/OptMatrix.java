public class OptMatrix {
  public static void matrixMultiply(int[][] matrixA, int[][] matrixB,int[][] matrixC,int ra, int ca, int rb, int cb) {
    if (ca != rb) {
        System.err.println("矩阵不可乘！");
        return;
    }   // end if

    for (int i = 0; i < ra; i++) {
        for (int j = 0; j < cb; j++) {
            int sum = matrixA[i][0] * matrixB[0][j];
            for (int k = 0; k < ca; k++) {
                sum += matrixA[i][k] * matrixB[k][j];
            }   // end for
            matrixC[i][j] = sum;
        }
    }
  }

  public static void output(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
  }

  public static void outputLong(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
  }

  public static int[][] multiplication(int[][] matrixa, int[][] matrixb) {
    int rowA = matrixa.length;
    int colA = matrixa[0].length;
    int rowB = matrixb.length;
    int colB = matrixb[0].length;
    if (colA != rowB) {
      return null;
    }
    int[][] result = new int[rowA][colB];
    for(int i=0; i<matrixa.length; i++) {
      for(int j=0; j<matrixb[0].length; j++) {
        // i will complete this tomorrow @2012/09/17
        result[i][j] = calculateSingleResult(matrixa, matrixb, i, j);
      }
    }
    return result;
  }

  public static int calculateSingleResult(int[][] matrixa, int[][] matrixb, int i, int j) {
    int result = 0;
    for (int k = 0; k < matrixa[0].length; k++) {
      result += matrixa[i][k] * matrixb[k][j];
    }
    return result;
  }

  /**
   *
   * @param c A1,A2......Ai 的列数 A1 - c0
   * @param m
   * @param lastChange 输出路径
   */
  public static void optimalMatrix(int[] c, long[][] m, int[][] lastChange) {
    int n = c.length - 1;
    for (int left = 1; left <= n; left++) {
      m[left][left] = 0;
    }

    for(int k = 1; k < n; k++) {
      for (int left = 1; left <= n - k; left++) {
        int right = left + k;
        m[left][right] = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
          long thisCount = m[left][i] + m[i+1][right] + c[left -1]*c[i]*c[right];
          if (thisCount < m[left][right]) {
            m[left][right] = thisCount;
            lastChange[left][right] = i;
          }
        }
      }
    }
  }

  // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
  public static int MatrixChainOrder(int p[], int n)
  {
      /* For simplicity of the program, one extra row and one
      extra column are allocated in m[][].  0th row and 0th
      column of m[][] are not used */
      int m[][] = new int[n][n];

      int i, j, k, L, q;

      /* m[i,j] = Minimum number of scalar multiplications needed
      to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
      dimension of A[i] is p[i-1] x p[i] */

      // cost is zero when multiplying one matrix.
      for (i = 1; i < n; i++)
          m[i][i] = 0;

      // L is chain length.
      for (L=2; L<n; L++)
      {
          for (i=1; i<n-L+1; i++)
          {
              j = i+L-1;
              if(j == n) continue;
              m[i][j] = Integer.MAX_VALUE;
              for (k=i; k<=j-1; k++)
              {
                  // q = cost/scalar multiplications
                  q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                  if (q < m[i][j])
                      m[i][j] = q;
              }
          }
      }

      return m[1][n-1];
  }

  /**
   *
   * @param p 列数的数组
   * @param i 相乘的开始
   * @param j 相乘的结尾
   * @return
   */
  public static int MatrixChainOrder(int p[], int i, int j) {
    if (i == j)
      return 0;
    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int temp = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k+1, j) + p[i-1] * p[k] * p[j];
      if (temp < min) {
        min = temp;
      }
    }
    return min;
  }


  public static void main (String[] arg) {
    int[][] matrixA, matrixB, matrixC;
    matrixA = new int[][]{{1,2,3},{3,4,5}};
    matrixB = new int[][]{{1,2},{3,4}, {5, 6}};
    matrixC = new int[3][3];

    matrixMultiply(matrixA, matrixB, matrixC, matrixA.length, matrixA[0].length, matrixB.length, matrixB[0].length);

    System.out.println("args" + matrixA.length +" " +matrixA[0].length+" " + matrixB.length+" " + matrixB[0].length);
    output(matrixC);


    System.out.println("+=====================" );

    int[][] matrixD = multiplication(matrixA, matrixB);
    output(matrixD);

    System.out.println("+=====================" );



    int[] col = new int[]{10, 20, 30, 40, 30, 50} ;
    long[][] M = new long[8][8];
    int[][] lastChange = new int[8][8];
    optimalMatrix(col, M, lastChange);

    output(lastChange);
    System.out.println("+=====================" );
    outputLong(M);

    // MatrixChainOrder
    System.out.println("+===================== MatrixChainOrder" );
    int times = MatrixChainOrder(col, col.length);
    int times2 = MatrixChainOrder(col, 1, col.length - 1);
    System.out.println("+===================== MatrixChainOrder: " + times);
    System.out.println("+===================== MatrixChainOrder2: " + times2);

  }
}