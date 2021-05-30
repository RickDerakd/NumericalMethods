# Approximation method

#### the algorithm is implemented in class [ApproximationSolution](./ApproximationSolution.java)

Approximation - an approximation method in which to find additional
values other than tabular data, the approximate function is not through
narrow interpolations, but between them.

The default data corresponds to the lecture materials.

xi = {-2, -1, 0, 1, 2};
yi = {-4.8, 0, 3.2, 4, 2.8};

The idea of the method is to calculate the coefficients
of a function that minimizes the sum of squares of deviations,
solving a system of equations. The problem of finding the minimum
of a nonlinear function, especially several variables, can have several
solutions. The main limitation of the type of simulation function
is that it must be linear with respect to the required coefficients.