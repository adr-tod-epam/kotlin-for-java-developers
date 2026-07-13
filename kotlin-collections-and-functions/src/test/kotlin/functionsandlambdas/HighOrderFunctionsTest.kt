package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.HighOrderFunctions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Unit test for [HighOrderFunctions].
 */
class HighOrderFunctionsTest {

    private val solution = HighOrderFunctions()

    @Test
    fun filterAndTransformTest() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        val predicate: (Int) -> Boolean = { it % 2 == 0 } // even numbers
        val transformer: (Int) -> Int = { it * it } // square
        val result = solution.filterAndTransform(input, predicate, transformer)
        assertEquals(listOf(4, 16, 36), result)
    }

    @Test
    fun aggregateSumTest() {
        val sumFunction = solution.aggregate("sum")
        val result = sumFunction(listOf(1, 2, 3, 4, 5))
        assertEquals(15, result)
    }

    @Test
    fun aggregateMaxTest() {
        val maxFunction = solution.aggregate("max")
        val result = maxFunction(listOf(1, 5, 3, 2, 4))
        assertEquals(5, result)
    }

    @Test
    fun aggregateCountTest() {
        val countFunction = solution.aggregate("count")
        val result = countFunction(listOf(1, 2, 3, 4, 5))
        assertEquals(5, result)
    }

    @Test
    fun aggregateIllegalArgumentExceptionTest() {
        assertFailsWith<IllegalArgumentException> {
            solution.aggregate("average")
        }
    }
}
