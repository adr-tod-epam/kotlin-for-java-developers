package collectionsandsequences

import com.epam.training.kotlin.collectionsandsequences.TransformationPipelinesVsJavaStreams
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [TransformationPipelinesVsJavaStreams].
 */
class TransformationPipelinesVsJavaStreamsTest {

    @Test
    fun processJavaStream() {
        val ints = listOf(113, 24, 222, null, 345, 86, 257, 287, null, 9, 403, 184, 345, 108, 155, 100, null, 113, 303)

        val expectedResult = "404 346 304 288 258 223 185"
        val actualResult = TransformationPipelinesVsJavaStreams().processJavaStream(ints)

        assertEquals(expectedResult, actualResult)
    }
}
