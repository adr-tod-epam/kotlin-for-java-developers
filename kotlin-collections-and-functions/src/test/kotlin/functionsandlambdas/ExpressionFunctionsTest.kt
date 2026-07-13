package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.ExpressionFunctions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit test for [ExpressionFunctions].
 */
class ExpressionFunctionsTest {

    private val solution = ExpressionFunctions()

    @Test
    fun maxTest1() {
        assertEquals(solution.max(5, 3), 5)
    }

    @Test
    fun maxTest2() {
        assertEquals(solution.max(1, 4), 4)
    }

    @Test
    fun isValidEmailTest1() {
        assertTrue(solution.isValidEmail("test@email.com"))
    }

    @Test
    fun isValidEmailTest2() {
        assertFalse(solution.isValidEmail("invalid_email.com"))
    }

    @Test
    fun fullNameTest() {
        assertEquals("John Doe", solution.fullName(first = "John", last = "Doe"))
    }

    @Test
    fun squareTest() {
        assertEquals(25, solution.square(5))
    }
}
