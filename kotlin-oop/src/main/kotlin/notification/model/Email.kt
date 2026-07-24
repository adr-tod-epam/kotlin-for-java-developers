package notification.model

data class Email(override val message: String) : Notification()