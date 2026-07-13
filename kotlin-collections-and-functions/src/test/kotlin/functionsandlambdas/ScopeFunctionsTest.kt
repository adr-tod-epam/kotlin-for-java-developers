package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.ScopeFunctions
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [ScopeFunctions].
 */
class ScopeFunctionsTest {

    private val solution = ScopeFunctions()

    @Test
    fun processLetTest1() {
        assertEquals("List is null.", solution.processLet(null))
    }

    @Test
    fun processLetTest2() {
        assertEquals("List size is 3.", solution.processLet(listOf("aaa", "bbb", "ccc")))
    }

    @Test
    fun processApplyTest() {
        val host = "localhost"
        val port = "8080"
        val user = "admin"
        val timeout = "3000"

        val properties = solution.processApply(host = host, port = port, user = user, timeout = timeout)

        assertEquals(host, properties["host"])
        assertEquals(port, properties["port"])
        assertEquals(user, properties["user"])
        assertEquals(timeout, properties["timeout"])
    }

    @Test
    fun processRunTest() {
        assertEquals(
            "{port=8080, host=localhost, user=admin, timeout=3000}",
            solution.processRun(host = "localhost", port = "8080", user = "admin", timeout = "3000")
        )
    }

    @Test
    fun processAlsoTest() {
        val host = "localhost"
        val port = "8080"
        val user = "admin"
        val timeout = "3000"
        val properties = Properties()
        properties["host"] = host
        properties["port"] = port
        properties["user"] = user
        properties["timeout"] = timeout
        val propertyList = mutableListOf<Properties>()

        solution.processAlso(host = "localhost", port = port, user = user, timeout = timeout, properties = propertyList)

        assertEquals(propertyList, mutableListOf(properties))
    }

    @Test
    fun processWithTest() {
        assertEquals(
            "{port=8080, host=localhost, user=admin, timeout=3000}",
            solution.processWith(host = "localhost", port = "8080", user = "admin", timeout = "3000")
        )
    }
}
