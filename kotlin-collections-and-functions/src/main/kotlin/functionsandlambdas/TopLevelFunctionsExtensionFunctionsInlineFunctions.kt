package com.epam.training.kotlin.functionsandlambdas

/**
 * Goal: to simplify the codebase by moving reusable helpers to top-level functions, adding extension
 *  functions to make the API more natural, using inline functions to eliminate overhead for small higher-order
 *  utilities.
 *
 *  Implement a top level String extension function that parses a String and validates if it's a good password.
 *  Criteria:
 *      1) password length must be greater than 10 symbols
 *      2) password must contain at least one uppercase letter
 *      3) password must contain at least one lowercase letter
 *      4) password must contain at least one character that is neither a number nor a letter
 *
 *  Verify the test TopLevelFunctionsExtensionFunctionsInlineFunctionsTest (uncomment the lines).
 */
class TopLevelFunctionsExtensionFunctionsInlineFunctions {

    /**
     * Convert the function to 'inline' function.
     * Implement the logic: measure the function call time and return its result.
     */
    inline fun measure(block: () -> Int): Int {
        val startTime = System.currentTimeMillis()
        val result = block()
        val endTime = System.currentTimeMillis()
        println("Execution time: ${endTime - startTime} ms")
        return result
    }
}

fun String.isStrongPassword(): Boolean {
    if (this.length <= 10) return false
    if (!this.any { it.isUpperCase() }) return false
    if (!this.any { it.isLowerCase() }) return false
    if (!this.any { !it.isLetterOrDigit() }) return false
    return true
}