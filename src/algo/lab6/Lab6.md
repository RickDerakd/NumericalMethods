# Rectangle method

#### the algorithm is implemented in class [RectangleSolution](./RectangleSolution.java)

The method of rectangles(also known as Riemann sum) 
is a method of numerical integration of a function of one variable,
which consists in replacing the integrand with a polynomial of degree zero,
that is, a constant, on each elementary segment.

# Trapezoid method

#### the algorithm is implemented in class [TrapezoidSolution](./TrapezoidSolution.java)

The trapezoid method is a method of numerical integration
of a function of one variable, which consists in replacing
the integrand on each elementary segment of the integrand
with a polynomial of the first degree, that is, a linear function.


# Simpson method

#### the algorithm is implemented in class [SimpsonSolution](./SimpsonSolution.java)

The idea of the method(also known as Simpson's rule) is to approximate
the integrand on the segment (a, b) by an interpolation polynomial
of the second degree in order to approximate the graph of the function
on the segment with a parabola.