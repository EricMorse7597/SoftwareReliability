import pytest
from scientific_calculator import (
    add, subtract, multiply, divide, power, square_root, absolute_value, factorial,
    log, ln, hypotenuse, sin, cos, tan, arcsin, arccos, arctan,
    sinh, cosh, tanh, radians, degrees, combination, permutation
)
import math

def test_add_mixed_large_numbers():
    assert add(1e15, -1e15) == 0

def test_add_small_fractions():
    assert add(1e-15, 2e-15) == pytest.approx(3e-15)

def test_add_large_and_small():
    assert add(1e10, 1e-10) == pytest.approx(1e10)

def test_subtract_large_and_small():
    assert subtract(1e10, 1e-10) == pytest.approx(1e10)

def test_subtract_same_values():
    assert subtract(1e10, 1e10) == 0

def test_multiply_negative_large_numbers():
    assert multiply(-1e10, -1e10) == 1e20

def test_multiply_small_fractions():
    assert multiply(1e-10, 1e-10) == pytest.approx(1e-20)

def test_multiply_large_and_small():
    assert multiply(1e10, 1e-10) == pytest.approx(1)

def test_divide_large_by_small():
    assert divide(1e20, 1e-10) == pytest.approx(1e30)

def test_divide_negative_by_positive():
    assert divide(-1e10, 2) == -5e9

def test_power_negative_base_even_exponent():
    assert power(-2, 2) == 4

def test_power_negative_base_odd_exponent():
    assert power(-2, 3) == -8

def test_power_fractional_base():
    assert power(0.5, 2) == 0.25

def test_power_fractional_exponent_negative_base():
    with pytest.raises(ValueError):
        power(-4, 0.5)

def test_power_large_exponent_small_base():
    assert power(1e-5, 1e5) == pytest.approx(0)

def test_square_root_large_input():
    assert square_root(1e10) == pytest.approx(1e5)

def test_factorial_one():
    assert factorial(1) == 1

def test_factorial_large_number():
    assert factorial(20) == 2432902008176640000

def test_sin_large_angle():
    assert sin(1080) == pytest.approx(0) 

def test_sin_negative_large_angle():
    assert sin(-1080) == pytest.approx(0)

def test_cos_large_angle():
    assert cos(1080) == pytest.approx(1) 

def test_cos_negative_large_angle():
    assert cos(-1080) == pytest.approx(1)

def test_tan_large_angle():
    assert tan(1080) == pytest.approx(0)

def test_tan_negative_large_angle():
    assert tan(-1080) == pytest.approx(0)

def test_arcsin_edge_case():
    assert arcsin(0) == 0

def test_arccos_edge_case():
    assert arccos(0) == pytest.approx(90)

def test_arctan_large_positive():
    assert arctan(1e10) == pytest.approx(90)

def test_arctan_large_negative():
    assert arctan(-1e10) == pytest.approx(-90)

def test_sinh_negative():
    assert sinh(-5) == pytest.approx(-74.2032, rel=1e-4)

def test_cosh_negative():
    assert cosh(-5) == pytest.approx(74.2099, rel=1e-4)

def test_tanh_large_positive():
    assert tanh(1e5) == pytest.approx(1)

def test_tanh_large_negative():
    assert tanh(-1e5) == pytest.approx(-1)

def test_log_base_ten():
    assert log(100, 10) == 2

def test_log_large_number():
    assert log(1e50, 10) == pytest.approx(50)

def test_log_small_fraction():
    assert log(1e-5, 10) == pytest.approx(-5)

def test_ln_large_number():
    assert ln(1e50) == pytest.approx(115.129, rel=1e-3)

def test_ln_small_fraction():
    assert ln(1e-50) == pytest.approx(-115.129, rel=1e-3)

def test_absolute_value_large_negative():
    assert absolute_value(-1e20) == 1e20

def test_absolute_value_small_negative():
    assert absolute_value(-1e-20) == pytest.approx(1e-20)

def test_radians_edge_case():
    assert radians(0) == 0

def test_degrees_edge_case():
    assert degrees(0) == 0

def test_hypotenuse_large_values():
    assert hypotenuse(1e10, 1e10) == pytest.approx(math.sqrt(2) * 1e10)

def test_hypotenuse_small_values():
    assert hypotenuse(1e-10, 1e-10) == pytest.approx(math.sqrt(2) * 1e-10)

def test_log_huge_input():
    assert log(1e100, 10) == pytest.approx(100)

def test_factorial_stress():
    with pytest.raises(OverflowError):
        factorial(100000000000)

def test_sinh_stress_large():
    assert sinh(1e2) == pytest.approx(math.sinh(100), rel=1e-4)

def test_cosh_stress_large():
    assert cosh(1e2) == pytest.approx(math.cosh(100), rel=1e-4)
