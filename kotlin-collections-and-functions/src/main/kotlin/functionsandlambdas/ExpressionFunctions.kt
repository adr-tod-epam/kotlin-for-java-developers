package com.epam.training.kotlin.functionsandlambdas

/**
 * Goal: implement the methods using concise expression functions, improving readability and reducing
 * boilerplate.

 * Trainees should observe how expression functions reduce boilerplate by replacing block bodies with a single clean
 * expression while keeping the function fully understandable.
 *
 * Verify the test ExpressionFunctionsTest.
 */
class ExpressionFunctions {

    /**
     * The method should return the maximum value.
     */
    fun max(a: Int, b: Int): Int = if (a > b) a else b

    /**
     * Verify the provided string is a valid email (to check that email contains '@' and '.' is enough for this task).
     */
    fun isValidEmail(email: String): Boolean = email.contains("@") && email.contains(".")

    /**
     * Return a full name. Example: first = "John", second = "Doe", result -> "John Doe".
     */
    fun fullName(first: String, last: String): String = "$first $last"

    /**
     * The result should be the square of the number.
     */
    fun square(n: Int): Int = n * n
}
