package com.epam.training.kotlin.functionsandlambdas

import java.util.*

/**
 * Goal: Get familiar how the scope functions helps to interact with objects.
 *
 * Trainees should observe how each scope function supports a different intent—configuration (apply), side effects (also),
 * context execution (run/with), and transformations (let)—reducing repetition and improving readability.
 *
 * Verify the test ScopeFunctionsTest.
 */
class ScopeFunctions {

    /**
     * Implement the function using the scope function [let] accepting a nullable List and returns a string:
     *  1) If the list != null -> "List size is <list size>."
     *  2) If the list == null -> "List is null."
     */
    fun processLet(list: List<String>?): String {
        return list?.let { "List size is ${it.size}." } ?: "List is null."
    }

    /**
     * Implement the function using the scope function [apply] that builds a [Properties] object and set
     * the following properties:
     *  1) host ("localhost")
     *  2) port ("8080")
     *  3) user ("admin")
     *  4) timeout ("3000")
     */
    fun processApply(host: String, port: String, user: String, timeout: String): Properties {
        return Properties().apply {
            this["host"] = host
            this["port"] = port
            this["user"] = user
            this["timeout"] = timeout
        }
    }

    /**
     * Implement the function using the scope function [run] that returns a string representation
     * of a [Properties] object with the following properties:
     *  1) host ("localhost")
     *  2) port ("8080")
     *  3) user ("admin")
     *  4) timeout ("3000")
     */
    fun processRun(host: String, port: String, user: String, timeout: String): String {
        return Properties().run {
            this["host"] = host
            this["port"] = port
            this["user"] = user
            this["timeout"] = timeout
            this.toString()
        }
    }

    /**
     * Implement the function using the scope function [also] that adds to the list a [Properties] object
     * with the following properties:
     *  1) host ("localhost")
     *  2) port ("8080")
     *  3) user ("admin")
     *  4) timeout ("3000")
     */
    fun processAlso(host: String, port: String, user: String, timeout: String, properties: MutableList<Properties>) {
        Properties().also {
            it["host"] = host
            it["port"] = port
            it["user"] = user
            it["timeout"] = timeout
            properties.add(it)
        }
    }

    /**
     * Implement the function using the scope function [with] that returns a string representation
     * of a [Properties] object with the following properties:
     *  1) host ("localhost")
     *  2) port ("8080")
     *  3) user ("admin")
     *  4) timeout ("3000")
     */
    fun processWith(host: String, port: String, user: String, timeout: String): String {
        return with(Properties()) {
            this["host"] = host
            this["port"] = port
            this["user"] = user
            this["timeout"] = timeout
            this.toString()
        }
    }
}