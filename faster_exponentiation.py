import math
import time


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


def speed_test(functions):
    print("Speed test:")
    for func in functions:
        start_time = time.perf_counter()
        for i in range(1, 100):
            for j in range(1, 1000):
                func(i, j)
        finish_time = time.perf_counter()
        time_taken = round(finish_time - start_time, 3)
        print(func.__name__, "finished in", time_taken, "seconds")
    print("Speed test complete")


def accuracy_test(functions):
    passed = True
    for i in range(1, 100):
        for j in range(1, 100):
            answer = functions[0](i, j)
            for func in functions:
                if not func(i, j) == answer:
                    print("Accuracy test failed on", i, "to the power of", j)
                    passed = False
    print("Accuracy Test:", "PASSED" if passed else "FAILED")


if __name__ == "__main__":
    two_functions = [traditional_exponentiation, binary_exponentiation]
    accuracy_test(two_functions)
    speed_test(two_functions)
