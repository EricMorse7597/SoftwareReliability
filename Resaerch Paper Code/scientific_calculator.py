import math

# Basic operations
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

# Advanced operations
def power(base, exp):
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
