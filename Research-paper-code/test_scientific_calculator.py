# test commit
import pytest
from scientific_calculator import (
    add, subtract, multiply, divide,
    power, square_root, log, sin, cos, tan
)

# Basic operations
def test_add():
    assert add(3, 5) == 8
    assert add(-1, 1) == 0
    assert add(0, 0) == 0

def test_subtract():
    assert subtract(10, 5) == 5
    assert subtract(0, 3) == -3
    assert subtract(-2, -4) == 2

def test_multiply():
    assert multiply(4, 3) == 12
    assert multiply(-1, 5) == -5
    assert multiply(0, 100) == 0

def test_divide():
    assert divide(10, 2) == 5
    assert divide(9, 3) == 3
    with pytest.raises(ValueError):
        divide(5, 0)

# Advanced operations
def test_power():
    assert power(2, 3) == 8
    assert power(5, 0) == 1
    assert power(-2, 3) == -8

def test_square_root():
    assert square_root(9) == 3
    assert square_root(0) == 0
    with pytest.raises(ValueError):
        square_root(-4)

def test_log():
    assert log(math.e) == 1
    assert log(100, 10) == pytest.approx(2)
    with pytest.raises(ValueError):
        log(0)

def test_sin():
    assert sin(0) == 0
    assert sin(90) == pytest.approx(1)
    assert sin(45) == pytest.approx(0.707, 0.001)

def test_cos():
    assert cos(0) == 1
    assert cos(90) == pytest.approx(0, 0.001)
    assert cos(60) == pytest.approx(0.5, 0.001)

def test_tan():
    assert tan(0) == 0
    assert tan(45) == pytest.approx(1)
    with pytest.raises(ValueError):
        tan(90)
