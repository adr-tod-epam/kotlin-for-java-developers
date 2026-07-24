package notification.model

sealed class Notification {
    abstract val message: String
}