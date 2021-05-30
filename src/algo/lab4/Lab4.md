# Interpolation method

#### the algorithm is implemented in class [InterpolationSolution](./InterpolationSolution.java)

Lagrange's interpolation polynomial is a polynomial of minimal degree
that takes all values in a given set of points.

The interpolation function passes strictly through the nodes of the table,
because the number of coefficients in the interpolation function is equal
to the number of tabular values.

The problem is to find the interpolating function F(x) = y, 
which allows you to find what values the function takes 
at points that are not nodes. In this program, we use an 
interpolation Lagrange polynomial - a polynomial of minimal degree
that takes all values in a given set of points.