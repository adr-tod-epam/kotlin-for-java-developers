package com.epam.training.kotlin.functionsandlambdas

/**
 * Goal: call the function sendNotification() using named arguments in multiple ways.
 */
class NamedAndDefaultArgs {

    /**
     * Call the function sendNotification() using named arguments in multiple ways and implement unit tests in
     * NamedAndDefaultArgsTest:
     *  1) Only required argument, everything else default.
     *  2) Mix of positional + named arguments.
     *  3) Named arguments in a custom order.
     *  4) Skipping some optional arguments but overriding others.

     *  Trainees should observe how default parameter values simplify function calls and how named arguments make those calls
     *  clearer, more flexible, and independent of parameter order.
     *
     *  Verify NamedAndDefaultArgsTest.
     */
    fun sendNotification(
        recipient: String,
        subject: String = "No subject",
        body: String = "Hello!",
        priority: Int = 1,
        urgent: Boolean = false,
        includeFooter: Boolean = true
    ): String = """
        Sending email to: $recipient
        Subject: $subject
        Body: $body
        Priority: $priority
        Urgent: $urgent
        Include footer: $includeFooter
    """.trimIndent()
}
