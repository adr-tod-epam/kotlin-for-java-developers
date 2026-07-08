import kotlin.math.floor
import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()

    val hitpoints: Int = 10 + modifier(constitution)

    companion object {
        
        fun ability(): Int {
            val rolls = mutableListOf<Int>()
            for (i in 1..4) {
                rolls.add(Random.nextInt(1, 7))
            }

            rolls.sort()

            val sumOfTopThree = rolls[1] + rolls[2] + rolls[3]
            return sumOfTopThree
        }

        fun modifier(score: Int): Int {
            val result = floor((score - 10) / 2.0)
            return result.toInt()
        }
    }
}