#!/usr/bin/python

from math import sqrt
def factor(n) -> "int list":
    """Return factors of prime numbers"""

    factors = []

    while n > 1:
        if n <= 101:
            for i in [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101]:
                if n%i == 0:
                    factors.append(i)
                    n /= i
        else:
            for i in range(102, n**0.5):
                if n%i == 0:
                    factors.append(i)
                    n /= i

    return factors
