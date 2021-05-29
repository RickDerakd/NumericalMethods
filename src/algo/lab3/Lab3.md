
#Dichotomy method
####the algorithm is implemented in class [DichotomySolution](./DichotomySolution.java)

To begin, the user specifies the range in which the roots will be searched. 
Then, in steps of 0.1, the values of the range are checked,
at the intersection of the graph with the X-axis, i.e. at what intervals
are the zeros of the function or the root. Each such interval is checked by a dichotomy method. 
On each such interval, the values of X are sought at a given accuracy
by finding the average value between the ends of the 
interval and substituting this value into the equation.

###Checking root isolation interval

We start checking from the second iteration if f(x)
previous from list of f(x) on each iteration < 0 , and f(x) now > 0,
or vice versa, then we found intervals where exists roots after that 
we find the root on each interval.

###Implementation

On first iteration, we define variables "left" and "right" "boarders",
"x" that equals (left + right) / 2 "f(a)" and "f(x)" , and "multiple" 
f(x) and f(a) on second and other iteration we define "left border" the "x"
if multiple >= 0 and define "right border" the "x" if multiple < 0, 
we make calculation while modulus f(x) < epsilon, 
where epsilon it is our accuracy that equals 0,0001.