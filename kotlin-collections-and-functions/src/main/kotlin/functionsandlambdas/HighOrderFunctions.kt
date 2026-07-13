package com.epam.training.kotlin.functionsandlambdas

/**
 * Goal: implement higher-order functions that accept other functions as parameters or return them.
 *
 * Tasks:
 *  1) Implement a function filterAndTransform(). The function:
 *      - accepts a list of Integers, a predicate (Integer), a transformer (from Integer to Integer)
 *      - returns a list of Integers
 *      - applies the predicate to the list
 *      - transform all list elements with the help of the transformer
 *      - implement unit tests
 *  2) Implement a function aggregate(). The function:
 *      - accepts a String named 'operation'
 *      - based on 'operation' returns another function that takes a list of Integers and returns an Integer:
 *          1. if 'operation' == "sum" this result function should sum the list
 *          2. if 'operation' == "max" this result function should find the max value (or 0 if the list is empty)
 *          3. if 'operation' == "count" this result function should find the list size
 *          4. otherwise [IllegalArgumentException] should be thrown
 *      - implement unit tests
 *
 *      Verify HighOrderFunctionsTest.
 */
class HighOrderFunctions {

    fun filterAndTransform(list: List<Int>, predicate: (Int) -> Boolean, transformer: (Int) -> Int): List<Int> {
        return list
            .filter(predicate)
            .map(transformer)
    }

    fun aggregate(operation: String): (List<Int>) -> Int {
        return when (operation) {
            "sum" -> { list -> list.sum() }
            "max" -> { list -> list.maxOrNull() ?: 0 }
            "count" -> { list -> list.size }
            else -> throw IllegalArgumentException("Unsupported operation: $operation")
        }
    }
}