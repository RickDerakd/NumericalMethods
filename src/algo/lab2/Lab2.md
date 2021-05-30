# Iteration method

#### the algorithm is implemented in class [IterationSolution](./IterationSolution.java)

With this program you can find solutions to systems of equations with 4 variables.

Default coefficients for unknowns are set directly in the program as a two-dimensional array 
= {{5, 1, -1, 1}, {1, -4, 1, -1}, {-1, 1, 4, 1}, { 1, 2, 1, -5}}.

The vector in which the right-hand side of each of the 4 equations
is given by a separate array b = {3 * m, m-6, 15-m, m + 2};

The initial approximation is given as an approach to the array = {0.7 * m, 1, 2, 0.5};

According to the algorithm, the determinant of the array matrix 
is first determined by forming zeros below the lower diagonal and 
multiplying the elements diagonally. If discriminant > 0 - continue the calculation.
The determinant search function is universal for any square matrix.

Next, check the convergence, ie check the difference between the sum of the modules
of non-diagonal elements and the value of the modulus of the diagonal element. 
If the convergence condition is met, we continue the calculation.

Then the cycle begins, where 9 iterations are performed, 
as well as checking the accuracy of calculations. 
The accuracy of the calculation should not be less than 0,005.

After the last iteration, the correctness of the calculations is checked,
the answers are substituted into the corresponding equations.