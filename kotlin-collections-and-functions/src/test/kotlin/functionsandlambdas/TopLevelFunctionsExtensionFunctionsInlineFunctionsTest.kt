package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.TopLevelFunctionsExtensionFunctionsInlineFunctions
import com.epam.training.kotlin.functionsandlambdas.isStrongPassword
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit test for [TopLevelFunctionsExtensionFunctionsInlineFunctions].
 */
class TopLevelFunctionsExtensionFunctionsInlineFunctionsTest {

    @Test
    fun measureTest() {
        assertEquals(
            17,
            TopLevelFunctionsExtensionFunctionsInlineFunctions().measure { sumOfDigits("Apples: 3, Bananas: 9, Oranges: 5") })
    }

    @Test
    fun isStrongPasswordTest1() {
        // "weekPass_1" - only 9 characters (< 10), should fail
        assertFalse("weekPass_1".isStrongPassword())
    }

    @Test
    fun isStrongPasswordTest2() {
        // "week pasword_1" - has space (neither letter nor digit), but missing uppercase
        assertFalse("week pasword_1".isStrongPassword())
    }

    @Test
    fun isStrongPasswordTest3() {
        // "WEEK_PASSWORD_1" - all uppercase, missing lowercase
        assertFalse("WEEK_PASSWORD_1".isStrongPassword())
    }

    @Test
    fun isStrongPasswordTest4() {
        // "weekPassword1" - missing special character (neither letter nor digit)
        assertFalse("weekPassword1".isStrongPassword())
    }

    @Test
    fun isStrongPasswordTest5() {
        // "strongPassword_1" - meets all criteria: length > 10, has upper, lower, and special char
        assertTrue("strongPassword_1".isStrongPassword())
    }

    fun sumOfDigits(input: String): Int {
        return input
            .filter { it.isDigit() }
            .sumOf { it.digitToInt() }
    }
}