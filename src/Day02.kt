fun main() {
    fun part1(input: List<Command>): Int {
        var horizontalPosition = 0
        var verticalPosition = 0;

        input.forEach {
            when (it.type) {
                CommandType.FORWARD -> horizontalPosition += it.value
                CommandType.UP -> verticalPosition -= it.value
                CommandType.DOWN -> verticalPosition += it.value
            }
        }
        return horizontalPosition * verticalPosition
    }

    fun part2(input: List<Command>): Int {
        var horizontalPosition = 0
        var verticalPosition = 0
        var aim = 0

        input.forEach {
            when (it.type) {
                CommandType.FORWARD -> {
                    horizontalPosition += it.value
                    verticalPosition += it.value * aim
                }
                CommandType.UP -> aim -= it.value
                CommandType.DOWN -> aim += it.value
            }
        }
        return horizontalPosition * verticalPosition
    }

    val input = readInput("Day02")
    val inputOfCommands = input.map {
        val (command, value) = it.split(" ")
        Command(CommandType.fromString(command), value.toInt())
    }
    println(part1(inputOfCommands))
    println(part2(inputOfCommands))
}

enum class CommandType {
    FORWARD, DOWN, UP;

    companion object {
        fun fromString(stringCommand: String) = when (stringCommand) {
            "forward" -> FORWARD
            "down" -> DOWN
            "up" -> UP
            else -> throw Exception("unknown command")
        }
    }
}
data class Command(val type: CommandType, val value: Int)
