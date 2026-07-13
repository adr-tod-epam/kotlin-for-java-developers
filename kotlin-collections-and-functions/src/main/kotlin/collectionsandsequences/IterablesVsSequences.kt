package com.epam.training.kotlin.collectionsandsequences

/** Goal:
 * Understand how Iterable operations are eager, while Sequence operations are lazy, and how this affects performance
 * and intermediate processing.
 */
class IterablesVsSequences {

    /** Implement the function processNumbers(): Pair<Int, Int> that:
     *  1) Starts with a list of integers from 1 to 10,000.
     *  2) Applies the following transformation pipeline twice:
     *      - Filter only even numbers.
     *      - Map each number to its square and perform iterableMapCount++.
     *      - Take only the first 5 results.
     *  3) The first pipeline must use regular Iterable operations.
     *  4) The second pipeline must use Sequence operations (use another counter sequenceMapCount++).
     *  5) For each pipeline, measure how many mapping operations were actually performed.
     *  6) Return a Pair containing:
     *      - The number of maps executed without using Sequence.
     *      - The number of maps executed using Sequence.

     *   What Trainees Should Observe:
     *       - iterableMapCount = 5,000 (half of 10,000)
     *       - sequenceMapCount = 5 (only what is needed)
     *   This perfectly illustrates how Sequences avoid unnecessary intermediate transformations.
     *
     * Verify the test IterablesVsSequencesTest.
     */
    fun processCounters(): Pair<Int, Int> {
        val numbers = (1..10_000).toList()

        var iterableMapCount = 0
        var sequenceMapCount = 0

        // ITERABLE PIPELINE (EAGER)
        numbers
            .filter { it % 2 == 0 }
            .map {
                iterableMapCount++
                it * it
            }
            .take(5)

        // SEQUENCE PIPELINE (LAZY)
        numbers
            .asSequence()
            .filter { it % 2 == 0 }
            .map {
                sequenceMapCount++
                it * it
            }
            .take(5)
            .toList()

        return Pair(iterableMapCount, sequenceMapCount)
    }
}
