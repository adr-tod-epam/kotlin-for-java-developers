package notification.service

import notification.model.Email
import notification.model.Notification
import notification.model.Push
import notification.model.Sms

class NotificationService {

    fun send(notification: Notification) {
        when (notification) {
            is Email -> println("Sending email: ${notification.message}")
            is Sms -> println("Sending SMS: ${notification.message}")
            is Push -> println("Sending push: ${notification.message}")
        }
    }
}