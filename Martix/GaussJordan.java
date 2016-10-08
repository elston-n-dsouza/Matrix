public class GaussJordan{
    /*
    Width and length of the entire big array
    */
    private int length;
    private int width;
    private int realArrWidth;
    private double determinant;
    private double [][] matrix;
    public GaussJordan (double[][] givenMatrix, double [] solutions){
        this.realArrWidth = givenMatrix[0].length;
        this.length = givenMatrix.length;
        this.width = (2*realArrWidth) +1;
        this.matrix = new double [length][width];
        this.determinant = 1;
        /*
        Create the matrix
        */
        InsertMatrix(givenMatrix);
        InsertSolutions(solutions);
        InsertIdentityMatrix();
        solve();
    }
    private void InsertMatrix (double [][] givenMatrix ){
     
        for (int i  = 0 ; i < realArrWidth; i ++ ){
            for (int k =  0 ; k < length ; k ++){
                this.matrix[i][k] = givenMatrix [i][k];
            }
        }
        
    }
    /*
    Insert solutions to this matrix
    */
    private void InsertSolutions (double [] solutions){
        for (int i = 0 ; i < length ; i++){
            this.matrix [i][realArrWidth] = solutions [i];
        }
    }
    /*
    Inserts the identity matrix
    */
    private void InsertIdentityMatrix (){
        int r = 0;
        int c = realArrWidth +1;
        while (c < width && r < length  ){
            this.matrix [r][c] = 1;
            r++;
            c++;
        }
    }
    /*
    Returns the Matrix....
    Currently used for printing purposes
    */
    public double [][] getMatrix (){
        return matrix;
    }
    /*
    Returns the xth solution of the system of equations
    */
    private double getSolution (int xth){
        return matrix[xth][realArrWidth];  
    }
    
    /*
    Returns the 2D array from col > realArrWidth
    
    That was initially the identity matrix
    */
    public double [][] getInverse (){
        //The inverse  matrix
        double [][] inverseMatrix =  new double [realArrWidth][realArrWidth];
        //Loop through and fill the inverse matrix
        int Iiterator = 0 ;
        for (int i  = realArrWidth+1; i < width ; i ++ ){
            for (int k =  0 ; k < length ; k ++){
                inverseMatrix [k][Iiterator] = matrix [k][i];
            }
           Iiterator++;

        }
        return inverseMatrix;
    }
    private double getDeterminant (){
        return determinant;
    }
    /*
    Normalize the matrix.
    Gets the
    */
    private double [][] normalize (double [][] TempMatrix , int col ){
       
       for (int i = 0 ; i < TempMatrix.length ; i ++){
           double valueToDivideBy = TempMatrix[i][col];
           for ( int k = 0 ; k < TempMatrix[0].length ; k++){
               TempMatrix [i][k] /= valueToDivideBy; //Divides every row with the value specified
               
           }
           determinant *= valueToDivideBy; //Updates the Determinant
       }
       return TempMatrix;
    }
    public double [][] subtract (double [][] TempMatrix , int rowSub){
        /*
        Keeps the row constant and iterated through the column
        */
       int row = 0 ;
       int col = 0 ;
       while (row < TempMatrix.length ){
           if (row != rowSub){
           while (col < TempMatrix[0].length){
           TempMatrix[row][col] = TempMatrix [row][col] - TempMatrix [rowSub][col];  
            col ++;
           }
           }
            col = 0;
            row ++;
       }
       
       return TempMatrix;
        
    }
    /*
    Normalizes and Subtractes the matrix at every iteration for n number of iterations
    */
    Private void solve (){
      
        for (int i = 0 ; i  <  this.length ;i ++){
        normalize (this.matrix, i);
            subtract(this.matrix, i);
        }
        finalNormalize (this.matrix);
            
        }
    /*
    This is the final normalize method to reduce everything to the identity matrix
    
    */
    public void finalNormalize ( double [][] matrix ){
        int traverser = 0 ;
        double valueToDivide = 0;
        while (traverser < length){
            valueToDivide = matrix  [traverser][traverser];
            for (int i = 0 ; i < width ; i ++){
                matrix[traverser][i] /= valueToDivide;
            }
            traverser++;
        }
    }

}




