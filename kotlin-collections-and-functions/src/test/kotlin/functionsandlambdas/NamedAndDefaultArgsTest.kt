package functionsandlambdas

import com.epam.training.kotlin.functionsandlambdas.NamedAndDefaultArgs
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test for [NamedAndDefaultArgs].
 */
class NamedAndDefaultArgsTest {

    private val solution = NamedAndDefaultArgs()

    @Test
    fun sendNotificationTest_onlyRequiredArgument() {
        val result = solution.sendNotification(recipient = "user@example.com")

        val expected = """
            Sending email to: user@example.com
            Subject: No subject
            Body: Hello!
            Priority: 1
            Urgent: false
            Include footer: true
        """.trimIndent()

        assertEquals(expected, result)
    }

    @Test
    fun sendNotificationTest_mixOfPositionalAndNamed() {
        val result = solution.sendNotification(
            "user@example.com",
            subject = "Important Update"
        )

        val expected = """
            Sending email to: user@example.com
            Subject: Important Update
            Body: Hello!
            Priority: 1
            Urgent: false
            Include footer: true
        """.trimIndent()

        assertEquals(expected, result)
    }

    @Test
    fun sendNotificationTest_namedArgumentsCustomOrder() {
        val result = solution.sendNotification(
            urgent = true,
            priority = 3,
            recipient = "user@example.com",
            body = "This is urgent!"
        )

        val expected = """
            Sending email to: user@example.com
            Subject: No subject
            Body: This is urgent!
            Priority: 3
            Urgent: true
            Include footer: true
        """.trimIndent()

        assertEquals(expected, result)
    }

    @Test
    fun sendNotificationTest_skippingAndOverridingArguments() {
        val result = solution.sendNotification(
            recipient = "user@example.com",
            subject = "Newsletter",
            priority = 2,
            includeFooter = false
        )

        val expected = """
            Sending email to: user@example.com
            Subject: Newsletter
            Body: Hello!
            Priority: 2
            Urgent: false
            Include footer: false
        """.trimIndent()

        assertEquals(expected, result)
    }
}