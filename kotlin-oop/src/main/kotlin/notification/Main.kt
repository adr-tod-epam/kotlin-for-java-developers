package notification

import notification.model.Email
import notification.model.Push
import notification.model.Sms
import notification.service.NotificationService

fun main() {
    val notificationService = NotificationService()

    notificationService.send(Email("Michael Jackson rocks!"))
    notificationService.send(Sms("Factura DIGI a fost emisa"))
    notificationService.send(Push("You have reached your step goals!"))
}