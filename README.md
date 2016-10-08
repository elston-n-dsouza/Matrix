





































Solving a n by n matrix using Cramer's method and Gauss Jordan


A matrix is a set of numbers arranged in rows and column. These numbers have various significance when all used together. They may have special meaning, for example, a matrix could be defined as a particular vector in 3D space. Matrices have had a big impact in the world of science and the world of applied sciences. 
As previously discussed, matrices are of particular importance in our lives. But it is just as important to know the terminology and the methods and functions that apply to them. 
The aim of this computing task is to create an abstraction in which information may be extracted from a n by n matrix. 

Terminology 

Determinant 

A determinant in layman’s terms can be considered in many instances the magnitude of the matrix. Suppose a certain matrix defines a velocity vector, v, then the determinant of the matrix can be considered to be the magnitude of the velocity vector ala the speed of the object. There are various different ways to calculate the determinant of a matrix. 

For simplicities sake, the determinant of the following 2 by 2 matrix can be found by subtracting the product of the diagonals. 




Inverse 

The inverse is a matrix that is constructed from the original matrix. One inverse and its corresponding matrix multiplied together will give the identity matrix which is a certain matrix where the diagonal is 1 and the rest of the values are 0.

An example of a identity matrix is shown below

The inverse doesn’t exist if a determinant is equal to zero. 

Solutions of matrices

The importance of matrices in this specific context is to solve equations. These equations are linear equations and have n terms in them. In order to find, n unknowns, one would require n sets of equations. The coefficients in these system of equations can represent a matrix. Of length n and width n. 
Cofactor 

Minors
A minor matrix is a matrix that of equal size (n by n).  Suppose element s in on row r and column c, then the matrix of minors can be constructed by finding the determinant of a matrix that is not on row r and column c. The value of the determinant will be placed in element s’s location on the original matrix.
This process is better illustrated with the visual example below. 


Adjugate Matrix
This process takes an old matrix and switches the row and the column so that the matrix is flipped across diagonally.  

Processes

One may employ various methods in order to evaluate the solution for the nth term. 

The two implemented today are the Gauss Jordan Approach and the Cramer approach..

Gauss Jordan 

Algorithm 
        Create a matrix of n rows and 2n + 1 columns. 
        The columns from col = 0  to col = n-1 will be occupied by the coefficients of the equation. 
        On the nth column, input the numerical values for the equations. 
        The last segment will be occupied by a identity matrix of size n by n. 
        Begin a loop where the matrix is normalized.
        Begin subtraction. 
        Repeat 5 and 6 until the identity matrix is achieved in the left-most matrix. 
        You may find the nth term of the system of equations and finding the corresponding solution. This is because all the others in the row are zero meaning that the value of the nth x term will be the one in the solution column. 

Using the Cramer’s Rule 
The Cramer’s Rule is a method for finding the solution of the nth term in a system of linear equations with n unknowns and n equations. Create a matrix that stores the coefficients of each unknown term within the 2D array, try using double values to take into account any decimal and non integers and for greater precision. The solutions array is the array of double values that corresponds to the system of linear equations. 
Create a new matrix that is similar to the original matrix in every way except that the nth column is replaced with the solutions array.
Divide the determinant of the new array by the determinant of the original array to find the solution of the nth term.




Architecture of the Matrix Solver Class 
For this implementation, a java class known as MatrixSolver was written. The MatrixSolver class features multiple public methods that provide functionality to another class. The private methods are helper methods that exist to reduce the complexity of the task and to break down the problem into manageable chunks.


Method
Arguments
Purpose
getIt()
double[][] matrix, double[] equals, int xcol
Matrix - is a two dimensional array consisting of double values. This 2D array represents a system of linear equations. It is assumed that this matrix is of size  n by n
Equals - is a one dimensional array that is the result of the system of equations that corresponds to the row of the matrix given as the first argument. It is  assumed that this array is of size n because the rows of the matrix are of size n.
Xcol is the integer representing the x term that the function needs to find. 
This public method solves the matrix (system of linear equations ) and finds the value of the nth term of the coefficients of the equations presented in the matrix.  It does this using the Cramer’s rule. Returns a double
getDet()
double[][] mat, int cols
Mat - a two dimensional matrix of size n by n filled with values of doubles.
Cols - a integer representing the width of the matrix


This is also a public method that can be used to find the determinant of a certain matrix. The way this is done is by taking a matrix and running the getSmaller method, A smaller and smaller matrix is used until the size of the n by n matrix is 2 by 2, then the determinant can be found easily (the difference between the product of the diagonals).
getSmaller() 
double [][] mat, int cols


This is a private method that is only accessible by members of the class. The function getSmaller() will get a matrix that is n-1 by n-1  from a n by n matrix and this matrix will not include any element on the 1st row and the column specified by the cols variable.




