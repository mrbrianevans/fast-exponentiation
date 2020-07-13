import math


def traditional_exponentiation(x, n):
    """ Perform the operation x to the power of n, using normal exponentiation"""
    answer = 1
    for i in range(n):
        answer *= x
    return answer


def binary_exponentiation(x, n):
    """Perform the operation x to the power of n, using a faster method than traditional"""
    number_of_exponents = math.floor(math.log(n, 2))
    powers = [0] * (number_of_exponents + 1)
    powers[0] = x
    for i in range(1, number_of_exponents + 1):
        powers[i] = powers[i - 1] ** 2
    answer = powers[-1]
    n -= 2 ** (len(powers) - 1)
    for i in range(number_of_exponents - 1, 0, -1):
        power_of_two = 2 ** i
        if n >= power_of_two:
            n -= power_of_two
            answer *= powers[i]
    if n:
        answer *= x
    return answer
