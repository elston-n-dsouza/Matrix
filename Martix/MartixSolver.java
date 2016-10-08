/*
Uses Krammer's Method to solve a matrix of system of linear equations
*/
class MatrixSolver {

 public double getIt(double[][] matrix, double[] equals, int xcol) {
  double[][] oldMat = matrix;
  double ins = (getDet(matrix, matrix[0].length));
  double[][] newermat = replace(oldMat, equals, xcol);
  double division = getDet(newermat, matrix[0].length) / ins;
  return division;

 }

 private double[][] replace(double[][] matriesx, double[] vas, int sol) {
  double[][] newtempMat = matriesx;
  for (int i = 0; i < newtempMat.length; i++) {
   newtempMat[i][sol] = vas[i];
  }
  return newtempMat;
 }

 public double getDet(double[][] mat, int cols) {
  if (cols == 2) {
   double doubledet = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
   return doubledet;
  } else {
   double finalesum = 0;
   int iterator = cols;
   while (iterator > 0) {
    finalesum += (double) - mat[0][iterator - 1] * Math.pow(-1, iterator) * getDet(getSmaller(mat, iterator), cols - 1);
    iterator--;
   }
   return finalesum;
  }
 }


 private double[][] getSmaller(double[][] mat, int cols) {
  cols = cols - 1;
  double[][] matrixer = new double[mat.length - 1][mat[0].length - 1];
  //Integers for integers for iterating over the new matrixer

  int r = 0;
  int c = 0;

  int rower = 1;
  int colomer = 0;
  while (r < matrixer.length) {
   while (c < matrixer[0].length) {

    if (colomer != cols) {

     matrixer[r][c] = mat[rower][colomer];
     c++;
    }
    colomer++;

   }
   //Reset column and increment row
   c = 0;
   colomer = 0;
   r++;
   rower++;
  }
  return matrixer;
 }
}