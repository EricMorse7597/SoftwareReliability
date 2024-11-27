import pytest
from scientific_calculator import (
    add, subtract, multiply, divide, power, square_root, absolute_value, factorial,
    log, ln, hypotenuse, sin, cos, tan, arcsin, arccos, arctan,
    sinh, cosh, tanh, radians, degrees, combination, permutation
)
import math

def test_add_floats():
    assert add(1.5, 2.3) == pytest.approx(3.8)

def test_add_large_numbers():
    assert add(1e10, 1e10) == 2e10

def test_add_small_numbers():
    assert add(1e-10, 1e-10) == pytest.approx(2e-10)

def test_add_negative():
    assert add(-5, -10) == -15

def test_add_mixed_sign():
    assert add(-5, 5) == 0

def test_subtract_large_numbers():
    assert subtract(1e10, 1e9) == 9e9

def test_subtract_negative_result():
    assert subtract(5, 10) == -5

def test_multiply_zero():
    assert multiply(0, 100) == 0

def test_multiply_large_numbers():
    assert multiply(1e10, 1e5) == 1e15

def test_divide_large_result():
    assert divide(1e15, 1e5) == 1e10

def test_divide_negative_result():
    assert divide(-10, 5) == -2

def test_divide_small_divisor():
    assert divide(10, 1e-5) == pytest.approx(1e6)

def test_power_large_exponent():
    assert power(2, 30) == 2**30

def test_power_fractional_exponent():
    assert power(9, 0.5) == 3

def test_power_zero_base():
    assert power(0, 5) == 0

def test_square_root_zero():
    assert square_root(0) == 0

def test_square_root_large_number():
    assert square_root(1e8) == 1e4

def test_square_root_edge_case():
    with pytest.raises(ValueError):
        square_root(-1e-10)

def test_absolute_value_large_number():
    assert absolute_value(-1e10) == 1e10

def test_absolute_value_zero():
    assert absolute_value(0) == 0

def test_factorial_large_number():
    assert factorial(10) == 3628800

def test_factorial_zero():
    assert factorial(0) == 1

def test_log_base_zero():
    with pytest.raises(ValueError):
        log(10, 0)

def test_log_negative_input():
    with pytest.raises(ValueError):
        log(-10)

def test_ln_small_input():
    assert ln(1e-10) == pytest.approx(-23.02585, rel=1e-5)

def test_hypotenuse_large_values():
    assert hypotenuse(1e5, 1e5) == pytest.approx(141421.356)

def test_sin_negative_angle():
    assert sin(-90) == pytest.approx(-1)

def test_sin_full_circle():
    assert sin(360) == pytest.approx(0)

def test_cos_large_angle():
    assert cos(720) == pytest.approx(1)

def test_tan_full_circle():
    assert tan(360) == pytest.approx(0)

def test_arcsin_edge():
    assert arcsin(-1) == pytest.approx(-90)

def test_arccos_edge():
    assert arccos(1) == 0

def test_arctan_large_input():
    assert arctan(1e5) == pytest.approx(89.9994, rel=1e-3)

def test_sinh_large_value():
    assert sinh(20) == pytest.approx(242582597)

def test_cosh_large_value():
    assert cosh(20) == pytest.approx(242582597)

def test_radians_full_circle():
    assert radians(360) == pytest.approx(2 * math.pi)

def test_degrees_full_circle():
    assert degrees(2 * math.pi) == 360

def test_combination_large_n_r():
    assert combination(100, 50) == pytest.approx(1.008913e29, rel=1e-3)

def test_permutation_large_n_r():
    assert permutation(20, 10) == pytest.approx(670442572800)

def test_combination_edge():
    with pytest.raises(ValueError):
        combination(-1, 5)

def test_arcsin_invalid_input():
    with pytest.raises(ValueError):
        arcsin(2)

def test_arccos_invalid_input():
    with pytest.raises(ValueError):
        arccos(-2)

def test_square_root_negative():
    with pytest.raises(ValueError):
        square_root(-16)

def test_tan_undefined():
    with pytest.raises(ValueError):
        tan(90)

def test_combination_extremely_large():
    assert combination(500, 250) == pytest.approx(1.1697367e+149, rel=1e-2)

def test_permutation_zero_r():
    assert permutation(5, 0) == 1

def test_add_large_negative_numbers():
    assert add(-1e15, -1e15) == -2e15

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

# def test_factorial_stress():
#     with pytest.raises(OverflowError):
#         factorial(100000000000)

# def test_sinh_stress_large():
#     assert sinh(1e2) == pytest.approx(math.sinh(100), rel=1e-4)

# def test_cosh_stress_large():
#     assert cosh(1e2) == pytest.approx(math.cosh(100), rel=1e-4)
