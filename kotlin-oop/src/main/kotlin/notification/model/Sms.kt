package notification.model

data class Sms(override val message: String) : Notification()