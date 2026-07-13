package collectionsandsequences

import com.epam.training.kotlin.collectionsandsequences.MapFilterFlatMapAssociateGroupBy
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [MapFilterFlatMapAssociateGroupBy].
 */
class MapFilterFlatMapAssociateGroupByTest {

    private val solution = MapFilterFlatMapAssociateGroupBy()

    @Test
    fun processMapTest() {
        val strings = listOf("abc", " def   ", "  Ghi", " JKL ", " m N o ")

        val expectedResult = listOf("ABC", "DEF", "GHI", "JKL", "M N O")
        val actualResult = solution.processMap(strings)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processFilterTest() {
        val ints = listOf(-100, null, -33, -1, 0, 13, 24, 26, null, 45, 99)

        val expectedResult = listOf(0, 24, 26)
        val actualResult = solution.processFilter(ints)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processFlatMapTest() {
        val pairs =
            listOf(Pair("0", listOf()), Pair("1", listOf("10", "11", "12")), Pair("2", listOf("20", "21", "22")))

        val expectedResult = listOf("10", "11", "12", "20", "21", "22")
        val actualResult = solution.processFlatMap(pairs)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processAssociateTest() {
        val ints = listOf(1, 2, 3, 4, 5)

        val expectedResult = mapOf("1" to 1, "2" to 4, "3" to 9, "4" to 16, "5" to 25)
        val actualResult = solution.processAssociate(ints)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processAssociateByTest() {
        val strings = listOf("a", "bcde", "fg", "hijklm", "nmopqrs", "tuf")

        val expectedResult = mapOf(1 to "a", 2 to "fg", 3 to "tuf", 4 to "bcde", 6 to "hijklm", 7 to "nmopqrs")
        val actualResult = solution.processAssociateBy(strings)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processAssociateWithTest() {
        val strings = listOf("bcde", "hijklm", "a", "tuf", "fg", "nmopqrs")

        val expectedResult = mapOf("a" to 1, "bcde" to 4, "fg" to 2, "hijklm" to 6, "nmopqrs" to 7, "tuf" to 3)
        val actualResult = solution.processAssociateWith(strings)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processGroupByTest() {
        val ints = listOf(-31, -16, -8, 0, 7, 8, 12, 15)

        val expectedResult = mapOf(true to listOf(-16, -8, 0, 8, 12), false to listOf(-31, 7, 15))
        val actualResult = solution.processGroupBy(ints)

        assertEquals(expectedResult, actualResult)

    }
}
