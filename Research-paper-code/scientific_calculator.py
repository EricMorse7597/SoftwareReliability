import math

# basic operations from assignment
def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    if b == 0:
        raise ValueError("Cannot divide by zero")
    return a / b

# extended operations for scientific calculator for research paper
def power(base, exp):
    if base < 0 and not isinstance(exp, int):
      raise ValueError("Cannot raise a negative number to a non-integer power")
    return base ** exp

def square_root(x):
    if x < 0:
        raise ValueError("Cannot calculate the square root of a negative number")
    return math.sqrt(x)

def log(x, base=math.e):
    if x <= 0:
        raise ValueError("Logarithm undefined for non-positive values")
    return math.log(x, base)

def sin(x):
    return math.sin(math.radians(x))

def cos(x):
    return math.cos(math.radians(x))

def tan(x):
    if x % 180 == 90:
        raise ValueError("Tangent undefined at odd multiples of 90 degrees")
    return math.tan(math.radians(x))

def arcsin(x):
    if not -1 <= x <= 1:
        raise ValueError("arcsin is only defined for values between -1 and 1")
    return math.degrees(math.asin(x))

def arccos(x):
    if not -1 <= x <= 1:
        raise ValueError("arccos is only defined for values between -1 and 1")
    return math.degrees(math.acos(x))

def arctan(x):
    return math.degrees(math.atan(x))

def ln(x):
    return log(x, base=math.e)

def hypotenuse(a, b):
    return math.hypot(a, b)

def sinh(x):
    return math.sinh(x)

def cosh(x):
    return math.cosh(x)

def tanh(x):
    return math.tanh(x)

def radians(deg):
    return math.radians(deg)

def degrees(rad):
    return math.degrees(rad)

def combination(n, r):
    if n < 0 or r < 0 or r > n:
        raise ValueError("Invalid inputs for combination")
    return math.comb(n, r)

def permutation(n, r):
    if n < 0 or r < 0 or r > n:
        raise ValueError("Invalid inputs for permutation")
    return math.perm(n, r)

def absolute_value(x):
    return abs(x)

def factorial(n):
    if n < 0:
        raise ValueError("Factorial is not defined for negative numbers")
    return math.factorial(n)
