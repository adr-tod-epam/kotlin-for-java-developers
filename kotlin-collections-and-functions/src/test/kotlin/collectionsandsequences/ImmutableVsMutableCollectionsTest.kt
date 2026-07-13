package collectionsandsequences

import com.epam.training.kotlin.collectionsandsequences.ImmutableVsMutableCollections
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [ImmutableVsMutableCollections].
 */
class ImmutableVsMutableCollectionsTest {

    private val solution = ImmutableVsMutableCollections();

    @Test
    fun processIntsTest1() {
        val expectedResult = Pair(emptyList<Int>(), mutableListOf<Int>())
        val actualResult = solution.processInts(emptyList(), 0, 0)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processIntsTest2() {
        val expectedResult = Pair(emptyList<Int>(), mutableListOf<Int>())
        val actualResult = solution.processInts(emptyList(), 5, 10)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processIntsTest3() {
        val ints = listOf(10, 20, 30, 40)

        val expectedResult = Pair(ints, mutableListOf(45, 55))
        val actualResult = solution.processInts(ints, 50, 30)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processIntsTest4() {
        val ints = listOf(10, 20, 30, 40)

        val expectedResult = Pair(ints, mutableListOf(45, 55))
        val actualResult = solution.processInts(ints, 50, 30)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun processIntsTest5() {
        val ints = listOf(10, 20, 30, 40)

        val expectedResult = Pair(ints, mutableListOf(15, 25, 35, 45, 55))
        val actualResult = solution.processInts(ints, 50, 5)

        assertEquals(expectedResult, actualResult)
    }
}
