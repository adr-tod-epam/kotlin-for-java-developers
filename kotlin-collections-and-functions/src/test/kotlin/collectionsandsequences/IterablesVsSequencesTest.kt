package collectionsandsequences

import com.epam.training.kotlin.collectionsandsequences.IterablesVsSequences
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [IterablesVsSequences].
 */
class IterablesVsSequencesTest {

    @Test
    fun processCountersTest() {
        assertEquals(Pair(5000, 5), IterablesVsSequences().processCounters())
    }
}
