package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.OperatorOverloading
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [OperatorOverloading].
 */
class OperatorOverloadingTest {

    private val solution = OperatorOverloading()

    @Test
    fun concatenationTest() {
        assertEquals(Pair(3, 9), solution.concatenation(Pair(2, 5), Pair(1, 4)))
    }

    @Test
    fun substractionTest() {
        assertEquals(Pair(3, 6), solution.substraction(Pair(7, 8), Pair(4, 2)))
    }

    @Test
    fun multiplicationTest() {
        assertEquals(Pair(6, 15), solution.multiplication(Pair(2, 5), 3))
    }

    @Test
    fun negationTest() {
        assertEquals(Pair(9, -5), solution.negation(Pair(-9, 5)))
    }
}
