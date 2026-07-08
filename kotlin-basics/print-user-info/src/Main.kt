fun printUserInfo(name: String?) {
    // Use the elvis operator (?:) to print a display name (if null, use "Guest")
    val displayName = name ?: "Guest"
    println("Display Name: $displayName")

    // Use a safe call (?.) to print the name length
    val nameLength = name?.length
    println("Name Length: $nameLength")

    // Use an if statement and smart cast to handle uppercase or "No name provided"
    if (name != null) {
        println("Uppercase Name: ${name.uppercase()}")
    } else {
        println("No name provided")
    }
}

fun main() {
    printUserInfo("Michael Jackson")
    println()
    printUserInfo(null)
}