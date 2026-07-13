package com.epam.training.kotlin.collectionsandsequences

/**
 * Goal: Implement a Kotlin version of the Java method processJavaStream()
 * to fix the test 'TransformationPipelinesVsJavaStreamsTest'.
 * (NOTE: List values can be nullable).
 *
 * public String processJavaStream(List<Integer> ints) {
 *         return ints.stream()
 *                 .filter(Objects::nonNull)
 *                 .filter(value -> value > 100)
 *                 .map(value -> value + 1)
 *                 .sorted(Comparator.reverseOrder())
 *                 .distinct()
 *                 .peek(System.out::println)
 *                 .limit(7)
 *                 .map(String::valueOf)
 *                 .collect(Collectors.joining(" "));
 * }
 *
 * Verify the test TransformationPipelinesVsJavaStreamsTest (uncomment the lines).
 */
class TransformationPipelinesVsJavaStreams {

    fun processJavaStream(ints: List<Int?>): String {
        return ints
            .asSequence()
            .filterNotNull()
            .filter { it > 100 }
            .map { it + 1 }
            .sortedDescending()
            .distinct()
            .onEach { println(it) }
            .take(7)
            .map { it.toString() }
            .joinToString(" ")
    }
}