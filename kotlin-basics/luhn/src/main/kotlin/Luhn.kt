object Luhn {

    fun isValid(candidate: String): Boolean {
        val cleaned = candidate.replace(" ", "")

        if (cleaned.length <= 1) {
            return false
        }

        var sum = 0
        var shouldDouble = false
        for (i in cleaned.length - 1 downTo 0) {
            val char = cleaned[i]
            if (!char.isDigit()) {
                return false
            }
            var digit = char - '0'
            if (shouldDouble) {
                digit *= 2
                if (digit > 9) {
                    digit -= 9
                }
            }
            sum += digit
            shouldDouble = !shouldDouble
        }
        return sum % 10 == 0
    }
}