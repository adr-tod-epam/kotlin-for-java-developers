package com.epam.learn

import kotlinx.coroutines.*

suspend fun processOrder(orderId: Int): String {
    delay(1000)
    return "Order $orderId processed"
}

fun main() = runBlocking {
    coroutineScope {
        val results = (1..10)
            .map { orderId ->
                async {
                    processOrder(orderId)
                }
            }
            .awaitAll()

        results.forEach(::println)
    }
}