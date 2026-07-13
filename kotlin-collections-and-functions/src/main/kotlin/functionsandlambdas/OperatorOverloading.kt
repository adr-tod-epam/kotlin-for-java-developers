package com.epam.training.kotlin.functionsandlambdas

/**
 * Goal: refactor the code to use operator overloading, allowing natural expressions like v1 + v2, v1 - v2, v1 * 3.0
 * and -v1.
 *
 * Verify the test OperatorOverloadingTest.
 */
class OperatorOverloading {

    fun concatenation(first: Pair<Int, Int>, second: Pair<Int, Int>): Pair<Int, Int> {
        return first + second
    }

    fun substraction(first: Pair<Int, Int>, second: Pair<Int, Int>): Pair<Int, Int> {
        return first - second
    }

    fun multiplication(pair: Pair<Int, Int>, scaleFactor: Int): Pair<Int, Int> {
        return pair * scaleFactor
    }

    fun negation(pair: Pair<Int, Int>): Pair<Int, Int> {
        return -pair
    }
}

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(this.first + other.first, this.second + other.second)
}

operator fun Pair<Int, Int>.minus(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(this.first - other.first, this.second - other.second)
}

operator fun Pair<Int, Int>.times(scaleFactor: Int): Pair<Int, Int> {
    return Pair(this.first * scaleFactor, this.second * scaleFactor)
}

operator fun Pair<Int, Int>.unaryMinus(): Pair<Int, Int> {
    return Pair(-this.first, -this.second)
}
