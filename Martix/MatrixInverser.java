class MatrixInverser {

 private double getDet(double[][] mat, int cols) {
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
  //Simple printing method for a 2D matrix
 public void printIt(double[][] a) {
  for (int i = 0; i < a.length; i++) {
   for (int b = 0; b < a[0].length; b++) {
    System.out.print(a[i][b] + " ");

   }
   System.out.println();

  }
  System.out.println();
 }

 /*
  This function will get a smaller sub matrix of the mat matrix as specified  by the cols variable
  */

 private double[][] getSmaller(double[][] mat, int cols) {

  cols = cols - 1;
  double[][] matrixer = new double[mat.length - 1][mat[0].length - 1];
  //Integers for integers for iterating over the new matrixer

  int r = 0;
  int c = 0;

  int rower = 1;
  int colomer = 0;
  //Integers for iterating over
  while (r < matrixer.length) {
   while (c < matrixer[0].length) {


    if (colomer != cols) {


     matrixer[r][c] = mat[rower][colomer];
     c++;

    }
    colomer++;

   }
   c = 0;
   colomer = 0;

   r++;
   rower++;


  }

  return matrixer;
 }

 public double[][] getInverse(double[][] matrix) {
  double[][] minors = getMatrixOfMinors(matrix);
  double[][] cofactors = getMatrixOfCofactors(minors);
  double[][] adjoint = getAdjoint(cofactors);
  double determinant = getDet(matrix, matrix.length);

  return scalarMultiple(adjoint, 1 / determinant);
 }

 private double[][] getMatrixOfMinors(double[][] matrix) {
  double[][] tempMat = matrix;
  double[][] matOfminors = new double[matrix.length][matrix.length];
  for (int i = 0; i < tempMat.length; i++) {
   for (int z = 0; z < tempMat.length; z++) {
    matOfminors[i][z] = getDet(getMatrixThatisNotIt(tempMat, i, z), matrix.length - 1);
   }
  }
  return matOfminors;
 }
 private double[][] scalarMultiple(double[][] array, double factor) {
   for (int i = 0; i < array.length; i++) {
    for (int z = 0; z < array[0].length; z++) {
     array[i][z] = factor * array[i][z];
    }
   }
   return array;

  }
  /*
  Create a sub matrix that is one unit smaller than the original matrix.
  This matrix doesn't includes all the elements in the matrix that are on the same row or colomn
  as a certain pivot element.
    
  That pivot element is defined by int i and int z
  */
 private double[][] getMatrixThatisNotIt(double[][] matrix, int i, int z) {
   double[][] smallerMatrix = new double[matrix.length - 1][matrix[0].length - 1];
   int r = 0;
   int c = 0;

   ///Bigger iterator
   int rowI = 0;
   int colI = 0;
   while (r < smallerMatrix.length) {
    if (rowI != i) {
     while (c < smallerMatrix[0].length) {
      if (colI != z) {
       smallerMatrix[r][c] = matrix[rowI][colI];
       c++;
      }
      colI++;
     }
     r++;
    }
    c = 0;
    colI = 0;
    rowI++;
   }
   return smallerMatrix;
  }
  /*
  Returns a new matrix that fits the criteria of the matrix of cofactors......every alternating
  row and column has been negated
  */
 private double[][] getMatrixOfCofactors(double[][] matrix) {
  double constant = 1;
  for (int i = 0; i < matrix.length; i++) {
   for (int z = 0; z < matrix[0].length; z++) {
    matrix[i][z] = constant * matrix[i][z];
    constant = -constant; //Negate the constant
   }
  }
  return matrix;
 }

 /*
 Returns a new matrix which is the the cofactor with all its rows flipped with its column
 */
 private double[][] getAdjoint(double[][] matrix) {
  //Recieves the cofactor matrix and transforms it into the Adjoin by transposing the matrix
  //Flips the matrix ;
  double[][] newMats = new double[matrix.length][matrix[0].length];
  int cols = 0;
  for (int i = 0; i < matrix.length; i++) {
   double[] storArr = matrix[i];
   for (int p = 0; p < newMats.length; p++) {
    newMats[p][cols] = storArr[p];
   }
   cols++;
  }
  return newMats;
 }
}