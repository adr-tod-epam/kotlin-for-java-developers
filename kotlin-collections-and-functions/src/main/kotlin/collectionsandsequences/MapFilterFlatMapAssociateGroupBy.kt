package com.epam.training.kotlin.collectionsandsequences

/**
 * Goal: practice Kotlin’s most commonly used collection transformation functions: map, filter, flatMap, associate,
 * associateBy, associateWith and groupBy.
 */
class MapFilterFlatMapAssociateGroupBy {

    /**
     * Implement the function processMap(strings: List<String>): List<String> that:
     *  1) Trim all elements.
     *  2) Make all string uppercase.
     *
     *  NOTE: use [Collection.map].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupByTest.
     */
    fun processMap(strings: List<String>): List<String> {
        return strings.map { it.trim().uppercase() }
    }

    /**
     * Implement the function processFilter(ints: List<Int?>): List<Int> that:
     *  1) Filter out null values.
     *  2) Filter out negative values ('0' is a positive value).
     *  3) Find only even numbers.
     *
     *  NOTE: use [Collection.filterNotNull] and [Collection.filter].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupBy.
     */
    fun processFilter(ints: List<Int?>): List<Int> {
        return ints
            .filterNotNull()
            .filter { it >= 0 && it % 2 == 0 }
    }

    /**
     * Implement the function processFlatMap(pairs: List<Pair<String, List<String>>>): List<String> that:
     *  1) Return a list with all elements from the pair lists.
     *
     *  NOTE: use [Collection.flatMap].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupBy.
     */
    fun processFlatMap(pairs: List<Pair<String, List<String>>>): List<String> {
        return pairs.flatMap { it.second }
    }

    /**
     * Implement the function processAssociate(ints: List<Int>): Map<String, Int> that:
     *  1) Return a map where a key is a string representation of each int and a value is a square of this value.
     *
     *  NOTE: use [Collection.associate].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupBy.
     */
    fun processAssociate(ints: List<Int>): Map<String, Int> {
        return ints.associate { it.toString() to (it * it) }
    }

    /**
     * Implement the function processAssociateBy(strings: List<String>): Map<Int, String> that:
     *  1) Return a map where a key is a string length and a value is the string itself.
     *
     *  NOTE: use [Collection.associateBy].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupBy.
     */
    fun processAssociateBy(strings: List<String>): Map<Int, String> {
        return strings.associateBy { it.length }
    }

    /**
     * Implement the function processAssociateWith(strings: List<String>): Map<String, Int> that:
     *  1) Return a map where a key is a string itself and a value is the string length.
     *
     *  NOTE: use [Collection.associateWith].
     *
     *  Verify the test MapFilterFlatMapAssociateGroupBy.
     */
    fun processAssociateWith(strings: List<String>): Map<String, Int> {
        return strings.associateWith { it.length }
    }

    /**
     * Implement the function processGroupBy(ints: List<Int>): Map<Boolean, List<Int>> that:
     *  1) Group all numbers into a map with a boolean key: true for even numbers and false for odd numbers.
     *
     *  NOTE: use [Collection.groupBy].
     *
     *  Verify the test [MapFilterFlatMapAssociateGroupBy].
     */
    fun processGroupBy(ints: List<Int>): Map<Boolean, List<Int>> {
        return ints.groupBy { it % 2 == 0 }
    }
}
