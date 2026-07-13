package com.epam.training.kotlin.collectionsandsequences

/**
 * Goal: Understand the difference between immutable and mutable Kotlin collections, how they behave and how
 * modifications affect them.
 */
class ImmutableVsMutableCollections {

    /** Implement the function
     * processInts (ints: List<Int>, intToAdd: Int, intToFilter: Int): Pair<List<Int>, MutableList<Int>>:
     *  1) Try to modify this list (e.g., add/remove/change elements).
     *      - Observe what happens: Kotlin should prevent modifications.
     *  2) Create a mutable copy of this list.
     *  4) Perform the following operations on the mutable collection:
     *      - Add 'intToAdd'.
     *      - Remove the elements if <= intToFilter.
     *      - Increase all ints by 5.
     *  5) Return a Pair containing:
     *      - The original immutable list.
     *      - The modified mutable list.

     *   The trainee should see the difference:
     *       - The immutable list remains unchanged.
     *       - The mutable list is successfully modified.
     *
     * Verify the test ImmutableVsMutableCollectionsTest.
     */
    fun processInts(ints: List<Int>, intToAdd: Int, intToFilter: Int): Pair<List<Int>, MutableList<Int>> {
        val mutableList = ints.toMutableList()
        mutableList.add(intToAdd)
        mutableList.removeAll { it <= intToFilter }
        for (i in mutableList.indices) {
            mutableList[i] = mutableList[i] + 5
        }
        return Pair(ints, mutableList)
    }
}
