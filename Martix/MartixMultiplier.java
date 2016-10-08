class MatrixMultiplier {
 public static double[][] multiply(double[][] m1, double[][] m2) {
   int sums = 0;
   double[][] product = new double[m1.length][m2[0].length];
   int k = 0;
   for (int i = 0; i < m1.length; i++) {
    for (int b = 0; b < m2[0].length; b++) {
     while (k < m2[0].length) {
      sums += m1[i][k] * m2[k][b];
      k++;
     }
     product[i][b] = sums;
     k = 0;
     sums = 0;

    }
   }
   return product;
  }
  //Printing a 2D matrix
 public static void printIt(int[][] a) {
  for (int i = 0; i < a.length; i++) {
   for (int b = 0; b < a[0].length; b++) {
    System.out.print(a[i][b] + " ");

   }
   System.out.println();

  }

 }
}