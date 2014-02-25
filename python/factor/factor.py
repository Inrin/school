#!/usr/bin/python

from math import sqrt
def factor(n) -> "int list":
    """Return factors of prime numbers"""

    factors = []

    while n > 1:
        for i in range(1, int(n**0.5)):
            if n%i == 0:
                factors.append(i)
                n /= i
                break

    return factors

print(factor(102))
